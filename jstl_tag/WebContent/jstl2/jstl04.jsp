<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30pt;"> 
	hello<br/>
	<c:import url="/jstl2/jstl02.jsp"><!-- 包含页面 -->
		<c:param name="name" value="Tom"></c:param>
	</c:import>
</body>
</html>