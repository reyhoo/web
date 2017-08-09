<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
  <head>
  <base target="_blank">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="<%=appPath %>/js/jquery.js"></script>
    <script>
    	var jq = $.noConflict(); 
    	jq(function(){
    		jq('#addClassBtn').click(function(){
    			jq('h1,h2,p').addClass('blue');
    			jq('div').addClass('important blue');
    		});
    		jq('#removeClassBtn').click(function(){
    			jq('div').removeClass('blue');
    		});
    		jq('#toggleClassBtn').click(function(){
    			jq('h1,h2,p,div').toggleClass('blue');
    		});
    	});
    </script>
    <style type="text/css">
    	.important{
    		font-weight: bold;
    		font-size: xx-large;
    	}
    	.blue{
    		color:blue;
    	}
    </style>
  </head>
  <body>
  	
<h1>标题 1</h1>
<h2>标题 2</h2>
<p>这是一个段落。</p>
<p>这是另一个段落。</p>
<div>这是非常重要的文本！</div>
<br>
<button id=addClassBtn>向元素添加类</button>
<button id=removeClassBtn>将元素的类删除</button>
<button id=toggleClassBtn>将元素的类添加删除切换</button>
  </body>
</html>
