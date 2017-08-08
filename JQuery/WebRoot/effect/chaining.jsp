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
	$(function() {
		$('button').click(function(){
			$('p').css('color','red')
			.slideUp(1000)
			.slideDown(1000);
		});
	});
</script>
</head>

<body>
	<p>jQuery 乐趣十足！</p>
	<button>先上滑后下滑</button>
</body>
</html>
