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
            <br>
            <br>
            <br>
            <p style="text-align: center;">what to eat is big problem!</p>
            <h2 style="text-align: center;"><br/>Recommended foods for ${dayOfWeek}</h2>

            <#if dayOfWeek == "Monday"|| dayOfWeek == "Wednesday"|| dayOfWeek == "Friday">

            <#list 0..oddtopics?size-1 as i>
                <h3 style="text-align: center;">${eventopics[i]}</h3>
                </#list>

                <#elseif dayOfWeek == "Tuesday"|| dayOfWeek == "Thursday">
                <#list 0..oddtopics?size-1 as i>
                <h3 style="text-align: center;">${oddtopics[i]}</h3>
            </#list>

        <#else>
            <#list 0..oddtopics?size-1 as i>
            <h3 style="text-align: center;">${weektopics[i]}</h3>
            </#list>
        
            </#if>
        </div>
    </div>


</body>
</html>
