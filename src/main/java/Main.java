import com.heroku.sdk.jdbc.DatabaseUrl;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;
import com.google.gson.Gson;
import org.json.JSONObject;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
    


   

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = getConnection();

        Statement stmt = connection.createStatement();

        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Usr (id int,name varchar(50),email varchar(100),passwd varchar(50))");
        //stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS moodblog(id int,name varchar(50),year int,month int,day int,weather varchar(500),location varchar(100),event varchar(500),withWho varchar(500),mood varchar(500))");
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM moodblog");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getString("name"));
          output.add( "Read from DB: " + rs.getString("mood"));
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

  private static Connection getConnection() throws URISyntaxException, SQLException {
    URI dbUri = new URI(System.getenv("DATABASE_URL"));
    int port = dbUri.getPort();
    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath();

    if (dbUri.getUserInfo() != null) {
      String username = dbUri.getUserInfo().split(":")[0];
      String password = dbUri.getUserInfo().split(":")[1];
      return DriverManager.getConnection(dbUrl, username, password);
    } else {
      return DriverManager.getConnection(dbUrl);
    }
  }

}