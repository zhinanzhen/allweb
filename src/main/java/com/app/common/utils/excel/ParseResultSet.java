package com.app.common.utils.excel;

import java.util.List;
import java.util.Map;

public class ParseResultSet {
	
	private List<Map<String,String>> successList;//解析成功结果集
	
	private List<Map<String,String>> failureList;//解析失败结果集
	
	private String parseStatus;//0-失败;1-成功;2-部分成功
	
	private String failureMsg;
	
	public ParseResultSet() {}

	public ParseResultSet(String parseStatus, String failureMsg) {
		this.parseStatus = parseStatus;
		this.failureMsg = failureMsg;
	}
	
	public ParseResultSet(List<Map<String, String>> successList,
			List<Map<String, String>> failureList, String parseStatus,String failureMsg) {
		super();
		this.successList = successList;
		this.failureList = failureList;
		this.parseStatus = parseStatus;
		this.failureMsg = failureMsg;
	}
	
	public ParseResultSet(List<Map<String, String>> successList,
			List<Map<String, String>> failureList, String parseStatus) {
		super();
		this.successList = successList;
		this.failureList = failureList;
		this.parseStatus = parseStatus;
	}

	public List<Map<String, String>> getSuccessList() {
		return successList;
	}

	public void setSuccessList(List<Map<String, String>> successList) {
		this.successList = successList;
	}

	public List<Map<String, String>> getFailureList() {
		return failureList;
	}

	public void setFailureList(List<Map<String, String>> failureList) {
		this.failureList = failureList;
	}

	public String getParseStatus() {
		return parseStatus;
	}

	public void setParseStatus(String parseStatus) {
		this.parseStatus = parseStatus;
	}

	public String getFailureMsg() {
		return failureMsg;
	}

	public void setFailureMsg(String failureMsg) {
		this.failureMsg = failureMsg;
	}

}
