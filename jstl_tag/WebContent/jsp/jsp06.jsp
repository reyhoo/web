<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
	<title>Insert title here</title>
</head>
<body style="font-size:30pt;">
<h1>ss</h1>
	<%request.setAttribute("date", new SimpleDateFormat("yyyyMMdd").parse("19900202")); %>
	<jsp:forward page="jsp05.jsp"/><!-- 转发 -->
</body>
</html>