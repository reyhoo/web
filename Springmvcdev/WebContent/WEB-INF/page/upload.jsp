<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
		  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>文件上传</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">
$(function(){
	
});
</script>
</head>
<body>
		

	
<form action="<c:url value='/file/upload.do'></c:url>" method="post" enctype="multipart/form-data">
	<input type="file" name="file1" value="请选择上传的文件"><br><br>
<!--	<input type="file" name="file3" value="请选择上传的文件"><br><br> -->
	<input type="text" name="info"><br><br>
	<input type="submit" value="上传"><br><br>

</form>
</body>
</html>