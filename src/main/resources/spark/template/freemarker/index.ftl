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
            <a href="/index.ftl">MySecret</a>
        </div>
        
        <div id= "user1" class = "user" style="text-align: center;">         
            <img src="1.jpg" width="100" height="100" alt="userImage" class="profile">
            <span><br>${username}</span>
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
        </div>
    </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
                <script>
                    $(function () {
                        $.ajax({
                            url: "/index/username", 
                            success: function (result) {
                                var user1 = JSON.parse(result);
                                console.log(result);
                                $("#user1 span").html(user1.username);
                        }});
                    });
                </script>  

</body>
</html>
