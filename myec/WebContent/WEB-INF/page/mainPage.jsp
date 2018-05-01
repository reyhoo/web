<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页面</title>
</head>
<body>
<c:url value="/page/regist" var="toRegistUrl"></c:url>
<c:url value="/page/login" var="toLoginUrl"></c:url>
<a href="${toRegistUrl}">注册</a>
<a href="${toLoginUrl}">登录</a>
</body>
</html>