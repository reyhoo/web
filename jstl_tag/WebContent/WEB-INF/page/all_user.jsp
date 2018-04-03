<%@page import="com.jstl.tag.pojo.User"%>
<%@page import="com.jstl.tag.pojo.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
</head>
<body>
	<%
		//为测试标签在这里进行某些运算
		PageData<User> pageUser = (PageData) request.getAttribute("pageUser");
		int currPage = 0;
		int totalPage = 0;
		int total = pageUser.getTotal();
		int start = pageUser.getStart();
		int limit = pageUser.getLimit();
		currPage =  start / limit + 1;
		if (total == 0) {
			totalPage = 1;
		} else {
			totalPage = total % limit == 0 ? total / limit : total / limit + 1;
		}
	%>
	<c:set var="currPage" scope="request" value="<%=currPage%>"></c:set>
	<c:set var="totalPage" scope="request" value="<%=totalPage%>"></c:set>
	<table border="1">
		<tr>
			<td>编号
			<td>用户名称
			<td>性别
			<td>职位
			<td>详情 <c:forEach var="user" items="${pageUser.dataList }">
					<tr>
						<td>${user.id }
						<td>${user.userName }
						<td>
							<%-- ${user.sex == 1?'男':'女' } --%> <c:if
								test="${user.sex == 1 }">男</c:if> <c:if test="${user.sex == 2 }">女</c:if>
						<td><c:choose>
								<c:when test="${user.posi==1 }">普通职工</c:when>
								<c:when test="${user.posi==2 }">经理</c:when>
								<c:otherwise>总裁</c:otherwise>
							</c:choose>
						<td><c:url var="userUrl" value="/user/details">
								<c:param name="id" value="${user.id }"></c:param>
							</c:url> <%-- <a href='<c:out value="${userUrl }"></c:out>'>详细</a> --%> <a
							href='${userUrl }'>详细</a>
				</c:forEach>
	</table>
	<span>当前为第${currPage }页，共${totalPage }页</span>
	<c:url var="lastUrl" value="/user/getAll">
		<c:param name="limit" value="${pageUser.limit }"></c:param>
		<c:if test="${currPage <= 1}" >
			<c:set var="start1" value="0"></c:set>
		</c:if>
		<c:if test="${currPage > 1 }" >
			<c:set var="start1" value="${pageUser.start-pageUser.limit }"></c:set>
		</c:if>
		<c:param name="start" value="${start1 }">
		</c:param>
	</c:url>
	<c:url var="nextUrl" value="/user/getAll">
		<c:param name="limit" value="${pageUser.limit }"></c:param>
			<c:if test="${currPage < totalPage}" >
			<c:set var="start1" value="${pageUser.start + pageUser.limit }"></c:set>
		</c:if>
		<c:if test="${currPage >= totalPage }" >
			<c:set var="start1" value="${pageUser.start}"></c:set>
		</c:if>
		<c:param name="start" value="${start1 }">
		</c:param>
	</c:url>
	<a href="${lastUrl }">上一页</a>
	<a href="${nextUrl }">下一页</a>
</body>
</html>