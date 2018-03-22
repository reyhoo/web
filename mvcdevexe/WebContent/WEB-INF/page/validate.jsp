<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
		  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>表单验证</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">
$(function(){
	
});
</script>
</head>
<body>
		

	<form action="<c:url value='/validate/annotation'></c:url>" method="post">
		productId:<input type="text" name="productId" ><br><br>
		userId<input type="text" name="userId" ><br><br>
		date<input type="text" name="date" ><br><br>
		price<input type="text" name="price" ><br><br>
		quantity<input type="text" name="quantity" ><br><br>
		amount<input type="text" name="amount" ><br><br>
		email<input type="text" name="email" ><br><br>
		note<input type="text" name="note" ><br><br>
		<input type="submit" value="增加" ><br><br>
		
	</form>
</body>
</html>