<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<base target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=appPath %>/js/jquery.js"></script>
<script>
    	var jq = $.noConflict(); 
    	jq(function(){
    		jq('div').find('*').css({"border":"2px solid red"});
    	});
    </script>
<style>
.descendants * {
	display: block;
	border: 2px solid lightgrey;
	color: lightgrey;
	padding: 5px;
	margin: 15px;
}
</style>
</head>

<body>
<div class="descendants" style="width:500px;">div (当前元素) 
  <p class=1>p (子)
    <span>span <b style='display:inline;'>b(孙)</b></span>     
  </p>
  <p class=2>p (child)
    <span>span (孙)</span>
  </p> 
</div>
<p>find('*')方法返回被选元素的所有后代</p>
</body>
</html>
