<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setAttribute("id", 79l);
request.getRequestDispatcher("/attribute/requestAttribute.do").forward(request, response);
%>
</body>
</html>