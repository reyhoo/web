<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加角色</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
var jq = $.noConflict();
jq(function(){
	jq("#btn1").click(function(){
		var data = {roleName:"姚",note:"姚",pageParams:{start:0,limit:20}};
		request(data);
	});
});
function request(data){
	jq.ajax({
		type:"POST" //GET POST
		,url:"params/findRoles.do" //链接
		,data:JSON.stringify(data) //POST请求的数据，可以为String或Object
		,dataType:"json"
		,contentType:"application/json"
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
		<form action="./params/commonParams.do" method="post">
<!-- 			<label>角色名称</label><input type="text" name="roleName"><br><br> -->
 			<label>角色名称</label><input type="text" name="role_name"><br><br> 
			<label>备注&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" name="note"><br><br>
			<input type="submit" value="添加">
		</form>
	</fieldset>
	
	<button id="btn1">分页查询</button>
	
</body>
</html>