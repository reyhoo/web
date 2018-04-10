<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    	<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set scope="page" var="isUpdate" value="${requestScope.role != null}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>
	${isUpdate?"更新角色":"添加角色" }
</title>
</head>
<body>
	
	<fieldset>
		<legend>${isUpdate?"更新角色":"添加角色" }</legend>
		<c:url var="url" value='${isUpdate?"/role/update":"/role/add" }'>
			<c:if test="${!isUpdate}">
				<c:param name="userId" value="${sessionScope.loginUser.id }"></c:param>
			</c:if>
		</c:url>
		<form action="${url }" method="post">
			id:<input type="text" name="id" readonly="readonly" value="${requestScope.role.id }"><br><br>
			<input type="hidden" name="userId" value="${requestScope.role.userId }">
			role_name:<input type="text" name="roleName" value="${requestScope.role.roleName }"><br><br>
			note:<input type="text" name="note" value="${requestScope.role.note }"><br><br>
			<input type="submit" value='${isUpdate ?"更新":"添加"}'>
		</form>
		${errInfo }
	</fieldset>
</body>
</html>