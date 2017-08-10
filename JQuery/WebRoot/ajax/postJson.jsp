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
    			
    		jq.post(appPath+"/postJson",JSON.stringify({name:'姚磊'}),function(data,status){
    		//data返回数据
    		//status success
    			var txt ="typeofData:" + (typeof data);
    			txt += '\n';
    			txt += 'data:'+data+ '\n';
    			txt += 'name:'+JSON.parse(data).requestData.name+ '\n';
    			txt += 'status:'+status;
    			alert(txt);
    		});
    	});
    </script>
</head>

<body>
	<input id=app_path type="hidden" value="<%=appPath%>">
</body>
</html>
