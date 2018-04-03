<%@page import="com.jstl.tag.pojo.User"%>
<%@ page  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30pt;">
	<%
		User user = new User();
		user.setUserName("tom");
		user.setSex(1);
		request.setAttribute("user1",user);
	 %>
	 <%
	 	//User user1 = (User)request.getAttribute("user1");
	  	//out.println(user1.getName());
	  %>
	  <br/>
	  name:${sessionScope.user1.userName}<br/>
	  <hr/>
	  <br/>
	  <%
	  	request.setAttribute("str","userName");
	   %>
	   name:${user1["userName"]}<br/>
	   name:${user1[sessionScope.str]}
	  
	  
</body>
</html>