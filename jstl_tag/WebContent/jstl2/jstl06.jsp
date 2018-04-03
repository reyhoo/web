<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c1" uri="http://www.tarena.com.cn/mytag" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30pt;">
	<c1:helloUser username="${param.username}">
		hello,${param.username}
	</c1:helloUser>
	<br/>
	hello java
</body>
</html>