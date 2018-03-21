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
	$("#btn1").click(function(){
		var data = {roleName:"send",note:"send",pageParams:{start:3,limit:3}};
		request( base_url+"json/findRoles", JSON.stringify(data), "application/json");
	});
	$("#btn2").click(function(){
		var data=[1,2,3];
		request( base_url+"json/deleteBatch", JSON.stringify(data), "application/json");
	});
	$("#btn3").click(function(){
		var data=[{roleName:"role_name_send_1",note:"note_send_1"},{roleName:"role_name_send_2",note:"note_send_2"},{roleName:"role_name_send_3",note:"note_send_3"}];
		request( base_url+"json/addRoles", JSON.stringify(data), "application/json");
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
	<button id="btn1">分页查询</button><br><br>
	<button id="btn2">批量删除</button><br><br>
	<button id="btn3">批量添加</button><br>
</body>
</html>