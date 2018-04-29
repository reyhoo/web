<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    	<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色列表</title>
</head>
<body>

	<spring:message code="welcome_pre"></spring:message> ${sessionScope.loginUser.username}&nbsp;&nbsp;&nbsp;
	<a href='<c:url value="/user/logout"></c:url>'>退出</a>
	<table border="1">
		<tr><td>编号<td>角色名称<td>备注<td>操作
		
		<c:forEach var="role" items="${roleList }" varStatus="status">
			<tr><td>${role.id }<td>${role.roleName }<td>${role.note }
			<td><img alt="" src="${role.pic }" style="height:100px;width: 100px;">
		<td>
			<c:url var="deleteUrl" value="/role/delete">
				<c:param name="id" value="${role.id}"></c:param>
			</c:url>
			<c:url var="updateUrl" value="/role/toUpdate">
				<c:param name="id" value="${role.id}"></c:param>
			</c:url>
			<a href="${deleteUrl }">删除</a>
			<a href="${updateUrl }">更新</a>
		</c:forEach>
	</table>
		<a href='<c:url value="/role/toAdd"></c:url>'>添加</a>
</body>
</html>