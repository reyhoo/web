<%@ page import="java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.row1 {
	background-color: red;
}

.row2 {
	background-color: yellow;
}
</style>
</head>
<body style="font-size: 30pt;">
	<%
		List<String> users = new ArrayList();
	users.add("tom0");
	users.add("tom1");
	users.add("tom2");
	users.add("tom3");
	users.add("tom4");
	users.add("tom5");
	users.add("tom6");
	users.add("tom7");
	users.add("tom8");
		request.setAttribute("users", users);
		
	 %>
	<table border="1" cellpadding="0" cellspacing="0" width="60%" align="center">
		<tr>
			<td>name</td>
			<td>index</td>
		</tr>
		<c:forEach var="user" items="${users}" varStatus="status" begin="2" >
			<tr class="row${status.index%2 + 1}">
				<td>${user}</td>
				<td>${status.index}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>