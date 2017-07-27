<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>jQuery 语法</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="js/jquery.js"></script>
<script>
    	$(function(){
    		$('#button1').click(function(){
    			
    			$(this).hide();
    		});
    		$('#button2').click(function(){
    			
    			$('#test').hide();
    		});
    		$('#button3').click(function(){
    			
    			$('p').hide();
    		});
    		$('#button4').click(function(){
    			
    			$('.test').hide();
    		});
    	});
    	
    </script>
</head>

<body>

	<button id="button1">Click Me</button>
	<hr>
	<h2>This is a heading</h2>
	<p>This is a paragraph.</p>
	<p id="test">This is another paragraph.</p>
	<button id="button2">Click me</button>
	<hr>
	<h2>This is a heading</h2>
<p>This is a paragraph.</p>
<p>This is another paragraph.</p>
<button id="button3">Click me</button>
<hr>

<h2 class="test">This is a heading</h2>
<p class="test">This is a paragraph.</p>
<p>This is another paragraph.</p>
<button id="button4">Click me</button>
</body>
</html>
