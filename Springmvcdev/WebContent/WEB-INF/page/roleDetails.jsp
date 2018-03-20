<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<title>角色信息</title>
<style type="text/css">
	.t{
		margin: auto;
	}
</style>
</head>
<body>
	<table border=1 class="t">
		<tr><td>角色编号</td><td>角色名称</td><td>角色备注</td></tr>
		<tr><td>${requestScope.role.id}</td><td>${requestScope.role.roleName}</td><td>${requestScope.role.note}</td></tr>
	</table>
</body>
</html>