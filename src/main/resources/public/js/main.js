/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var $id = function(o){ return document.getElementById(o) || o};
$id("more_btn").onclick=function(){	
        height = Math.floor(Math.random()*200 + 200);
        $id("wrap").innerHTML += '<li><div class="boxCont" style="height:' + height + 'px;"></div></li>';	
}


var parent = document.getElementById("skillNode");
//var child = document.getElementById("s1");
var node = document.createElement("span");
var textnode = document.createTextNode("SQL");
node.appendChild(textnode);
parent.appendChild(node);
//parent.replaceChild(node,child);

