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
    		jq('#appendBtn').click(function(){
    			jq('#test').append(' <b>Append Text</b>在指定的段落最后 ');
    		});
    		jq('#prependBtn').click(function(){
    			jq('#test').prepend(' <b>Prepend Text</b>在指定的段落前面 ');
    		});
    		jq('#beforeBtn').click(function(){
    			jq('#test').before(jq('<p></p>').html('<b>这是一个新的段落（before）</b>'));
    		});
    		jq('#afterBtn').click(function(){
    			jq('#test').after(jq('<p></p>').html('<b>这是一个新的段落（after）</b>'));
    		});
    	});
    </script>
  </head>
  <body>
  	<p id=test style='background-color: grey;'>这是一个段落</p>
  	<button id="appendBtn">appendBtn</button>
  	<button id="prependBtn">prependBtn</button>
  	<button id="beforeBtn">beforeBtn</button>
  	<button id="afterBtn">afterBtn</button>
  </body>
</html>
