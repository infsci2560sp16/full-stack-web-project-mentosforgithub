 $('#signin').click(function()
  {
        var username = document.getElementById("login_username").value;
        var password = document.getElementById("login_password").value;
		
        var send= JSON.stringify({ "login_username": username , "login_password":password});
      $.ajax({
          contentType:'application/json',
          url:"/login",
          type:"GET",
          datatype: "json",
          data: send,
          success: function(data)
          {
            alert("succeeded");
            window.location.href='/index.html';
         }
        });
    }
  );
