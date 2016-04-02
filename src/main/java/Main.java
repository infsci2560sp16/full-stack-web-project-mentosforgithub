import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

  public static void main(String[] args) {
    Configuration config = new Configuration();  
        try {  
            String path = new File("").getAbsolutePath();  
            config.setDirectoryForTemplateLoading(new File(path));  
            config.setObjectWrapper(new DefaultObjectWrapper());  
              
            Template template = config.getTemplate("sight.ftl","UTF-8");  
            //create the template
            Map root = new HashMap();  
            List<Comments_cmu> comments_cmu = new ArrayList<Comments_cmu>();  
            Comments_cmu c1 = new Comments_cmu();  
            c1.setUser("Alex");  
            u1.setComment("I like this place.");  
            comments_cmu.add(c1);  
			
            Comments_cmu c2 = new Comments_cmu();  
            c2.setUser("Boris");  
            c2.setComment("This is a famous university.");  
            comments_cmu.add(c2); 
              
            root.put("commentsList", comments_cmu);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }
  /***ftl_code**/
    
    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World");

    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  }

}
