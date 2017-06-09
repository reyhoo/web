<%@page import="java.util.Map.Entry"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("utf-8");
	Map<String, String[]> map = request.getParameterMap();
	Iterator<String> it = map.keySet().iterator();
%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<style>
	p{
	color:blue;
	text-align:center;
	height:50px;
	background-color:#cccccc;
	line-height:50px;
	font-family: fantasy;
	font-size: 20px;
	margin: 5px;
	}
	</style>
</head>
<body>
	<%
		while(it.hasNext()){
			String key = it.next();
			%>
			<p><%=key %>:<%=Arrays.toString(map.get(key)) %></p><%} %>
</body>
</html>