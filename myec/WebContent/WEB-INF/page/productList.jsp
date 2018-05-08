<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>我的产品</title>
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
			<td>产品名称
			<td>库存
			<td>价格
			<td>商家
			<td>操作
		
			<c:forEach items="${productList }" var="product">
			<tr>
				<td>${product.productName }
				<td>${product.stock }
				<td>${product.price }
				<td>${product.merchant.username }
				<td><a href='<c:url value="/addr/delete?id=${addr.id }"></c:url>'>删除</a>
				<c:url value="/addr/toModify" var="modifyUrl">
					<c:param name="id" value="${addr.id }"></c:param>
				</c:url>
				<a href="${modifyUrl} ">修改</a>
			</c:forEach>
	</table>
</body>
</html>