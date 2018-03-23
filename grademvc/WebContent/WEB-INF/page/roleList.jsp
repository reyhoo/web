<%@page import="com.grade.mvc.pojo.Role"%>
<%@page import="java.util.List"%>
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
		<%List<Role>roleList = (List<Role>)request.getAttribute("roleList");
		System.out.println(roleList);
		%>
		<c:forEach items="${roleList}" var="role">

			<tr><td>${role.id}</td><td>${role.roleName}</td><td>${role.note}</td></tr>
		
		</c:forEach>
		</table>
</body>
</html>