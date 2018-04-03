<%@ page import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:30pt;">
	1+1:${1+1}<br/>
	${"1" + "2" }<br/>
	<%
		request.setAttribute("str1","1");
		request.setAttribute("str2","2");
		request.setAttribute("str3","Abc");
	 %>
	${str1 + str2 }<br/>
	${"abc" eq str3}<br/>
	<%
	request.setAttribute("str","");
	%>
	str:${empty str}
	<%
		List list = new ArrayList();
		request.setAttribute("list","");
	%>
	list:${empty list}
	abcd:${empty abcd}
	
</body>
</html>