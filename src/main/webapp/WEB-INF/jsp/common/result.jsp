<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
function closePageAndRefreshParent(){
	parent.closeLayer(index); 
}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${result eq '1' }">
			操作成功
		</c:when>
		<c:otherwise>
			操作失败，原因${result }&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>
	<a href="javascript:void(0)" onclick="closePageAndRefreshParent()">返回</a>
</body>
</html>