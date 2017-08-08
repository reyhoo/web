<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
  <base target="_blank">
  <title>jQuery 名称冲突</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="js/jquery.js"></script>
    <script>
    	$.noConflict();
    	jQuery(document).ready(function(){
    		jQuery('button').click(function(){
    			jQuery('p').text('jQuery 仍在运行！').css("color","red");
    		});
    		jQuery('button').mouseover(function(){
    			console.log('mouseover');
    		});
    	});
    	
    </script>
  </head>
  <body>
  	<p>这是一个段落。</p>
<button>测试 jQuery</button>
  </body>
</html>
