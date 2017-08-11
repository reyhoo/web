<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link rel="stylesheet" href="<%=path%>/css/jquery.mobile-1.3.2.min.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.mobile-1.3.2.min.js"></script>
	<script>
		var jq = $.noConflict();
		var appPath = null;
		jq(function(){
			appPath = jq("#app_path").val();
		});
	</script>
	<style>
		body *{
			/*padding:0;
			margin: 0;*/
		}
	</style>
  </head>
  
  <body>
 <input type="hidden" id=app_path value="<%=path%>"> 
	<div data-role=page id=pageone>
		<div data-role=header><h1>欢迎访问我的主页1</h1></div>
		<div data-role=content><p>page 1</p><a href="#pagetwo" data-transition=none>jump to page 2</a></div>
		<div data-role=footer><h1>页脚文本</h1></div>
	</div>
	<div data-role=page id=pagetwo>
		<div data-role=header><h6>欢迎访问我的主页2</h6></div>
		<div data-role=content><p>page 2</p><a href="#pageone" data-transition=none>jump to page 1</a></div>
		<div data-role=footer><h1>页脚文本</h1></div>
	</div>
  </body>
</html>
