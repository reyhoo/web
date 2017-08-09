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
    		jq('span').parents().css("border","2px solid red");
    	});
    </script>
    <style>
    
    .ancestors *
{ 
display: block;
border: 2px solid lightgrey;
color: lightgrey;
padding: 5px;
margin: 15px;
}</style>
  </head>
  
  <body>
  body
  	<div class="ancestors">div
  <div style="width:500px;">div (曾祖父)
    <ul>ul (祖父)  
      <li>li (直接父)
         <span>span(当前元素)</span>
      </li>
    </ul>   
  </div>

  <div style="width:500px;">div (祖父)   
    <p>p (直接父)
        <span>span(当前元素)</span>
      </p> 
  </div>
</div>
<p>parents返回所有祖先元素</p>
  </body>
</html>
