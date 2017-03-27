<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path; 
	Cookie cook = new Cookie("user","xu");
	cook.setMaxAge(60);
	response.addCookie(cook);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<a href="<%=basePath %>/test/testValue.html">@Transactional(rollbackFor={Exception.class},readOnly = false)</a><br>
	<a href="<%=basePath %>/js/regularTest.html">正则表达式</a>
	<a href="<%=basePath %>/fileUpload/page.html">文件上传</a>
	<a href="<%=basePath %>/excel/excelPage.html">excel相关</a>
	<a href="<%=basePath %>/schedule/showAllScheduleJob.html">定时</a>
</body>
</html>