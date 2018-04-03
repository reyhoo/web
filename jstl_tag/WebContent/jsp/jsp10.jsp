<%@ page  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30pt;">
	<jsp:useBean id="user" scope="request" class="com.jstl.tag.pojo.User"/>
	<%--
	<jsp:setProperty name="user" property="name" param="name"/>
	<jsp:setProperty name="user" property="age" param="age"/>
	--%>
	<jsp:setProperty name="user" property="*"/>
	<jsp:getProperty name="user" property="name"/>
	<%
		//User user2 = (User)request.getAttribute("user");
		//out.println(user2.getName());
		//out.println(user2.getAge());
	 %>
</body>
</html>