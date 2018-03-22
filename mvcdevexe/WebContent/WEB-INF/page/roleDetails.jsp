<%@page import="java.util.List"%>
<%@page import="com.mvcdev.exe.pojo.Role"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>角色列表</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
		
	<table border=1 class="t">
		<tr><td>角色编号</td><td>角色名称</td><td>角色备注</td></tr>
		<%Role role = (Role)request.getAttribute("role");
		System.out.println(role);
		%>


			<tr><td>${role.id}</td><td>${role.roleName}</td><td>${role.note}</td></tr>
		
		</table>
</body>
</html>