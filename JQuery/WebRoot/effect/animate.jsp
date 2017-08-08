<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<base target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=appPath %>/js/jquery.js"></script>
<script>
    	$(document).ready(function(){
    		$('#btn1').click(function(){	
    			$('div').animate({top:'100px'},1000);
    		});
    		$('#btn2').click(function(){
    			$('div').animate({top:'100px',opacity:'0.5',height:'150px',width:'150px'},1000);
    		});
    		$('#btn3').click(function(){
    		$('div').animate({width:"+=50px",height:"+=50px"},'slow');
    		});
    		$('#btn4').click(function(){
    		$('div').animate({ height:'toggle'},500);
    		});
    		$('#btn5').click(function(){
    		 var div=$("div");
  div.animate({height:'300px',opacity:'0.4'},"slow");
  div.animate({width:'300px',opacity:'0.8'},"slow");
  div.animate({height:'100px',opacity:'0.4'},"slow");
  div.animate({width:'100px',opacity:'0.8'},"slow");
    		});
    	});
    </script>
<style>
button {
	display: block;
	width: 50%;
	margin: 20px auto;
}
</style>
</head>

<body>
	<button id="btn1">开始动画1</button>
	<button id="btn2">开始动画2</button>
	<button id="btn3">开始动画3</button>
	<button id="btn4">开始动画4</button>
	<button id="btn5">开始动画5</button>

	<div
		style='background-color: green; width:100px;height:100px;margin:0 auto;position:relative;'></div>
	<p style="border:1px black solid; margin: 0px">下
</body>
</html>
