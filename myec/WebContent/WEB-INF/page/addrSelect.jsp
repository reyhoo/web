<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>地址管理</title>
<style type="text/css">
	.curr{
		color:red;
	}
</style>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.0.js"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<c:import url="/WEB-INF/page/header.jsp">
	<c:param name="currPage" value="1"></c:param>
	</c:import>
	<table style="width: 80%; margin: 20px auto; border: 1px solid black;">
		<tr>
			<td>名字
			<td>地址
			<td>电话
			<td>操作
		
			<c:forEach items="${addrList }" var="addr">
			<tr>
				<td>${addr.nickname }
				<td>${addr.addr }
				<td>${addr.mobile }
				<c:url value="/order/buy" var="buyUrl">
					<c:param name="productId" value="${productId }"></c:param>
					<c:param name="addrId" value="${addr.id }"></c:param>
				</c:url>
				<td><a href="${buyUrl }">选择</a>
			</c:forEach>
	</table>
</body>
</html>