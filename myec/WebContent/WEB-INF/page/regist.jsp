<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	$(function() {
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
		
		$("form").submit(function(){
			if(encrypted){
				encrypted = false;
				return true;
			}
			
	         if($("#password").val().trim()){
	        		var encrypt = new JSEncrypt();
		        	encrypt.setPublicKey($("#rsaPublicKey").val());
	        	    var data = encrypt.encrypt($("#password").val().trim());
	    			$("form input[name='password']").val(encodeURI(data).replace(/\+/g, '%2B'));
	         }else{
	        	 $("form input[name='password']").val("");
	         }
	     
			$("form").submit();
			encrypted = true;
			return false;
		});
	});

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
	<br>
	<input type="hidden" id="base_url" value='<c:url value="/"></c:url>'>
	<a href='<c:url value="/page/main"></c:url>'>首页</a>
	<c:url value="/user/regist" var="registUrl"></c:url>
	<form action="${registUrl }"
		style="margin: 0 auto; background-color: #cccccc; width: 300px;"
		method="post">
		username<input name="username" type="text" id="username"><input
			type="button" value="获取验证码" id="getVerifyCode"><br>
		<br> password<input id="password" type="password"><br>
		<input type="hidden" name="password" value="">
		<br> code<input name="emailCode" type="text"><br>
		<br> <input value="注册" type="submit"><br>
		<br>${errInfo }
	</form>
</body>
</html>