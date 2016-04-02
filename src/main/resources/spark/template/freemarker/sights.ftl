<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
            <div class ="login"><input type="submit" value="log in" name="login_2" /></div>
            <div class="signin"><input type="submit" value="sign in" name="signin_2" /></div>
        </div>
        <br>
		<br>
        
        <div class="current_s">
            <div class="cmu">
                <input type="radio" name="cmu" value="icon" id="CMU"/>Carneige Mellon University<img id ="cmu" src="images/sights/cmu.jpg" width=200 height=170 alt="cmu" >
                <br>
                <div class="button"><input type="submit" value="comment" name="comment" onclick="cmu_comment()"/></div>
                <div class="comments">
				
				<#list commentsList as Comments_cmu>
					<p>${Comments_cmu.User}said:&nbsp;&nbsp; ${Comments_cmu.Comment}</p></br>
					<#if Comments_cmu.Comment == null> 
						<p> ${Comments_cmu.User}didn't leave any comments</p></br>
					</#if>
				</#list>
				
				</div>
            </div>
        </div>
        <br>
		
        <div class="back_home"><a href="index.html">Click here to back to home page!</a></div>
    </body>
</html>





