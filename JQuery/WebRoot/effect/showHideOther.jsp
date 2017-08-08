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
    		$('#hide').click(function(){
    		
    			var callback = function(data){
    			alert('hide finish!!!'+data);
    			};
    			$('.hide_p').hide(1000,callback);
    		});
    		$('#switch').click(function(){
    			$('.switch_p').toggle();
    		});
    	});
    </script>
  </head>
  
  <body>
  		<button type="button" id=hide>隐藏</button>
<p class=hide_p>这是一个段落。</p>
<p class=hide_p>这是另一个段落。</p>
<HR>
<button type="button" id=switch>切换</button>
<p class=switch_p style='display:inline;'>这是一个段落。</p>
<p class=switch_p style='display:inline;'>这是另一个段落。</p>
  </body>
</html>
