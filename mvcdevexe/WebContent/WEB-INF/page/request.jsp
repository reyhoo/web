<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
		  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>请求参数操作页面</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">
$(function(){
	
});
</script>
</head>
<body>
		

	<form action="<c:url value='/params/requestPojo'></c:url>" method="post">
		<input type="text" name="roleName" ><br><br>
	<!-- 	<input type="text" name="role_name" ><br><br>
		 -->
		<input type="text" name="note" ><br><br>
		
		<input type="submit" value="增加" ><br><br>
		
	</form>
</body>
</html>