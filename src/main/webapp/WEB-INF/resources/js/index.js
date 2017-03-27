var CheckValidate = function(){
	this.name = "34";
	this.funAdd = function(){
		alert(444);
	};
};
(function($){
	$.fn.res = function(){
		var form = $(this);
		if(!form[0]) return form;
		var values = form.serializeArray();
		for(var index=0;index<values.length;index++){
			var objInput = $("input[name="+values[index].name+"]");
			if(objInput[0]&&objInput[0]!='undefined'){
				if(objInput.attr("type")!='hidden'){
					objInput.val("");
				} 
			}
		}
	};
})(jQuery);