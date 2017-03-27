<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript"
	src="<%=basePath%>/resources/js/jquery-2.0.3.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resources/js/index.js"></script>
<script type="text/javascript">
$(function(){
	$("form").find("[data_validate]").filter(function(){
		return _exists(this) && !this.disabled;
	});
	/* .map(function(){
		return _getFieldValidator(this);
	}).toArray(); */
	
	$("#reset").click(function(){
		$("#formId").res();
	});
	$("#closest").click(function(){
		alert($("input[name=addres]").closest('#formId2').size());
		alert($("input[name=addres]").p('#formId2').size());
	});
});
//判断元素可见并存在
function _exists( el ){
    return $(el).closest('body').size() > 0 && $(el).is(":visible");
}
//得到指定元素的jvalidator
function _getFieldValidator( el ){
    if( el.nodeName == "INPUT" && ( el.type == "checkbox" || el.type == "radio" ) ) {
        el = $(el).closest("form").find("input[data_validate][name=" + el.name + "]")[0];
    }
    if( !el ) return;
    if( !$(el).attr( "data_validate" ) ) return;
    return el._field_validator ? el._field_validator : ( el._field_validator = new FieldChecker( el ) );
}
//## 字段检查器
//绑定到某个字段后，对其进行检查等操作
function FieldChecker( element ) {
 this.element = element;
 this.$element = $(element);
 this.$form = this.$element.closest('form');
}
</script>
</head>
<body>
<a href="<%=basePath %>/login/loginPage.html">登陆</a>/
<a href="<%=basePath %>/register/registerPage.html">注册</a>
<form id = "formId">
	名字：<input type="text" name="name" data_validate="required">
	年龄：<input type="text" name="age" data_validate="no_required">
	email:<input type="text" name="email" data_validate="no_required">
	addres:<input type="text" name="addres" data_validate="no_required">
</form>
<form id = "formId2">
	名字：<input type="text" name="name" data_validate="required">
	年龄：<input type="text" name="age" data_validate="no_required">
	email:<input type="text" name="email" data_validate="no_required">
</form>
<button id = "reset">重置</button>
<button id = "closest">closest</button>


<a href="<%=basePath %>/map/keyMap.html">地图</a>
<a href="<%=basePath %>/map/check.html">check</a>
</body>
</html>