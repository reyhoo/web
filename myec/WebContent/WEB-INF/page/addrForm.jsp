<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="isModify" value="${addr!=null?true:false }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${isModify?"地址修改":"地址添加" }</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script src="http://passport.cnblogs.com/scripts/jsencrypt.min.js"></script>
<script type="text/javascript">

	
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
<c:url value="/addr/add" var="addrAddUrl"></c:url>
<c:url value="/addr/modify" var="addrModifyUrl"></c:url>
	<div 
		style="margin: 0 auto; background-color: #cccccc; width: 300px;">
	<form action="${isModify?addrModifyUrl:addrAddUrl }" id="f1" 
		method="post">
		<input name="id" type="hidden" value="${addr.id }">
		地址：<input name="addr" type="text" value="${addr.addr }"><br>
		电话：<input name="mobile" type="text" value="${addr.mobile }"><br>
		联系人：<input name="nickname" type="text" value="${addr.nickname }"><br>
		<input name="userId" type="hidden" value="${addr.userId }">
		<input type="submit" value='${isModify?"修改":"添加"  }'>
	</form>
		<br><span id="errTag" style="color:red;">${errInfo }</span></div>



</body>
</html>