<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30pt;">
		<c:set var="rs" scope="session" value="${1+1}"/>
		before:${sessionScope.rs}<br/>
		<c:remove var="rs" scope="request"/>
		after:${sessionScope.rs}<br/>
		<c:catch var="msg">
			<%
				Integer.parseInt("123a");
			 %>
		 </c:catch>
		 <c:if test="${!empty msg}">
			error: ${msg}
		</c:if>
</body>
</html>