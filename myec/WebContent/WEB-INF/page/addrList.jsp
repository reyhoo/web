<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>地址管理</title>
<style type="text/css">
</style>
<meta charset="UTF-8">
</head>
<body>
	<c:import url="/WEB-INF/page/header.jsp"></c:import>
	<table style="width: 80%; margin: 20px auto; border: 1px solid black;">
		<tr>
			<td>名字
			<td>地址
			<td>电话
			<td>操作
		<tr>
			<c:forEach items="${addrList }" var="addr">
				<td>${addr.nickname }
				<td>${addr.addr }
				<td>${addr.mobile }
				<td><a href='<c:url value="/addr/delete?id=${addr.id }"></c:url>'>删除</a>
				<c:url value="/addr/toModify" var="modifyUrl">
					<c:param name="id" value="${addr.id }"></c:param>
				</c:url>
				<a href="${modifyUrl} ">修改</a>
			</c:forEach>
	</table>
</body>
</html>