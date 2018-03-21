<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>Insert title here</title>
</head>
<body>
<%
	request.setAttribute("id", "111");
	request.getRequestDispatcher("/attr/requestAttr").forward(request, response);
%>
</body>
</html>