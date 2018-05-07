<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页面</title>
<style type="text/css">
.curr{
		color:red;
	}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script type="text/javascript">
</script>
</head>
<body>

	<c:import url="/WEB-INF/page/header.jsp">
		<c:param name="currPage" value="0"></c:param>
	</c:import>
	主界面
</body>
</html>