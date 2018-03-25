<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	
<!DOCTYPE html >
<html>
<head>
<meta charset=utf-8>
</head>
<body>
	<h1>
		<spring:message code="company"></spring:message>
	</h1>
	Locale:${pageContext.response.locale }
</body>
</html>