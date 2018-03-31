<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/annotationredis/role/upload" method="post"
	
	enctype="multipart/form-data"
	>
		<input type="text" name="name"><br>
		<input type="file" name="file" ><br>
		<input type="submit" >
	</form>
	<h1>
		<spring:message code="hello"></spring:message>
	</h1>
</body>
</html>