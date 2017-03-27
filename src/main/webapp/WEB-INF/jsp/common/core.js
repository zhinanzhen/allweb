var path_prefix = getWebPath();//'/DataMarket/';

coreZX = {
	version : '2.0'
};

coreZX._import = function(type, path, className, lang) {
	if (type == "js") {
		document.write("<script type='text/javascript' src='" + path_prefix + path + "' " + (lang ? "charset='" + lang + "'" : "") + "></script>");
	} else if (type == "css") {
		document.write("<link type='text/css' rel='stylesheet' href='" + path_prefix + path + "'/>");
	} else if (type == "behavior") {
		document.write('<style>' + className + '{behavior:url(' + path_prefix + path + '); }</style>');
	} else if (type == "namespace") {
		document.write('<?import namespace="' + className + '" implementation="' + path_prefix + path + '" />');
	} else if (type == "text") {
		document.write('<script language="JavaScript">' + path + '</script>');
	}
};

coreZX.importLib = function(lib) {

	switch (lib) {
	       case "kernel" : {
	    	   this._import("js", "resources/js/jquery-2.0.3.js");
			   break; 
	       }
	       case "internet" : {
//	    	   this._import("css", "public/v20/ui/css/reset.css");
//	    	   this._import("css", "public/v20/ui/css/style.css");
//	    	   this._import("css", "public/v20/ui/css/pager.css");
//	    	   this._import("css", "public/v20/ui/css/common.css");
//               
//	    	   this._import("js", "public/v20/ui/js/common.js");
//	    	   this._import("js", "public/v20/ui/js/pager.js");
//	    	   this._import("js", "public/v20/ui/js/TableGrid.js");
//	    	   this._import("js", "public/v20/ui/js/DynGrid.js");
//	    	   this._import("js", "public/v20/ui/js/tab.js");
//	    	   this._import("js", "public/v20/ui/js/messager.js");
			   
			   break;
	       }
	       case "market": {
//	    	   this._import("css", "market/main/css/reset.css");
//	    	   this._import("css", "market/main/css/style.css");
//	    	   this._import("js", "public/easyui/jquery.easyui.min.js");
//	    	   this._import("js", "public/v20/ui/js/common.js");
//	    	   this._import("js", "public/v20/ui/js/msg.js");
//	    	   this._import("css", "market/main/css/common.css");
//	    	   this._import("js", "public/core/pager.js");
		       break;
	       }
	       case "easyui" : {
//	    	   this._import("js", "public/easyui/jquery.easyui.min.js");
//	    	   this._import("js", "public/easyui/dwrloader.js");
//	    	   this._import("js", "public/easyui/dwrEasyext.js");
//	    	   this._import("css", "public/easyui/themes/default/easyui.css");
//	    	   this._import("js", "public/easyui/locale/easyui-lang-zh_CN.js");
//	    	   this._import("css", "public/easyui/themes/icon.css");
		       break;
	       }
	       case "WdatePicker" : {
//	    	   this._import("js", "public/widgets/date/My97DatePicker/WdatePicker.js");
		       break;
	       }
	       case "zTree" : {
//	    	   this._import("css", "public/widgets/zTree/css/zTreeStyle/zTreeStyle.css");
//	    	   this._import("js", "public/widgets/zTree/js/jquery.ztree.core-3.5.js");
//	    	   this._import("js", "public/widgets/zTree/js/jquery.ztree.excheck-3.5.js");
		       break;
	       }
	}
};

(function() {
	coreZX.importLib('kernel');
	var metas = document.getElementsByTagName("META");
	for ( var i = 0; i < metas.length; i++) {
		if (metas[i].httpEquiv == "library") {
			var libraries = metas[i].content.split(",");
			for ( var i = 0; i < libraries.length; i++) {
				if (libraries[i] != "kernel") {
					EasyuiZX.importLib(libraries[i]);
				}
			}
			break;
		}
	}
})();
function getWebPath() {
	// 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName+"/");
}
