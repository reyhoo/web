<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>exception</title>
</head>
<body>
<%Exception e = (Exception)request.getAttribute("exception");e.printStackTrace();%>
<%String errInfo = (String)request.getAttribute("errInfo");%>
<code style="color:red;">
${errInfo }
</code>
</body>
</html>