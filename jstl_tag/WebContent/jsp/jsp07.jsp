<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30pt;">
	hello<br/>
	<jsp:include  page="jsp08.jsp"><!-- 包含某个页面 -->
		<jsp:param name="country" value="china"/><!-- 可以传递参数-->
	</jsp:include>
	<br/>
	other...
	
	
	
</body>
</html>