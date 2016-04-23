function cmu_comment(){
	var list = document.getElementById("cmu_comments")
	
	var str = prompt("Please input your comments here!");
		if(str!=null&&str!="")
		{
			alert("Your comment is"+str);
			var child = document.createElement("p");
			var c=document.createTextNode(str);
			child.appendChild(c);
			list.appendChild(child);
		}
		else
		{
			alert("Sorry. You input nothing");
		}
}

function thai_comment(){
	var list = document.getElementById("thai_comments")
	
	var str = prompt("Please input your comments here!");
		if(str!=null&&str!="")
		{
			alert("Your comment is"+str);
			var child = document.createElement("p");
			var c=document.createTextNode(str);
			child.appendChild(c);
			list.appendChild(child);
		}
		else
		{
			alert("Sorry. You input nothing");
		}
}
