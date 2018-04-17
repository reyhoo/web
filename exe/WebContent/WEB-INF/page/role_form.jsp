<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    	<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set scope="page" var="isUpdate" value="${requestScope.role != null}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js"></script>

<script type="text/javascript">
var base_url ;
	$(function(){
		base_url = $("#base_url").val().trim();
		$("#uploadBtn").click(function(){
			
			
			//alert(document.getElementById("file1").files[0].name);
			 var formData = new FormData();
             formData.append("file", document.getElementById("file1").files[0]);   
             $.ajax({
                 url: base_url+"/role/upload",
                 type: "POST",
                 data: formData,
                 /**
                 *必须false才会自动加上正确的Content-Type
                 */
                 contentType: false,
                 /**
                 * 必须false才会避开jQuery对 formdata 的默认处理
                 * XMLHttpRequest会对 formdata 进行正确的处理
                 */
                 processData: false,
                 success:function(response,statusTxt,xhr){
                	 console.log(xhr.responseText);
                	 var jsonObj = JSON.parse(xhr.responseText);
                	 if("0000"==jsonObj.errCode){
                		 showImg(jsonObj.pic);
                	 }else{
                		 alert(xhr.responseText);
                	 }
 				}
 				,error:function(xhr){
 					alert("status:"+xhr.status+"\nresponse:"+xhr.responseText);
 				}
             });
		
		});
		showImg($("#pic").val());
	});

	function showImg(pic){
		if(pic){
			$("#pic").val(pic);
			$("#img1").attr("src",pic).height(200).width(200);
			$("#imgLink").attr("href",pic);
			$("#uploadField").hide();
		}else{
			$("#pic").val("");
			$("#imgLink").attr("href","javascript:;");
			$("#img1").attr("src","");
			$("#uploadField").show();
		}
	}	
</script>
<title>
	${isUpdate?"更新角色":"添加角色" }
</title>
</head>
<body>
	<input id="base_url" type="hidden" value="<c:url value='/'></c:url>">
	<fieldset>
		<legend>${isUpdate?"更新角色":"添加角色" }</legend>
		<c:url var="url" value='${isUpdate?"/role/update":"/role/add" }'>
			<c:if test="${!isUpdate}">
				<c:param name="userId" value="${sessionScope.loginUser.id }"></c:param>
			</c:if>
		</c:url>
		
		<form action="${url }" method="post">
			id:<input type="text" name="id" readonly="readonly" value="${requestScope.role.id }"><br><br>
			<input type="hidden" name="userId" value="${requestScope.role.userId }">
	
			role_name:<input type="text" name="roleName" value="${requestScope.role.roleName }"><br><br>
			note:<input type="text" name="note" value="${requestScope.role.note }"><br><br>
	<input type="hidden" name="pic" id="pic" value="${requestScope.role.pic }">
			<span id="uploadField">文件：<input type="file" name="file" id="file1" style="display: inline;" value="上传文件">
		<input type="button" id="uploadBtn" value="上传"></input></span><br><br>
		<a href="#" id=imgLink><img id="img1" alt="" ></a><br><br>
			<input type="submit" value='${isUpdate ?"更新":"添加"}'>
		</form>
		
		${errInfo }
	</fieldset>
</body>
</html>