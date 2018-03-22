<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>Insert title here</title>
</head>
<body>
${sessionScope.id }<br>
${sessionScope.role.id }<br>
${sessionScope.role.roleName }<br>
${sessionScope.role.note }<br>
${sessionScope.user }<br>
</body>
</html>