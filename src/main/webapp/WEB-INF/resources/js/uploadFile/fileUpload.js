(function($){
	if(!$.isFunction($.fn.uploadify)){
		alert("请先引用jquery.uploadify.js!");
		return;
	}
	var uploadConfig = function(o){
	    var basePath = o.basePath;
	    var jsessionid = o.jsessionid;
		var settings = {
			auto:true,
			//buttonClass:'upload_button_style',
			swf:basePath+'/resources/js/uploadFile/uploadify.swf',
			uploader:basePath+'/fileUpload/uploadFileToJson.html',
			queueSizeLimit:'1',
			fileObjName:'file',
			preventCaching:false,
			progressData:'percentage',
			removeCompleted:false,
			formData:{},
			fileTypeDesc:"*.zip;*.rar;*.7z;",
			fileTypeExts:"*.zip;*.rar;*.7z;",
			multi:false,
			uploadLimit:'10',
			fileSizeLimit:'',
			width:'115',
			height:'25',
			buttonText:'文件上传',
			onUploadSuccess:function(file,data,response){
				 var msg=eval("("+data+")");
				if($.isFunction(o.onSuccess)){
					o.onSuccess(msg);
				}
			},
			onUploadError:function(file,errorCode,errorMsg,errorString){
				if($.isFunction(o.onFailure)){
					o.onFailure(errorMsg);
				}else{
					alert(errorMsg);
				}
			},
			onDialogClose:function(queueData){}
		};
		$.extend(settings,o);
		settings.formData.module=o.module;
		settings.formData.prefix=o.prefix;
		return settings;
		
	};
	var verifyParam = function(o){
		if(o.basePath=='undefined'){
			alert("缺少重要参数【basePath】!");
			return false;
		}
		if(o.prefix=='undefined'){//前缀
			alert("缺少重要参数【prefix】!");
			return false;
		}
		if(o.module=='undefined'){
			alert("缺少重要参数【module】，该参数标示代表功能属于哪个模块!");
			return false;
		}
		if(!$.isFunction(o.onSuccess)&&!$.isFunction(o.onUploadSuccess)){
			alert("缺少文件上传成功后的回调函数onSuccess:function(path){}");
			return false;
		}
		return true;
	};
	
	/**单个文件上传**/
	$.fn.fileupload = function(o){
		if(!verifyParam(o)) return;
		o.multi = false;
		$(this).uploadify(uploadConfig(o));
	};
	/**多文件上传**/
	$.fn.multifileupload = function(o){
		if(!verifyParam(o)) return;
		o.multi = true;
		$(this).uploadify(uploadConfig(o));
	};
})(jQuery);