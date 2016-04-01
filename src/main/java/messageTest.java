/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.get;
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
          data.put("message1", "goodluck");
          //data.put("you can do it", "message2");
          return data;
      }, gson::toJson);
      
        get("/index/hello", (req, res) -> {
          Map<String, Object> data = new HashMap<>();
          data.put("hello", "welcome");
          return data;
      }, gson::toJson);
      
      
       get("/index/username", (req, res) -> {
          Map<String, Object> data = new HashMap<>();
          data.put("username", "Mengjiao");
          return new ModelAndView(data, "index.ftl");

      }, gson::toJson);
      
      
      
    }
    
    
}
