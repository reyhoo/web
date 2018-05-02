<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${loginUser != null }">
	<c:redirect url="/page/main"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
</head>
<body>
<c:url value="/page/regist" var="toRegistUrl"></c:url>
<a href="${toRegistUrl}">注册</a>
	<c:url value="/user/login" var="loginUrl"></c:url>
	<form action="${loginUrl }" style="padding:50px;margin: 100px auto;background-color: #cccccc;width: 300px;" method="post">
		username<input name="username" type="text"><br><br>
		password<input name="password" type="password"><br><br>
		<input value="登录" type="submit"><br><br>${errInfo }
	</form>
</body>
</html>