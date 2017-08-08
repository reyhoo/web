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
    		$('button').click(function(){
    			$('p').hide(1000,function(){
    				alert('p is now hidden!!!');
    			});
    		});
    	});
    </script>
  </head>
  
  <body>
  	<button type="button">Hide</button>
<p>This is a paragraph with little content.</p>
  </body>
</html>
