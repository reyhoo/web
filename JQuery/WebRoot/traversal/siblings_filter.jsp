<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<base target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=appPath %>/js/jquery.js"></script>
<style>
.siblings * {
	display: block;
	border: 2px solid lightgrey;
	color: lightgrey;
	padding: 5px;
	margin: 15px;
}
</style>
<script>
    	var jq = $.noConflict(); 
    	jq(function(){
    		jq('h2').siblings('p').css('border','2px solid red');
    	});
    </script>
</head>

<body class=siblings>
	<div>
		div (父)
		<p>p</p>
		<span>span</span>
		<h2>h2(被选元素)</h2>
		<h3>h3</h3>
		<p>p</p>
	</div>
	<p>siblings('p') 方法返回被选元素的所有所选同胞元素。</p>
</body>
</html>
