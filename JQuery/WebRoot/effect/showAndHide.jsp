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
    		$('p').click(function(){
    			$(this).hide();
    		});
    		
    		
    		$('.ex .hide').click(function(){
    			$(this).parents('.ex').hide('slow');
    		});
    		
    		$('#hide').click(function(){
    			$('#p1').hide();
    		});
    		$('#show').click(function(){
    				$('#p1').show();
    		});
    	});
    </script>
    <style>
    	div.ex{
    			background-color: #e5eecc;
    			padding:7px;
    			border:1px #c3c3c3 solid;
    	}
    </style>
  </head>
  
  <body >
  <p>如果您点击我，我会消失。</p>
<p>点击我，我会消失。</p>
<p>也要点击我哦。</p>
  	<hr>
  	<h3>中国办事处</h3>
<div class="ex">
<button class="hide" type="button">隐藏</button>
<p>联系人：张先生<br /> 
北三环中路 100 号<br />
北京</p>
</div>

<h3>美国办事处</h3>
<div class="ex">
<button class="hide" type="button">隐藏</button>
<p>联系人：David<br /> 
第五大街 200 号<br />
纽约</p>
</div>
<hr>

<p id="p1">如果点击“隐藏”按钮，我就会消失。</p>
<button id="hide" type="button">隐藏</button>
<button id="show" type="button">显示</button>
  </body>
</html>
