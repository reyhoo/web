<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    	<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:if test="${sessionScope.loginUser != null}">
		<c:redirect url="/role/list"></c:redirect>
	</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><spring:message code="user_login"></spring:message></title>
</head>
<body>

	<fieldset>
		<legend><spring:message code="user_login"></spring:message></legend>
		<c:url var="loginUrl" value="/user/login"></c:url>
		<form action="${loginUrl }" method="post">
			username:<input type="text" name="username">${usernameErrInfo }<br><br>
			password:<input type="password" name="password">${passwordErrInfo }<br><br>
			<input type="submit" value='<spring:message code="user_login"></spring:message>'>
		</form>
		${errInfo }
	</fieldset>
</body>
</html>