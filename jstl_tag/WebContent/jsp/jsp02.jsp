<body style="font-size:30pt;">
	hello:<%=config.getInitParameter("version") %><br/>
	<%
		pageContext.setAttribute("someKey","someValue");
	 %>
	 <%=pageContext.getAttribute("someKey") %><br/>
	 <%
		request.setAttribute("someKey1","someValue1");
	 %>
	 <a href="jsp03.jsp">test</a>
</body>