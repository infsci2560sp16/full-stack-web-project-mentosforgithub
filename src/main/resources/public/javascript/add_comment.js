function add_comment()
  {
        var username = document.getElementById("comment_cmu_username").value;
        var comment = document.getElementById("comment_text").value;
		var grade = document.getElementById("grade").value;
		
        var send= JSON.stringify({ "comment_cmu_username": username , "comment_text":comment,"grade":grade});
      $.ajax({
          contentType:'application/json',
          url:"/addcomment",
          type:"post",
          datatype: "json",
          data: send,
          success: function(data)
          {
            alert("succeeded");
            window.location.href='/sight.html';
         }
        });
    }