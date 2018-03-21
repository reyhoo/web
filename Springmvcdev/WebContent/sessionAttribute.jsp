<%@page import="com.spring.mvcdev.pojo.Role"%>
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
session.setAttribute("id", "94");
response.sendRedirect(application.getContextPath()+"/attribute/sessionAttribute.do");
%>
</body>
</html>