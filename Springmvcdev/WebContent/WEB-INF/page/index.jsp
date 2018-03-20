<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加角色</title>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js'></c:url>"></script>
<script type="text/javascript">
var jq = $.noConflict();
jq(function(){
	jq("#btn1").click(function(){
		var data = {roleName:"姚",note:"姚",pageParams:{start:0,limit:20}};
		request("params/findRoles.do" ,JSON.stringify(data),"application/json");
	});
	jq("#btn2").click(function(){
		var data = [98,99,100,101,102,103,104,105,106,107];
		request("params/deleteRoles.do" ,JSON.stringify(data),"application/json");
	});
	jq("#btn3").click(function(){
		var data = [{roleName:"mvc_role_name_1",note:"mvc_note_1"}
		,{roleName:"mvc_role_name_2",note:"mvc_note_2"}
		,{roleName:"mvc_role_name_3",note:"mvc_note_3"}];
		request("params/addRoles.do" ,JSON.stringify(data),"application/json");
	});
	jq("#commit").click(function(){
		var data = jq("#form").serialize();
		request("params/commonParams2.do" ,data,"application/x-www-form-urlencoded");
	});
});
function request(url,data,contentType){
	jq.ajax({
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

	<fieldset>
		<legend>添加</legend>
		
	<!-- 	  -->
		
		<form method="post" id="form" action="./params/addRole2.do">
			<label>角色名称</label><input type="text" name="roleName"><br><br> 
 		<!-- 	<label>角色名称</label><input type="text" name="role_name"><br><br> -->
			<label>备注&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="note"><br><br>
			 <input type="submit" value="添加">
			<!-- <button id='commit'>提交</button> -->
		</form>
	</fieldset>
	
	<button id="btn1">分页查询</button>
	<button id="btn2">批量删除</button>
	<button id="btn3">批量添加</button>
	
</body>
</html>