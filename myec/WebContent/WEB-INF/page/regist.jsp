<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${loginUser != null }">
	<c:redirect url="/page/main"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册页面</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.0.js"></script>
	  <script src="http://passport.cnblogs.com/scripts/jsencrypt.min.js"></script>
<script type="text/javascript">

	var encrypted = false;
	var base_url = null;
	$(function() {
		base_url = $("#base_url").val().trim();
		$("#getVerifyCode").click(
				function() {

					var email = $("#username").val();
					if (email == "") {
						alert("邮箱不能为空");
						return;
					}
					var url = $("#base_url").val().trim() + "user/sendEmail";
					requestAjax(url, "email=" + email,
							"application/x-www-form-urlencoded", function(
									response, statusTxt, xhr) {
								if (xhr.status == 200) {
									var jsonStr = xhr.responseText;
									var data = JSON.parse(jsonStr);
									if (data.result == "success") {
										alert("验证码发送成功！");
									} else {
										alert(data.errInfo);
									}
								} else {
									alert("访问异常(" + xhr.status + ")");
								}
							}, function(xhr) {
								alert("网络异常(" + xhr.status + ")");
							});
				});
		
		$("#registBtn").click(function(){
			/**if(encrypted){
				encrypted = false;
				return true;
			}
			
			var realPwd = $("#password").val().trim();
	         if(realPwd){
	        	 var formData = new FormData(document.getElementById("f1"));
	        	 var transPwd = "";
	        	 for(var i = 0;i < realPwd.length; i ++){
	        		 transPwd +="*";
	        	 }
	        		var encrypt = new JSEncrypt();
		        	encrypt.setPublicKey($("#rsaPublicKey").val());
	        	    var data = encrypt.encrypt(realPwd);
	        	    $("form input[name='password']").val(transPwd);
	    			$("form input[name='enPassword']").val(encodeURI(data).replace(/\+/g, '%2B'));
	         }else{
	        	 $("form input[name='enPassword']").val("");
	        	 $("form input[name='password']").val("");
	         }
	     
			$("form").submit();
			encrypted = true;**/
			
				var formJson = arrayToJson($('#f1').serializeArray());
				var okJson = {};
				for(var p in formJson){
					if(p == "opassword"){
						 var transPwd = "";
			        	 for(var i = 0;i < formJson[p].length; i ++){
			        		 transPwd +="*";
			        	 }
			        	okJson.password=transPwd;
		        		var encrypt = new JSEncrypt();
			        	encrypt.setPublicKey($("#rsaPublicKey").val());
		        	    var data = encrypt.encrypt(formJson[p]);
			        	okJson.enPassword=encodeURI(data).replace(/\+/g, '%2B');
					}else{
						okJson[p]=formJson[p];
					}
					
				}
				var data = "";
				for(var p in okJson){
					data +=p;
					data+="=";
					data+=encodeURI(okJson[p]);
					data+="&";
				}
				if(data.length>0){
					data = data.substring(0,data.length-1);
				}
				 requestAjax($("#f1").attr("action"),data,"application/x-www-form-urlencoded",
						 function(response, statusTxt, xhr){
					 if (xhr.status == 200) {
							var jsonStr = xhr.responseText;
							var data = JSON.parse(jsonStr);
							if (data.result == "success") {
								location.assign(base_url+"page/login");
							} else {
								$("#errTag").html(data.errInfo);
							}
						} else {
							$("#errTag").html("访问异常(" + xhr.status + ")");
						}
				 },function(xhr){
					 $("#errTag").html("网络异常(" + xhr.status + ")");
				 });
		});
	});
	function arrayToJson(formArray){
		  var dataArray = {};
		  $.each(formArray,function(){
		    if(dataArray[this.name]){
		      if(!dataArray[this.name].push){
		        dataArray[this.name] = [dataArray[this.name]];
		      }
		      dataArray[this.name].push(this.value || '');
		    }else{
		      dataArray[this.name] = this.value || '';
		    }
		  });
		  return dataArray;
		}
	function requestAjax(url, bodyData, contentType, successCb, failCb) {
		$.ajax({
			type : "POST" //GET POST
			,
			url : url //链接
			,
			data : bodyData//POST请求的数据，可以为String或Object
			,
			dataType : "json",
			contentType : contentType,
			success : successCb,
			error : failCb
		});
	}
</script>
</head>
<body>
	<input type="text" readonly="readonly" id="rsaPublicKey"
		value="${publicKey }">
		<input type="hidden" id="base_url" value='<c:url value="/"></c:url>'>
	<br>
	<input type="hidden" id="base_url" value='<c:url value="/"></c:url>'>
	<a href='<c:url value="/page/main"></c:url>'>首页</a>
	<c:url value="/user/regist" var="registUrl"></c:url>
	<div 
		style="margin: 0 auto; background-color: #cccccc; width: 300px;">
	<form action="${registUrl }" id="f1" 
		method="post">
		username<input name="username" type="text" id="username"><input
			type="button" value="获取验证码" id="getVerifyCode"><br>
		<br> password<input id="password" name="opassword" type="password"><br>
		<!-- <input type="hidden" name="password" value="">
		<input type="hidden" name="enPassword" value=""> -->
		<br> code<input name="emailCode" type="text"><br>
	</form>
		<br> <input value="注册" type="button" id="registBtn"><br>
		<br>${errInfo }<span id="errTag" style="color:red;"></span></div>
		
		
</body>
</html>