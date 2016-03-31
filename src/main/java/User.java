/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mengjiao
 */
public class User {  
  
     String id;  
     String name; 
     String passwd;
    public String getId() {  
        return id;  
    }  
    public void setId(String id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    } 
    public void setPasswd(String passwd){
        this.passwd=passwd;
    }
    public String getPasswd(){
        return passwd;
    }
    
}  
