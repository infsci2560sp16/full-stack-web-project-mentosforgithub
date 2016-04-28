//XML GET
function show_more () {
	$.ajax({
		url : "/api/comments",
		type : "get",
		success : function(result) {
			sights.html("");
			console.log(result);
			
			comment = result.getElementsByTagName("comment");
			for ( var i = 0; i < comment.length; i++) {
				$("#cmu_comments").append(comment[i].childNodes[0].firstChild.nodeValue+'<p>said at'+comment[i].childNodes[1].firstChild.nodeValue+'</p></br><p>'+
				comment[i].childNodes[2].firstChild.nodeValue+'</br>'+'Grade:'+comment[i].childNodes[3].firstChild.nodeValue+'</p>')
			}
		}
	});
}

