$(function() {
	/*控制密码的显示与隐藏*/
	$('#userPwd').password().on('show.bs.password', function(e) {
		$('#eventLog').text('Hide password');
		$('#methods').prop('checked', true);
	}).on('hide.bs.password', function(e) {
		$('#eventLog').text('Show password');
		$('#methods').prop('checked', false);
	});
	$('#methods').click(function() {
		var password = $('#userPwd').password('val');
		$('#userPwd').password('toggle');
		$('#userPwd').password('val', password);
	});
	/*用户登陆*/
	$("#loginSubmit").click(function() {
		$.ajax({
			url : path_prefix+"login/ajaxLogin.html",
			data : $("#loginFrom").serialize(),
			type : "post",
			success : function(data) {
				var value = eval("("+data+")");
				if(value.success){
					window.location.href = path_prefix + value.url;
				}else{
					alert("登陆失败!");
				}
			}
		});
	});
	$("#userPwd").keydown(function(event){
		if(event.keyCode == 13){
			$("#loginSubmit").click();
		}
	});

});