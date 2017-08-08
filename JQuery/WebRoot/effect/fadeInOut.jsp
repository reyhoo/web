<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String appPath = application.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<base target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<%=appPath%>/js/jquery.js"></script>
<script>
	var isShowing = false;
	$(document).ready(function() {
		$('#fadeIn_b').click(function() {
			if (isShowing == null){
				$(this).text('正在执行操作，请稍候。。。');
				return;
			}
			var btn = $(this);
			if (!isShowing) {
				isShowing = null;
				$('#div1').fadeIn();
				$('#div2').fadeIn('slow');
				$('#div3').fadeIn(3000, function() {
					isShowing = true;
					btn.text('点击这里，使三个矩形淡出');
				});

			} else {
				isShowing = null;
				$('#div1').fadeOut();
				$('#div2').fadeOut('slow');
				$('#div3').fadeOut(3000, function() {
					isShowing = false;
					btn.text('点击这里，使三个矩形淡入');
				});
			}

		});
	});
</script>
</head>

<body>
	<p>演示带有不同参数的 fadeIn()fadeOut() 方法。</p>
	<button id=fadeIn_b>点击这里，使三个矩形淡入</button>
	<br>
	<br>
	<div id=div1
		style="width:80px;height:80px;display:none;background-color:red;float: left"></div>
	<div id=div2
		style="width:80px;height:80px;display:none;background-color:green;float: left"></div>
	<div id=div3
		style="width:80px;height:80px;display:none;background-color:blue;float: left"></div>
	<div style='clear:both;'></div>
	<hr>
</body>
</html>
