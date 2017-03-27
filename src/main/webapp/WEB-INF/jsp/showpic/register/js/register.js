$(function() {
	$("#submit").click(function() {
		$.ajax({
			url : path_prefix + "register/registerUser.html",
			data : $("#registerFrom").serialize(),
			type : "post",
			success : function(data) { // var value = eval("("+data+")");
				window.location.href = path_prefix + data;
			}
		});

	});
});