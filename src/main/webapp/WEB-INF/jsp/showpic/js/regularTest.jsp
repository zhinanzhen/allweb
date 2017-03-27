<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/test.tld" prefix="fmt"%>
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
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=basePath%>/jsp/showpic/js/js/regularTest.js"></script>
<script type="text/javascript">
	$(function(){
		$("#xiaoshu").bind("keyup", function () {
			//必须以数字或者点开头（包含点）
            this.value = this.value.replace(/[^\d.]/g, "");
            //必须保证第一个为数字而不是.（除去上面的点开头的情况）
            this.value = this.value.replace(/^\./g, "");
            //保证只有出现一个.而没有多个.
            this.value = this.value.replace(/\.{2,}/g, ".");
            //保证.只出现一次，而不能出现两次以上
            this.value = this.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
        });
		$("#xiaoshu").bind("paste", function () {
            var s = clipboardData.getData('text');
            if (!/\D/.test(s)) return false;
            value = s.replace(/^0*/, '');
            return false;
        });
		$("#othertest").blur(function(){
			alert(/^(\d*)(\.\d*)?$/.test($(this).val()));
		});
	});
	function regInput(obj, reg, inputStr) {
		var docSel = document.selection.createRange()
		if (docSel.parentElement().tagName != "INPUT")
			return false
		oSel = docSel.duplicate()
		oSel.text = ""
		var srcRange = obj.createTextRange()
		oSel.setEndPoint("StartToStart", srcRange)
		var str = oSel.text + inputStr + srcRange.text.substr(oSel.text.length)
		return reg.test(str)
	}
</script>
</head>
<body>
金额：<input id="amount"  name="amount" type="text" size="20" maxlength="14" 
		onkeypress="return regInput(this,/^\d*\.?\d{0,2}$/,String.fromCharCode(event.keyCode))"
		            onpaste="return regInput(this,/^\d*\.?\d{0,2}$/,window.clipboardData.getData('Text'))"
		            ondrop="return regInput(this,/^\d*\.?\d{0,2}$/,event.dataTransfer.getData('Text'))"
		            style="ime-mode: Disabled" /><br>
		           <!--  /^(0|[1-9]\d*)(\.\d*)?$/g -->
正整数：<input type="text" name="name" value="" onkeyup="value=value.replace(/[^\d]/g,'')" /><br>
xiao整数：<input id="xiaoshu" type="text" name="name" value="" /><br>
	保留2位小数:<input type="text" size="20" onkeydown="if(event.keyCode == 13) alert(/^-?\d+\.?\d{0,2}$/.test(this.value));">
<input id="othertest" style="ime-mode:disabled"/>

<br>
自定义标签
<fmt:number value="045345345" pattern="#,###.##"/>
</body>
</html>