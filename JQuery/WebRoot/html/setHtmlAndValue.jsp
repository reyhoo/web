<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<base target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=appPath %>/js/jquery.js"></script>
<script>
    	$(function(){
    	$("#btn1").click(function(){
    $("#test1").text("Hello world!");
  });
  $("#btn2").click(function(){
    $("#test2").html("<b>Hello world!</b>");
  });
  $("#btn3").click(function(){
    $("#test3").val("Dolly Duck");
  });
    	});
    </script>
</head>

<body>
	<p id="test1">这是段落。</p>
	<p id="test2">这是另一个段落。</p>
	<p>
		Input field: <input type="text" id="test3" value="Mickey Mouse">
	</p>
	<button id="btn1">设置文本</button>
	<button id="btn2">设置 HTML</button>
	<button id="btn3">设置值</button>
</body>
</html>
