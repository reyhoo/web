<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">
	$(function(){
		
		var base_url=$("#base_url").val().trim();
		$("#grap").click(function(){
			
			var max = 3000;
			for(var i = 1;i <= max; i++){
				var url = base_url+"userRedPacket/grapRedPacketForVersion?redPacketId=1&userId="+i;
				$.ajax({
					type:"post" //GET POST
					,url:url//链接
					,beforeSend:function(xhr){
					}
					,success:function(response,statusTxt,xhr){
					}
					,error:function(xhr){
					}
					});
			}
			
		});
		
	$("#grap1").click(function(){
			//调用前需要在redis里设置初始参数：
			//hset red_packet_1 stock 2000
			//hset red_packet_1 unit_amount 10
			var max = 2010;
			for(var i = 1;i <= max; i++){
				var url = base_url+"userRedPacket/grapRedPacketByRedis?redPacketId=1&userId="+i;
				$.ajax({
					type:"post" //GET POST
					,url:url//链接
					,beforeSend:function(xhr){
					}
					,success:function(response,statusTxt,xhr){
					}
					,error:function(xhr){
					}
					});
			}
			
		});
		
	});

</script>
</head>
<body>
	<input id="base_url" type="hidden" value="<c:url value='/'></c:url> ">
	<button id="grap">抢红包</button>
	<button id="grap1">抢红包(Redis)</button>
</body>
</html>