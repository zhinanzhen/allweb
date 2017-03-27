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
	src="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/js/bootstrap-treeview.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/css/bootstrap.css">
<script type="text/javascript">
	$(function() {
		var tree = [ {
			text : "Parent 1",
			icon : "glyphicon glyphicon-stop",
			nodes : [ {
				text : "Child 1",
				nodes : [ {
					text : "Grandchild 1"
				}, {
					text : "Grandchild 2"
				} ]
			}, {
				text : "Child 2"
			} ]
		}, {
			text : "Parent 2"
		}, {
			text : "Parent 3"
		}, {
			text : "Parent 4"
		}, {
			text : "Parent 5"
		} ];
		$('#tree').treeview({
			data : tree
		});
	});
	function getTree() {
		return data;
	}
</script>
</head>
<body>
	<div id="tree"></div>
</body>
</html>