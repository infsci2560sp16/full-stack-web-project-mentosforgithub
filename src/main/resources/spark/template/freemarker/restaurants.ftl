<!DOCTYPE html>
<html>
    <head>
        <title>Small Lights</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="style.css" rel="stylesheet" type="text/css"/>
		<script type="text/javascript" src="script.js"></script>
    </head>
    <body>
        <div class="head"><h1>Small Lights</h1></div>
		
        <div class="login_banner">
            <div class ="login"><button onclick="{if(confirm('Are you sure to log in?')) location.href='login.html'}">LOG IN</div>
            <div class="signin"><button onclick="{if(confirm('Are you sure to sign in?')) location.href='signin.html'}">SIGN IN</div>
        </div>
        <br>
		<br>
        
        <div class="current_r">
            <div class="thai">
                <input type="radio" name="thai" value="icon" id="thai"/>Nicky's Thai Kitchen<img id ="thai" src="images/restaurants/thai.jpg" width=200 height=170 alt="thai" >
                <br>
                <div class="button"><input type="submit" value="comment" name="thai_comments" onclick="thai_comment()"/></div>
                <div class="comments">
				
				<#list commentsList as Comments_Nicky>
					<p>${Comments_Nicky.User}said at${Comments_Nicky.Time}:&nbsp;&nbsp; ${Comments_Nicky.Comment}</p></br>
					<#if Comments_Nicky.Comment == null> 
						<p> ${Comments_Nicky.User}didn't leave any comments</p></br>
					</#if>
				</#list>
                </div>
            </div>
        </div>
        <br>
		
        <div class="back_home"><a href="index.html">Click here to back to home page!</a></div>
    </body>
</html>
