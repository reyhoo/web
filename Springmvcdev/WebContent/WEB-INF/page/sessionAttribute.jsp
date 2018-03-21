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
Role role = (Role)session.getAttribute("role");
out.println(role.getId());
%>
<br>
<%
out.println(role.getRoleName());
%>
<br>
<%
out.println(role.getNote());
%>
<br>

<%
out.println(session.getAttribute("user"));
%>
<br>
<%
out.println(session.getAttribute("userr"));
%>
<br>
<%
out.println("roleId:"+session.getAttribute("roleId"));
%>
<br>
上面是从session里取的
<br>
requestScope.role.roleName :
${requestScope.role.roleName }
<br>requestScope.userr :
${requestScope.userr }
</body>
</html>