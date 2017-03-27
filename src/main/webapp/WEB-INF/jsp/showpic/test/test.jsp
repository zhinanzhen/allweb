<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript"
	src="<%=basePath%>/resources/js/jquery-2.0.3.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resources/js/jquery.form.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/js/bootstrap-image-gallery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/css/bootstrap-image-gallery.css">
<script type="text/javascript">
	$(function() {
		
	});
</script>
</head>
<body>
<c:forEach items="${tests}" var="item">  
        ${item.name }--${item.phone }<br />
</c:forEach>
</body>
</html>