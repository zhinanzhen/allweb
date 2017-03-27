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
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>/jsp/common/core.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/css/bootstrap.css">
<style type="text/css">
	.col-xs-5{
		text-align: right;
	}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<form class="form-horizontal" role="form" action="<%=basePath%>/schedule/addNewScheduleJob.html" method="post">
   <div class="form-group">
    <label for="jobGroup" class="col-xs-5 control-label">任务组</label>
    <div class="col-xs-7">
      <input type="text" name="jobGroup" class="form-control" id="jobGroup" placeholder="任务组" style="width: 70%">
    </div>
  </div>
  <div class="form-group">
    <label for="jobName" class="col-xs-5 control-label">任务名</label>
    <div class="col-xs-7">
      <input type="text" name="jobName" class="form-control" id="jobName" placeholder="任务名" style="width: 70%">
    </div>
  </div>
   <div class="form-group">
    <label for="jobStatus" class="col-xs-5 control-label">任务状态</label>
    <div class="col-xs-7">
		<label class="radio-inline">
		  <input type="radio" name="jobStatus" id="jobStatus" value="0"> 禁用
		</label>
      	<label class="radio-inline">
		  <input type="radio" name="jobStatus" id="jobStatus" value="1"> 启用
		</label>
		<label class="radio-inline">
		  <input type="radio" name="jobStatus" id="jobStatus" value="2"> 暂停
		</label>
    </div>
  </div>
   <div class="form-group">
    <label for="isSpringBean" class="col-xs-5 control-label">是否是Spring中定义的Bean</label>
    <div class="col-xs-7">
     	<label class="radio-inline">
		  <input type="radio" name="isSpringBean" id="isSpringBean" value="0"> 否
		</label>
      	<label class="radio-inline">
		  <input type="radio" name="isSpringBean" id="isSpringBean" value="1"> 是
		</label>
    </div>
  </div>
   <div class="form-group">
    <label for="clazz" class="col-xs-5 control-label">类名</label>
    <div class="col-xs-7">
      <input type="text" name="clazz" class="form-control" id="clazz" placeholder="类名" style="width: 70%">
    </div>
  </div>
   <div class="form-group">
    <label for="targetMethod" class="col-xs-5 control-label">任务方法</label>
    <div class="col-xs-7">
      <input type="text" name="targetMethod" class="form-control" id="targetMethod" placeholder="任务方法" style="width: 70%">
    </div>
  </div>
   <div class="form-group">
    <label for="cronExpression" class="col-xs-5 control-label">任务运行时间表达式</label>
    <div class="col-xs-7">
      <input type="text" name="cronExpression" class="form-control" id="cronExpression" placeholder="任务运行时间表达式" style="width: 70%">
    </div>
  </div>
   <div class="form-group">
    <label for="concurrent" class="col-xs-5 control-label">是否并发</label>
    <div class="col-xs-7">
      <label class="radio-inline">
		  <input type="radio" name="concurrent" id="concurrent" value="0"> 否
		</label>
      	<label class="radio-inline">
		  <input type="radio" name="concurrent" id="concurrent" value="1"> 是
		</label>
    </div>
  </div>
  <div class="form-group">
    <label for="description" class="col-xs-5 control-label">描述</label>
    <div class="col-xs-7">
      <input type="text" name="description" class="form-control" id="description" placeholder="描述" style="width: 70%">
    </div>
  </div>
  <div class="form-group" style="text-align: right;">
    <div class="col-sm-offset-2 col-xs-7">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>
</body>
</html>