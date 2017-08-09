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
    		jq("#removeBtn").click(function(){
    			jq("#div1").remove();
    		});
    		jq("#emptyBtn").click(function(){
    			jq("#div1").empty();
    		});
    		jq("#removeBtn1").click(function(){
    			jq(".p1").remove();
    		});
    	});
    </script>
    <style type="text/css">
    
    </style>
  </head>
  
  <body>
  
<div id="div1" style="height:100px;width:300px;border:1px solid black;background-color:yellow;">
This is some text in the div.
<p>This is a paragraph in the div.</p>
<p class='p1'>This is another paragraph in the div.</p>
</div>

<br>
<button id=removeBtn>删除 div 元素</button>
<button id=emptyBtn>清空 div 的所有内容</button>
<button id=removeBtn1>删除 class="italic" 的所有 p 元素</button>

  </body>
</html>
