<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="utf-8">
<title>form表单</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">
$(function(){
	var base_url=$("#base_url").val().trim();
	$("#fieldAdd").click(function(){
		request( base_url+"role/add", "roleName=我是fieldAdd&note=我是fieldAddnote", "application/x-www-form-urlencoded");
	});
	$("#bodyAdd").click(function(){
		request( base_url+"role/bodyAdd", JSON.stringify({roleName:"我是bodyAdd",note:"bodyAddnote"}), "application/json");
	});
	$("#fieldConverterAdd").click(function(){
		request( base_url+"role/add", "role=0-我是fieldConverterAdd-我是fieldConverterAddnote", "application/x-www-form-urlencoded");
	});
	$("#submit2").click(function(){
		request( base_url+"test/submit2", "role=0-我是fieldConverterAdd-我是fieldConverterAddnote", "application/json");
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
	<fieldset>
		<legend>添加角色</legend>
		<form action="<c:url value='/role/add'></c:url>" method="post">
			roleName:<input type="text" name="roleName"><br> note:<input
				type="text" name="note"><br> <input type="submit"
				value="添加">
		</form>

	</fieldset>

	<fieldset>
		<legend>文件上传</legend>
		<form action="<c:url value='/file/upload'></c:url>" method="post"
			enctype="multipart/form-data">
		 	name:<input type="text" name="name"><br> file:<input
				type="file" name="f"><br> <input type="submit"
				value="上传">
		</form>
	</fieldset>
	
	
		<fieldset>
		<legend>两个input的name相同表单提交</legend>
		<form action="<c:url value='/test/submit1'></c:url>" method="post">
			name1:<input type="text" name="name"><br>
			name2:<input type="text" name="name"><br>
			
			 <input type="submit"
				value="提交">
		</form>
	</fieldset>
	<button id="fieldAdd">fieldAdd</button><br><br>
	<button id="bodyAdd">bodyAdd</button><br><br>
	<button id="fieldConverterAdd">fieldConverterAdd</button><br><br>
	<button id="submit2">submit2</button><br>
	<h1>
		<spring:message code="company"></spring:message>
	</h1>
	Locale:${pageContext.response.locale }
</body>
</html>