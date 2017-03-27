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
<title>登陆</title>
<script type="text/javascript" src="<%=basePath%>/jsp/common/core.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/js/bootstrap-show-password.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/jsp/showpic/login/js/login.js"></script>
<link rel="stylesheet" type="text/css" 	href="<%=basePath%>/resources/js/bootstrap-3.3.5-dist/css/bootstrap.css">
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) { //如果没有设置过Cookie会返回null  
	    for (Cookie cookie : cookies) {
	   	    System.out.println("------------>"+"getName="+cookie.getName()+"getValue="+cookie.getValue());
	    	if("user".equals(cookie.getName())){
	    		request.getRequestDispatcher("/home/homePage.html").forward(request, response);
	    		return;
	    	}
	    }  
	}  
%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<form class="form-horizontal" style="margin: 0; margin-left: 25%"
					id="loginFrom">
					<div class="form-group">
						<label for="userCode" class="col-sm-2 control-label">登陆号</label>
						<div class="col-xs-4">
							<input type="text" class="form-control" id="userCode"
								name="userCode" placeholder="登陆号">
						</div>
					</div>
					<div class="form-group">
						<label for="userPwd" class="col-sm-2 control-label">密码</label>
						<div class="col-xs-4">
							<input type="password" class="form-control" id="userPwd"
								 name="userPwd" placeholder="密码" >
						</div>
					</div>
					<div class=form-group>
						<div class="col-sm-offset-2 col-sm-10">
							<input id = "methods" type="checkbox">
							<label id="eventLog">Show password</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" id="loginSubmit" class="btn btn-default" value="登陆">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>