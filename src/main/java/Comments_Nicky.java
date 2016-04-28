import java.util.*;
import java.text.SimpleDateFormat;
import java.text.*;

public class Comments_Nicky{
	private String User;
	private Date date;
	private String Time;
	private String Comment;
	
	public String getUser(){
		return User;
	}
	public void setUser(String User){
		this.User = User;
	}
	public String getTime(){
		return Time;
	}
	public void setTime(){
		date = new Date();
		Time = date.toString();
	}
	public String getComment(){
		return Comment;
	}
	public void setComment(String Comment){
		this.Comment = Comment;
	}
}  