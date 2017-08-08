<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String appPath = application.getContextPath(); %>

<!DOCTYPE html>
<html>
  <head>
  <base target="_blank">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="<%=appPath %>/js/jquery.js"></script>
    <script>
    var jq = jQuery.noConflict();
    	jq(function(){
    		jq('#btn1').click(function(){
    			alert('Text:'+jq('#test').text());
    		});
    		jq('#btn2').click(function(){
				alert('Text:'+jq('#test').html());
    		});
    		jq('#showValue').click(function(){
    			alert('Value:'+jq('#test_input').val());
    		});
    		jq('#showAttr').click(function(){
    			alert(jq('a').attr('href'));
    		});
    	});
    </script>
  </head>
  
  <body>
  	<p id=test>这是段落中的<b>粗体</b>文本。</p>
  	<button id=btn1>显示文本</button>
  	<button id=btn2>显示 HTML</button><hr>
  	
  	<p>姓名：<input type="text" id="test_input" value="HELLO" disabled="disabled" ></p>
<button id=showValue>显示值</button><hr>
<p><a href="http://www.baidu.com">百度一下</a></p>
<button id=showAttr>显示属性值</button>
  </body>
</html>
