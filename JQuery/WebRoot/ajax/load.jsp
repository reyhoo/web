<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
  <head>
  <base target="_blank">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="<%=appPath %>/js/jquery.js"></script>
    <script>
    	var jq = $.noConflict();
    	var appPath = null;
    	jq(function(){
    		appPath = jq("#app_path").val();
    		jq("div").load(appPath+"/load_test.txt");
    	});
    </script>
    <style>
    	body *{
    		margin:0px;
    		padding:0px;
    	}
    </style>
  </head>
  
  <body>
  	<input id=app_path type="hidden" value="<%=appPath%>">
  	<div></div>
  </body>
</html>
