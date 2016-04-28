import com.google.gson.Gson;
import org.json.JSONObject;

import freemarker.template.Configuration;  
import freemarker.template.DefaultObjectWrapper;  
import freemarker.template.Template; 
import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.Writer; 
//package com.bijian.study.freemark;  

import com.heroku.sdk.jdbc.DatabaseUrl;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List; 
import java.text.*;
import java.util.*;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;


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
        
 //JSON,post       
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
           if (con != null) try{con.close();} catch(SQLException e){} 
        }
    });
//JSON,post
post("/addcomment", (req, res) ->
    {
      Connection connection = null;
	  
      //Map<String, Object> attributes = new HashMap<>();
      try{
      connection = DatabaseUrl.extract().getConnection();
	  JSONObject user = new JSONObject(req.body());//Use JSON to convey the message in signin
      String username = user.getString("username");
      String comment_text = user.getString("comment");
	  String grade1 = user.getString("grade");
	  
	  int grade = Integer.parseInt(grade1);
      Statement stmt = connection.createStatement();
	  String sql = "INSERT INTO Comments (username,comment_text,grade) VALUES ('"+username+"','"+comment_text+"','"+grade+"')";
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Comments (username varchar(50),date datetime DEFAULT GETDATE(),comment_text varchar(500),grade int)");
	  stmt.executeUpdate(sql);
	  
	  return req.body();
	  
	  }catch (Exception e) {
		return e.getMessage();
     } finally {
     if (connection != null) try{connection.close();} catch(SQLException e){}
    }}, new FreeMarkerEngine()); 
    
/**JSON,get,unfinised
 get("/login", (req, res) ->
    {
      Connection connection = null;
	  
	  JSONObject user = new JSONObject(req.body());//Use JSON to convey the message in signin
      String username = user.getString("username");
      String password = user.getString("password");
	  
      Map<String, Object> attributes = new HashMap<>();
      try{
      connection = DatabaseUrl.extract().getConnection();

      Statement stmt = connection.createStatement();

      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Users (username varchar(50),password varchar(50)");
	  ResultSet rs = stmt.executeQuery("SELECT password FROM Users WHERE username ="+username);
	  String passwd = rs.getString("username");
	  
	  if(password.equals(passwd)) {
		  
	  }
	  else{
	  }
	  }catch (Exception e) {
     attributes.put("message", "There was an error: " + e);
     return new ModelAndView(attributes, "error.ftl");
     } finally {
     if (connection != null) try{connection.close();} catch(SQLException e){}
    }}, new FreeMarkerEngine()); **/
    
//XML,get
get("/api/comments", (req, res) -> {
		  
          Connection connection = null;

          Map<String, Object> attributes = new HashMap<>();
          try {
              connection = DatabaseUrl.extract().getConnection();
              Statement stmt = connection.createStatement();
              ResultSet rs = stmt.executeQuery("SELECT * FROM comments");


              String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
              xml += "<comments>";//use comments.xsd
              while (rs.next()) {
              	xml+= "<comment>";
				  	xml += "<username>"+rs.getString("username")+"</username>";
				  	xml += "<date>"+rs.getString("date")+"</date>";
					xml += "<comment_text>"+rs.getString("comment_text")+"</comment_text>";
					xml += "<grade>"+rs.getString("grade")+"</grade>";
				xml+= "</comment>";
              }
              xml += "</comments>";
              res.type("text/xml");
              return xml;

          } catch (Exception e) {
              attributes.put("message", "There was an error: " + e);
              return attributes;
          } finally {
              if (connection != null) try{connection.close();} catch(SQLException e){}
          }
        });
        
//ftl restaurants
Configuration config = new Configuration(); 
try {  
            String path = new File("").getAbsolutePath();  
            config.setDirectoryForTemplateLoading(new File(path));  
            config.setObjectWrapper(new DefaultObjectWrapper());  
              
            Template template = config.getTemplate("restaurants.ftl","UTF-8");  
            //create the template
            Map root = new HashMap();  
            List<Comments_Nicky> comments_Nicky = new ArrayList<Comments_Nicky>();  
            Comments_Nicky n1 = new Comments_Nicky();  
            n1.setUser("Alex");  
            n1.setComment("I like this place.");
			n1.setTime();
            comments_Nicky.add(n1);  
			
            Comments_Nicky n2 = new Comments_Nicky();  
            n2.setUser("Boris");  
            n2.setComment("This is a famous restaurant.");  
            comments_Nicky.add(n2);

			Comments_Nicky n3 = new Comments_Nicky();  
            n3.setUser("Chang");  
            n3.setComment("I like the chicken curry here.");  
            comments_Nicky.add(n3);
            
			Comments_Nicky n4 = new Comments_Nicky();  
            n4.setUser("Donna");  
            n4.setComment("It's a wonderful restaurant in downtwon.");  
            comments_Nicky.add(n4);
			
            root.put("commentsList", comments_Nicky);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();}
            
//db    
get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
	stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Users (username varchar(50),password varchar(50)");
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Comments (username varchar(50),date datetime DEFAULT GETDATE(),comment_text varchar(500),grade decimal(5,2)");
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
