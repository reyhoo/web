<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>我的订单</title>
<style type="text/css">
	.curr{
		color:red;
	}
	li{
		list-style: none;
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
	</c:import>
	<table style="width: 80%; margin: 20px auto; border: 1px solid black;">
		<tr>
			<td>创建时间
			<td>支付时间
			<td>订单状态
			<td>地址
			<td>订单金额
			<td>订单产品
			<td>操作
		
			<c:forEach items="${orderList }" var="order">
			<tr>
				<td><fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				<td><fmt:formatDate value="${order.payTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				<td>${order.status.showText }
				<td><ul><li>${order.nickname }
				<li>${order.mobile }
				<li>${order.addr }</ul>
				<td>${order.totalAmount }
				<td>
				<ul>
					<c:forEach items="${order.productList }" var="product">
						<li>产品名称:${product.productName }
						<li>数量:${product.productQuantity }
						<li>单价:${product.productUnitPrice }
						<li>总金额:${product.productAmount }
						<br>
					</c:forEach>
				</ul>
				<td>
				<c:if test="${order.status.value eq 'unpaid' }">
					<a href='<c:url value="/order/pay?id=${order.id }"></c:url>'>支付</a>
					<a href='<c:url value="/order/cancel?id=${order.id }"></c:url>'>取消</a>
				</c:if>
			</c:forEach>
	</table>
</body>
</html>