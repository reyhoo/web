<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<base target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=appPath %>/js/jquery.js"></script>
<script>
    	$(document).ready(function(){
    		$('.flip').click(function(){
    			$('.panel').slideUp('slow');
    		});
    	});
    </script>

<style>
div.panel,p.flip {
	border: 1px #c3c3c3 solid;
	background: #e5eecc;
	margin: 0;
	padding: 5px;
	text-align: center;
}
</style>
</head>

<body>
	<div class="panel" >
		<p>W3School - 领先的 Web 技术教程站点</p>
		<p>在 W3School，你可以找到你所需要的所有网站建设教程。</p>
	</div>

	<p class="flip">请点击这里</p>
</body>
</html>
