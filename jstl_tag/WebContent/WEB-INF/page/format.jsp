<%@page import="com.jstl.tag.pojo.User"%>
<%@page import="com.jstl.tag.pojo.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>格式化</title>
</head>
<body>
	<table border="1">
		<tr><td>日期<td>
		
		日期格式化（1）:<fmt:formatDate value="${date }" type="time"/><p>
		日期格式化（2）:<fmt:formatDate value="${date }" type="date"/><p>
		日期格式化（3）:<fmt:formatDate value="${date }" type="both"/><p>
		日期格式化（4）:<fmt:formatDate value="${date }" type="both"  dateStyle="short"
		 timeStyle="short"
		 /><p>
			日期格式化（5）:<fmt:formatDate value="${date }" type="both"  dateStyle="medium"
		 timeStyle="medium"
		 /><p>
		日期格式化（6）:<fmt:formatDate value="${date }" type="both"  dateStyle="long"
		 timeStyle="long"
		 /><p>
		 日期格式化（7）:<fmt:formatDate value="${date }" pattern="yyyy-MM-dd"
		 /><p>
		 <td>数字
		 <td>格式化数字（1）:<fmt:formatNumber value="${num }" type="currency"></fmt:formatNumber><p>
			格式化数字（2）:<fmt:formatNumber value="${num }" type="number" maxIntegerDigits="3"></fmt:formatNumber><p>
		 格式化数字（3）:<fmt:formatNumber value="${num }" type="number" maxFractionDigits="2"></fmt:formatNumber><p>
		 格式化数字（4）:<fmt:formatNumber value="${num }" type="number" groupingUsed="false"></fmt:formatNumber><p>
		 格式化数字（5）:<fmt:formatNumber value="${num }" type="percent" maxIntegerDigits="3"></fmt:formatNumber><p>
		 格式化数字（6）:<fmt:formatNumber value="${num }" type="percent" minFractionDigits="2"></fmt:formatNumber><p>
		 格式化数字（7）:<fmt:formatNumber value="${num }" type="percent" minIntegerDigits="3"></fmt:formatNumber><p>
		 格式化数字（8）:<fmt:formatNumber value="${num }" type="number" pattern="#,###.00"></fmt:formatNumber><p>
		 人民币：<fmt:setLocale value="zh_CN"/><fmt:formatNumber value="${num }" type="currency"></fmt:formatNumber>
	</table>
</body>
</html>