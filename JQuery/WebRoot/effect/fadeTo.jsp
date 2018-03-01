<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String appPath = application.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<base target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=appPath%>/js/jquery.js"></script>
<script>
	$(document).ready(function() {
		$('#fadeTo_b').click(function() {
			$("#div1").fadeTo('fast',.4);
			$("#div2").fadeTo("slow",.5);
			$("#div3").fadeTo(3000,.1);
		});
	});
</script>
</head>

<body>
	<p>演示带有不同参数的 fadeTo() 方法。</p>
	<button id=fadeTo_b>点击这里，使三个矩形淡入淡出</button>
	<br>
	<br>
	<div id=div1
		style="width:80px;height:80px;background-color:red;float: left"></div>
	<div id=div2
		style="width:80px;height:80px;background-color:green;float: left"></div>
	<div id=div3
		style="width:80px;height:80px;background-color:blue;float: left"></div>
	<div style='clear:both;'></div>
	<hr>
</body>
</html>