<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div style="margin: 10px auto;">
	<c:choose>
		<c:when test="${sessionScope.loginUser != null}">
			<spring:message code="welcome"></spring:message>
		${sessionScope.loginUser.username} &nbsp;&nbsp;&nbsp;&nbsp;余额:
		<fmt:formatNumber value="${sessionScope.loginUser.balance }"
				type="number" pattern="#,##0.00"></fmt:formatNumber>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href='<c:url value="/addr/list"></c:url>'>地址管理</a>
		<c:url value="/user/logout" var="toLogoutUrl"></c:url>
			<a href="${toLogoutUrl}">退出登录</a>
		</c:when>
		<c:otherwise>
			<c:url value="/page/regist" var="toRegistUrl"></c:url>
			<c:url value="/page/login" var="toLoginUrl"></c:url>
			<a href="${toRegistUrl}">注册</a>
			<a href="${toLoginUrl}">登录</a>
		</c:otherwise>
	</c:choose>
</div>
