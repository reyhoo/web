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
    		$('#btn1').click(function(){
    			$('#test1').text(function(i,text){
    				alert("index:"+i+',旧文本：'+text);
    				return '这是新的文本';
    			});
    		});
    		$('#btn2').click(function(){
    			$('#test2').html(function(i,text){
    				alert("index:"+i+',旧文本：'+text);
    				return '这是新的<b>粗体</b文本';
    			});
    		});
    		$("#setHref").click(function(){
    			$("#link_test").attr('href','http://www.baidu.com');
    		});
    		$("#appendHref").click(function(){
    			$("#link_test").attr('href',function(i,text){
    				return text+"/j_noConflict.jsp";
    			});
    		});
    		$("#multiAttr").click(function(){
    			$("#link_test").attr({
    				"href":"http://www.baidu.com",
    				"title":"百度一下，你就知道"
    			});
    		});
    	});
    </script>
  </head>

  <body>  <p id="test1">这是<b>粗体</b>文本。</p>
<p id="test2">这是另一段<b>粗体</b>文本。</p>
<button id="btn1">显示旧/新文本</button>
<button id="btn2">显示旧/新 HTML</button>
<hr>
<p><a href='<%=appPath %>' id=link_test>Test</a></p>
<button id=setHref>改变链接地址</button>
<button id=appendHref>追加链接地址</button>
<button id=multiAttr>多个属性设置</button>
  </body>
</html>
