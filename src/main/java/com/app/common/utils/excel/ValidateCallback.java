package com.app.common.utils.excel;

import java.util.Map;

public interface ValidateCallback {

	//数据校验
	public boolean validate(Map<String,String> dataRow);
	//数据转换
	public void translate(Map<String,String> dataRow);
}
