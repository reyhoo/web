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
    	jq(function(){
    		jq.ajax({
    		type:"POST" //GET POST
    		,url:"/JQuery/postJson" //链接
    		,data:{"name":"姚磊","age":10,"memo":"上"}//POST请求的数据，可以为String或Object
    		,dataType:"json"
    		,beforeSend:function(xhr){
    		
    		//alert((typeof xhr)== 'object');
    		}
    		,success:function(response,statusTxt,xhr){
			//	alert(xhr.responseText +"\nname:"+ response.requestData.name);
    		}
    		,error:function(xhr){
    		//	alert("status:"+xhr.status+"\nresponse:"+xhr.responseText);
    		}
    		});
    	});
    </script>
  </head>
  
  <body>
  	<input id=name_field type=text disabled="disabled"><button>hello</button>
  </body>
</html>
