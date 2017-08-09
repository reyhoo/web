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
    	jq('button').width(200);
    		jq('#firstBtn').click(function(){
    			jq('body').find("*").css('background-color','');
    			jq('div p').first().css('background-color','yellow');
    		});
    		jq('#lastBtn').click(function(){
    			jq('body').find("*").css('background-color','');
    			jq('div p').last().css('background-color','yellow');
    		});
    		jq('#eqBtn').click(function(){
    			jq('body').find("*").css('background-color','');
    			jq('div p').eq(1).css('background-color','yellow');
    		});
    		jq('#filterBtn').click(function(){
    			jq('body').find("*").css('background-color','');
    			jq('div p').filter('.1').css('background-color','yellow');
    		});
    		jq('#notBtn').click(function(){
    			jq('body').find("*").css('background-color','');
    			jq('div p').not('.1').css('background-color','yellow');
    		});
    		
    	});
    </script>
  </head>
  
  <body>
 <h1>欢迎来到我的主页</h1>
<div>
<p>这是 div 中的一个段落。</p>
</div>

<div>
<p class=1>这是 div 中的另一个段落。</p>
</div>

<div>
<p class=1>这还是 div 中的一个段落。</p>
</div>
<p>这也是段落。</p>
<p><button id=firstBtn>first</button></p>
<p><button id=lastBtn>last</button></p>
<p><button id=eqBtn>eq(1)</button></p>
<p><button id=filterBtn>filter('.1')</button></p>
<p><button id=notBtn>not('.1')和filter相反</button></p>
<p>所选元素是div里面的p</p>
  </body>
</html>
