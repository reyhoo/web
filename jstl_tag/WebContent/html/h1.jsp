<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>传统标签</title>
<style type="text/css" >
	
	#header,#siderLeft,#siderRight,#footer{
		border: solid 1px #666;
		padding:10px;
		margin: 6px;
	}
	#header{width:50%;
	text-align: center;
	}
	#siderLeft{
		float:left;
		width:60px;
		height:100px;
	}
	#siderRight{
		float:left;
		width:406px;
		height:100px;
	}
	#footer{
		clear: both;
		width:500px;
	}
</style>
</head>
<body>
	
	<div id="header">导航</div>
	<div id="siderLeft">菜单</div>
	<div id="siderRight">内容</div>
	<div id="footer">底部说明</div>
</body>
</html>