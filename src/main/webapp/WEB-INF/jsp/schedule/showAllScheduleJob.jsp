<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<script type="text/javascript" src="<%=basePath%>/jsp/showpic/register/js/register.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/layer/layer.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/resources/js/layer/skin/default/layer.css">
<script type="text/javascript">
	$(function(){
		
	});
	/* 添加 */
	function addScheduleJob(jobId){
		$.ajax({
			url:"<%=basePath%>/schedule/addScheduleJob.html",
			type:"post",
			data:{"jobId":jobId},
			success:function(json){
				if(json.flag == '1'){
					alert("成功");
				}else{
					alert("添加失败，原因：" + json.flag);
				}
			},
			dataType:"json"
		});
	}
	/* 立即运行 */
	function runScheduleJobNow(jobId){
		$.ajax({
			url:"<%=basePath%>/schedule/runScheduleJobNow.html",
			type:"post",
			data:{"jobId":jobId},
			success:function(json){
				if(json.flag == '1'){
					alert("成功");
				}else{
					alert("运行失败，原因：" + json.flag);
				}
			},
			dataType:"json"
		});
	}
	/* 更新 */
	function updateScheduleJob(jobId){
		$.ajax({
			url:"<%=basePath%>/schedule/updateScheduleJob.html",
			type:"post",
			data:{"jobId":jobId},
			success:function(json){
				if(json.flag == '1'){
					alert("成功");
				}else{
					alert("失败，原因：" + json.flag);
				}
			},
			dataType:"json"
		});
	}
	/* 停止 */
	function pauseScheduleJob(jobId){
		$.ajax({
			url:"<%=basePath%>/schedule/pauseScheduleJob.html",
			type:"post",
			data:{"jobId":jobId},
			success:function(json){
				if(json.flag == '1'){
					alert("成功");
				}else{
					alert("停止失败，原因：" + json.flag);
				}
			},
			dataType:"json"
		});
	}
	/* 恢复 */
	function resumeScheduleJob(jobId){
		$.ajax({
			url:"<%=basePath%>/schedule/resumeScheduleJob.html",
			type:"post",
			data:{"jobId":jobId},
			success:function(json){
				if(json.flag == '1'){
					alert("成功");
				}else{
					alert("失败，原因：" + json.flag);
				}
			},
			dataType:"json"
		});
	}
	/* 删除 */
	function deleteScheduleJob(jobId){
		$.ajax({
			url:"<%=basePath%>/schedule/deleteScheduleJob.html",
			type:"post",
			data:{"jobId":jobId},
			success:function(json){
				if(json.flag == '1'){
					alert("成功");
				}else{
					alert("失败，原因：" + json.flag);
				}
			},
			dataType:"json"
		});
	}
	function addNewScheduleJob(){
		layer.open({
			  title: '添加新定时',
			  type:2,
			  area:['500px', '580px'],
			  content: ['<%=basePath%>/schedule/addNewScheduleJobPage.html']
			});
	}
	function closeLayer(index){
		layer.close(index);
		window.location ="<%=basePath %>/schedule/showAllScheduleJob.html";
	}
</script>
</head>
<body>
<label>定时任务管理</label><br>
<a onclick="addNewScheduleJob()" href="javascript:void(0)" style="float: right">添加新的定时</a>
	<table class="table">
		<tr>
			<th>任务id</th>
			<th>任务组</th>
			<th>任务名</th>
			<th>任务运行时间表达式</th>
			<th>类名</th>
			<th>任务方法</th>
			<th>spring定义的Bean</th>
			<th>是否并发</th>
			<th>子任务</th>
			<th>描述</th>
			<th>任务状态</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${scheduleJobs}" var="item">  
		<tr>
			<td>${item.jobId }</td>
			<td>${item.jobGroup }</td>
			<td>${item.jobName }</td>
			<td>${item.cronExpression }</td>
			<td>${item.clazz }</td>
			<td>${item.targetMethod }</td>
			<td>
				<c:choose>
					<c:when test="${item.isSpringBean eq 1}">
						是
					</c:when>
					<c:otherwise>
						否
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${item.concurrent}">
						是
					</c:when>
					<c:otherwise>
						否
					</c:otherwise>
				</c:choose>
			</td>
			<td>${item.childJobs }</td>
			<td>${item.description }</td>
			<td>
				<c:choose>
					<c:when test="${item.jobStatus eq '1' }">
						启用
					</c:when>
					<c:when test="${item.jobStatus eq '0' }">
						禁用
					</c:when>
					<c:otherwise>
						暂停
					</c:otherwise>
				</c:choose>
			</td>
			<td>${item.createTime }</td>
			<td>
				<a onclick="addScheduleJob('${item.jobId }')" href="javascript:void(0)">添加任务</a>
				<a onclick="runScheduleJobNow('${item.jobId }')" href="javascript:void(0)">立即运行</a>
				<a onclick="updateScheduleJob('${item.jobId }')" href="javascript:void(0)">更新</a>
				<a onclick="pauseScheduleJob('${item.jobId }')" href="javascript:void(0)">停止</a>
				<a onclick="resumeScheduleJob('${item.jobId }')" href="javascript:void(0)">恢复</a>
				<a onclick="deleteScheduleJob('${item.jobId }')" href="javascript:void(0)">禁用</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>