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
    		jq("#loadPathBtn").click(function(){
    			jq("#d1").load(appPath+"/load_test.txt",function(responseTxt,statusTxt,xhr){
      if(statusTxt=="success")
        alert("外部内容加载成功！");
      if(statusTxt=="error")
        alert("Error: "+xhr.status+": "+xhr.statusText+"\n"+responseTxt);
    });
    		});
    		jq("#loadPathBtn1").click(function(){
    			jq("#d2").load(appPath+"/load_test1.txt p",function(responseTxt,statusTxt,xhr){
      if(statusTxt=="success")
        alert("外部内容加载成功！");
      if(statusTxt=="error")
        alert("Error: "+xhr.status+": "+xhr.statusText+"\n"+responseTxt);
    });
    		});
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
  	<div id=d1></div>	
  	<div id=d2></div>	
  	<p><button id=loadPathBtn>加载全部文档</button></p>
  	<p><button id=loadPathBtn1>加载文档中部分元素</button></p>
  </body>
</html>
