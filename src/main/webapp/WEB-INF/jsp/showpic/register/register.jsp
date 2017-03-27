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
<meta http-equiv="library" content="kernel">
<title>注册</title>
<script type="text/javascript" src="<%=basePath%>/jsp/common/core.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resources/js/jquery.form.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/jsp/showpic/register/js/register.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<form class="form-horizontal" id="registerFrom" style="margin: 0; margin-left: 25%">
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">登陆号</label>
						<div class="col-xs-4">
							<input type="text" class="form-control" id="userCode" name="userCode"
								placeholder="登陆号">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">登陆密码</label>
						<div class="col-xs-4">
							<input type="password" class="form-control" id="userPwd" name="userPwd"
								placeholder="登陆密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
						<div class="col-xs-4">
							<input type="password" class="form-control" id="userPwd2" name="userPwd2"
								placeholder="确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">电话号码</label>
						<div class="col-xs-4">
							<input type="text" class="form-control" id="phone" name="phone"
								placeholder="电话号码">
						</div>
					</div>
					<div class="form-group has-feedback">
						<label class="control-label col-sm-2" for="inputGroupSuccess2">邮箱</label>
						<div class="col-xs-4">
							<div class="input-group">
								<span class="input-group-addon">@</span> <input type="text"
									class="form-control" id="email" name="email"
									placeholder="xx@xx.com"
									aria-describedby="inputGroupSuccess2Status">
							</div>
							<span class="glyphicon glyphicon-ok form-control-feedback"
								aria-hidden="true"></span> <span id="inputGroupSuccess2Status"
								class="sr-only">(success)</span>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">性别</label>
						<div class="col-xs-4">
							<select class="form-control" id="sex" name="sex">
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" class="btn btn-default" value="注册" id = "submit">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>