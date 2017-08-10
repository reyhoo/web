<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<base target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=appPath %>/js/jquery.js"></script>
<script>
    	var appPath = null;
    	var jq = $.noConflict(); 
    	jq(function(){
    		appPath = jq("#app_path").val();
    			
    		jq.post(appPath+"/hello",{name:'姚磊'},function(data,status){
    		//data返回数据
    		//status success
    			alert("1:"+data+";"+status);
    		});
    	});
    </script>
</head>

<body>
	<input id=app_path type="hidden" value="<%=appPath%>">
</body>
</html>
