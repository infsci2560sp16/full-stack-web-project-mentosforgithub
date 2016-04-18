<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title> MySecret </title>
  <link rel="stylesheet" type="text/css" href="./stylesheets/main.css">
</head>
<body>
    <div class ="sidebar">
        <div class ="logo">
            <a href="/">MySecret</a>
        </div>
        
        <div id= "user1" class = "user" style="text-align: center;">         
            <img src="1.jpg" width="100" height="100" alt="userImage" class="profile">
            
            <span><br>Mengjiao</span>
        </div>
        <div class = "menu">
            <a href="personInfo.html">Person Info</a> 
            <a href="blog.html">Blog</a>  
            <a href="schedule.html">Schedule</a>
            <a href="messageBoard.html">Message Board</a>
        </div>
    </div>
    
    <div class="container">
        <div class="inner">
            <p>Welcome to MySecret<p>
            <h3><br/>Recommended foods for ${dayOfWeek}</a></h3>

            <#if dayOfWeek == "Monday"|| dayOfWeek == "Wednesday"|| dayOfWeek == "Friday">

            <#list 0..oddtopics?size-1 as i>
                <h4>${eventopics[i]}</h4>
                </#list>

                <#elseif dayOfWeek == "Tuesday"|| dayOfWeek == "Thursday">
                <#list 0..oddtopics?size-1 as i>
                <h4>${oddtopics[i]}</h4>
            </#list>

        <#else>
            <#list 0..oddtopics?size-1 as i>
            <h4>${weektopics[i]}</h4>
            </#list>
        
            </#if>
        </div>
    </div>


</body>
</html>
