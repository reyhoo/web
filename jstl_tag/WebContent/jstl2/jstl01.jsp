<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30pt;">
	<a href="<%=response.encodeURL("jstl02.jsp") %>">visit jstl02.jsp</a>
	
	<br/>
	<c:url value="/jstl2/jstl02.jsp" var="url">
		<c:param name="name" value="Jerry"></c:param>
	</c:url>
	<a href="${url}">visit jstl02.jsp</a>
	
</body>
</html>