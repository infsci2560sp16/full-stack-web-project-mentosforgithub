/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function showBlogs () {
	$.ajax({
		url : "/api/moodblog",
		type : "get",
		success : function(result) {
			$("#mblogs").html("");
			console.log(result);
			moods = result.getElementsByTagName("moods");
			for ( var i = 0; i < moods.length; i++) {
				$("#mblogs").prepend(
					'<div class="row1" id="' + moods[i].childNodes[0].firstChild.nodeValue + '">' +
						'<div class="col-md-7">' +
							 moods[i].childNodes[2].firstChild.nodeValue +' ' + moods[i].childNodes[3].firstChild.nodeValue + ' ' + moods[i].childNodes[4].firstChild.nodeValue+
						'</div>' +
						'<div class="col-md-5">' +
								'<h3>' + moods[i].childNodes[2].firstChild.nodeValue + ' ' + moods[i].childNodes[3].firstChild.nodeValue + ' ' + moods[i].childNodes[4].firstChild.nodeValue + '</h3>' +
								'<h4>' + moods[i].childNodes[4].firstChild.nodeValue + '</h4>' +
								'<h4>' + moods[i].childNodes[5].firstChild.nodeValue + '</h4>' +
						'</div>' +
					'</div>' +
				        '<hr>'
				);
			}
		}
	});
}






