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
    		jq('#getCssBtn').click(function(){
    			alert('background-color:'+jq('p').css('background-color'));
    		});
    		jq('#setCssBtn').click(function(){
    			jq('p').css('background-color','yellow');
    		});
    		jq('#setMultiCssBtn').click(function(){
    			jq('p').css({"background-color":"yellow","font-size":"200%"});
    		});
    	});
    </script>
    <style type="text/css">
    </style>
</head>

<body>
	<h2>这是标题</h2>
	<p style="background-color:#ff0000">这是一个段落。</p>
	<p style="background-color:#00ff00">这是一个段落。</p>
	<p style="background-color:#0000ff">这是一个段落。</p>
	<p>这是一个段落。</p>
	<button id=getCssBtn>获取 p 元素的某个样式</button>
	<button id=setCssBtn>为 p 元素设置样式</button>
	<button id=setMultiCssBtn>为 p 元素设置多个样式</button>
</body>
</html>
