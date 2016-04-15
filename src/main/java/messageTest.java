/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.get;
import spark.template.freemarker.FreeMarkerEngine;
/**
 *
 * @author Mengjiao
 */
public class messageTest {
    
    Gson gson = new Gson();
    
    public messageTest(){
        setMessages();
    }
    
    private void setMessages() {
      get("/messageBoard/message", (req, res) -> {
          Map<String, Object> data = new HashMap<>();
          data.put("message1", "  goodluck");
          data.put("message2","  you can do it");
          data.put("message3","  carry on");
          data.put("message4","  relax");
          return data;
      }, gson::toJson);
      
        get("/index/hello", (req, res) -> {
          Map<String, Object> data = new HashMap<>();
          data.put("hello", "welcome to MySecret index.html");
          return data;
      }, gson::toJson);
      
      
       get("/", (request, response) -> {
//          Map<String, Object> data = new HashMap<>();
//          data.put("username", "Mengjiao");
          
          Map<String, Object> attributes = new HashMap<>();

            ArrayList<String> oddtopics = new ArrayList<String>();
            oddtopics.add("Animal");
            oddtopics.add("Beauty");
            oddtopics.add("Books");
            oddtopics.add("Television");
            ArrayList<String> eventopics = new ArrayList<String>();
            eventopics.add("Culture");
            eventopics.add("Music");
            eventopics.add("Technology");
            ArrayList<String> weektopics = new ArrayList<String>();
            weektopics.add("Cooking");
            weektopics.add("Movies");
            weektopics.add("Sports");
            weektopics.add("Travel");

            SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
            String dayOfWeek = formatter.format(new Date());
            //Testing
            System.out.println(dayOfWeek);
            System.out.println(weektopics);

            attributes.put("oddtopics", oddtopics);
            attributes.put("eventopics", eventopics);
            attributes.put("weektopics", weektopics);
            attributes.put("dayOfWeek", dayOfWeek);
          
          return new ModelAndView(attributes, "index.ftl");

      }, new FreeMarkerEngine());
      
      
      
    }
    
    
}
