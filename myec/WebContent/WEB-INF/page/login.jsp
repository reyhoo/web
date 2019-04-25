<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${loginUser != null }">
	<c:redirect url="/page/main"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<script type="text/javascript"
	src="<c:url value='/js/jquery-3.2.0.js'></c:url>"></script>
	  <script src="<c:url value='/js/jsencrypt.min.js'></c:url>"></script>
	  <script type="text/javascript">
	  var encrypted = false;
	  	$(function(){
	  		$("form").submit(function(){
				if(encrypted){
					encrypted = false;
					return true;
				}
				
				var realPwd = $("#password").val().trim();
		         if(realPwd){
		        	
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
				encrypted = true;
				return false;
			});
	  	});
	  </script>
</head>
<body>
<input type="text" readonly="readonly" id="rsaPublicKey" value="${publicKey }"><br>
<c:url value="/page/regist" var="toRegistUrl"></c:url>
<a href="${toRegistUrl}">注册</a>
	<c:url value="/user/login" var="loginUrl"></c:url>
	<form action="${loginUrl }" id="f1" style="padding:50px;margin: 100px auto;background-color: #cccccc;width: 300px;" method="post">
		username<input name="username" type="text"><br><br>
		password<input id="password" type="password"><br><br>
		<input type="hidden" name="password" value="">
		<input type="hidden" name="enPassword" value="">
		<input value="登录" type="submit"><br><br>${errInfo }
	<%-- 	<c:if test="${errInfo!=null }">
			<spring:message code="${errInfo }"></spring:message>
		</c:if> --%>
	</form>
</body>
</html>