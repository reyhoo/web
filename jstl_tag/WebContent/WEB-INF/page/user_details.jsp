<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户详情</title>
</head>
<body>
	<table border="1">
		<tr><td>编号<td><c:out value="${user.id}"></c:out>
		<tr><td>用户名称<td><c:out value="${user.userName}"></c:out>
		<tr><td>性别<td><c:if test="${user.sex == 1}">男
		</c:if>
		<c:if test="${user.sex == 2}">女</c:if>
		<tr><td>职位<td>
		<c:choose>
			<c:when test="${user.posi == 1 }">普通员工</c:when>
			<c:when test="${user.posi == 2 }">经理</c:when>
			<c:otherwise>总裁</c:otherwise>
		</c:choose>
		<tr><td>出生日期<td>${user.birthday }
		<tr><td>备注<td>${user.note }
	</table>
	
</body>
</html>