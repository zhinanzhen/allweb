<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<div id="links">
    <a href="<%=basePath%>/resources/images/2.jpg" title="Banana" data-gallery>
        <img src="<%=basePath%>/resources/images/2.jpg" alt="Banana">
    </a>
    <a href="<%=basePath%>/resources/images/3.jpg" title="Apple" data-gallery>
        <img src="<%=basePath%>/resources/images/3.jpg" alt="Apple">
    </a>
    <a href="<%=basePath%>/resources/images/4.jpg" title="Orange">
        <img src="<%=basePath%>/resources/images/4.jpg" alt="Orange">
    </a>
</div>
</body>
</html>