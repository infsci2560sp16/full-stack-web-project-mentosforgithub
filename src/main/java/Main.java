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

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World");

    /**get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());**/
        
post("/signin", (req,res)->{
        Connection con = null;
        try{
            con = DatabaseUrl.extract().getConnection();
            JSONObject user = new JSONObject(req.body());//Use JSON to convey the message in signin
            String username = user.getString("username");
            String password = user.getString("password");
            
            String sql = "INSERT INTO Users (username,password) VALUES('"+username+"','"+password+"') ";
            con = DatabaseUrl.extract().getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Users");
            stmt.executeUpdate(sql);
            
            return req.body();
            
        }catch(Exception e){
            return e.getMessage();
        }finally{
           if (connection != null) try{connection.close();} catch(SQLException e){} 
        }
    });
    
get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
	stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Login (username varchar(50),password varchar(50)");
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Comments_cmu (username varchar(50),comments varchar(500)");
        //stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
		
        ResultSet rs = stmt.executeQuery("SELECT * FROM Comments_cmu");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
		  output.add( "Read from DB: " + rs.getTimestamp("username"));
		  output.add( "Read from DB: " + rs.getTimestamp("comments"));
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
