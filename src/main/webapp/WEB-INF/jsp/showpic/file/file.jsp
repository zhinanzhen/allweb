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
$(function(){
	fileUpload();
});
function fileUpload(){
	 $("#attach").fileupload({
	  	  basePath:"<%=basePath%>",
	  	  jsessionid : '<%=request.getSession().getId()%>',
	  	  prefix:"dbfAuditApply",
	  	  module:"dbfAuditApply",
	  	  onSuccess:function(msg){
	  		  if("1" == msg.result){
	  			  $("#attach").hide();
	  			  $("#filePath").val(msg.filePath);
	  			  $(".cancel a").attr("href","javascript:$('#attach').uploadify('destroy')"); 
	  		  }else{
	  			  alert("文件上传失败！");
	  		  }
	  	  },
	  	  onDestroy:function(){
	  		  $("#appendFile").html('<input type="file" id="attach">');
	  		  deleteFile();
	  	  }
    });
}
/* 删除文件 */
function deleteFile(){
	$.ajax({
		   type: "POST",
		   url: "<%=basePath%>/fileUpload/deleteFile.html",
		   data: {filePath:$("#filePath").val()},
		   dataType:"json",
		   success: function(msg){
			  $("#filePath").val("");
			  $("#attachTips").show();
  		  	  fileUpload();
		   }
		});
}
</script>
</head>
<body>
<form>
 <input type="file" id="attach">
 <input type="hidden" id="filePath" value="" >
</form>
</body>
</html>