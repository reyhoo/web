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
    		jq("#widthBtn").click(function(){
    		    var txt = 'width:<b>';
    			txt += jq('div').width() +'</b><br>';
    			txt += 'height:<b>';
    			txt += jq('div').height() +'</b>';
    			jq('div').html(txt);
    		});
    		jq("#innerWidthBtn").click(function(){
    		    var txt = 'innerWidth:<b>';
    			txt += jq('div').innerWidth() +'</b><br>';
    			txt += 'innerHeight:<b>';
    			txt += jq('div').innerHeight() +'</b>';
    			jq('div').html(txt);
    		});
    			jq("#outerWidthBtn").click(function(){
    		    var txt = 'outerWidth:<b>';
    			txt += jq('div').outerWidth() +'</b><br>';
    			txt += 'outerHeight:<b>';
    			txt += jq('div').outerHeight() +'</b>';
    			jq('div').html(txt);
    		});
    			jq("#outerWidthTrueBtn").click(function(){
    		    var txt = 'outerWidth(+margin):<b>';
    			txt += jq('div').outerWidth(true) +'</b><br>';
    			txt += 'outerHeight(+margin):<b>';
    			txt += jq('div').outerHeight(true) +'</b>';
    			jq('div').html(txt);
    		});
    		jq('#setWidthBtn').click(function(){
    			jq('div').width(500).height(500);
    		});
    	});
    </script>
</head>

<body style="margin:0;padding:0;">
	<div style="width:300px;height:100px;background-color: lightblue; margin:3px;padding:10px;border: 1px solid blue"></div>
	<p><button id=widthBtn>width height(不包含border,padding,margin)</button></p>
	<p><button id=innerWidthBtn>innerWidth innerWidth(包含padding)</button></p>
	<p><button id=outerWidthBtn>outerWidth outerHeight(包含padding,border)</button></p>
	<p><button id=outerWidthTrueBtn>outerWidth(true) outerHeight(true)(包含padding,border,margin)</button></p>
	<p><button id=setWidthBtn>设置宽度和高度</button></p>
</body>
</html>
