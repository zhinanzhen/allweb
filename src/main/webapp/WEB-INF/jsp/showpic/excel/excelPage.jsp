<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/uploadFile/jquery.uploadify-3.1.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/js/uploadFile/uploadify.css"/>
<script type="text/javascript" src="<%=basePath%>/resources/js/uploadFile/fileUpload.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<form>
	<a href="<%=basePath %>/excel/writeExcelToPage.html">下载excel</a>
</form>
</body>
</html>