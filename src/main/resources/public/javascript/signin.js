$(document).ready(function(){
  $('#signin').click(function()
  {
        var username = document.getElementById("sign_username").value;
        var password = document.getElementById("sign_password").value;
		
        var send= JSON.stringify({ "sign_username": username , "sign_password":password});
      $.ajax({
          contentType:'application/json',
          url:"/signin",
          type:"POST",
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
});
