<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
  <head>
  <base target="_blank">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="<%=appPath %>/js/jquery.js"></script>
    <script>
    	$(document).ready(function(){
    	
    	});
    </script>
  </head>
  
  <body>
  <a href="http://docs.jquery.com/Downloading_jQuery#Download_jQuery"> 你好  <%=session.getAttribute("name1") %> </a><br>
  </body>
</html>
