<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
		  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>请求参数操作页面</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">
$(function(){
	var base_url=$("#base_url").val().trim();
	$("#btn3").click(function(){
		var data=[{roleName:"aop_role_name测试_send_1",note:"note_send_1"},{roleName:"aop_role_name_send_2",note:"note_send_2"},{roleName:"aop_role_name_send_3",note:"note_send_3"}];
		request( base_url+"/role/addBatch", JSON.stringify(data), "application/json");
	});
});
function request(url,data,contentType){
	$.ajax({
		type:"POST" //GET POST
		,url:url//链接
		,data:data //POST请求的数据，可以为String或Object
		,dataType:"json"
		,contentType:contentType
		,beforeSend:function(xhr){
		
		//alert((typeof xhr)== 'object');
		}
		,success:function(response,statusTxt,xhr){
			alert(xhr.responseText)
		}
		,error:function(xhr){
			alert("status:"+xhr.status+"\nresponse:"+xhr.responseText);
		}
		});
}
</script>
</head>
<body>
	<input id="base_url" type="hidden" value="<c:url value='/'></c:url> ">

	<button id="btn3">批量添加</button><br>
</body>
</html>