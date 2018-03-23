<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
</head>
<body>
	<form action="<c:url value='/file/upload'></c:url>" method="post" enctype="multipart/form-data">
		<span>用户名：</span><input type="text" name="username">
		<br><br>
		<span>文件：</span><input type="file" name="f"><br><br>
		<input type="submit" value="上传">
	</form>
</body>
</html>