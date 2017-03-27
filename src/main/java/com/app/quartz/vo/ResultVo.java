package com.app.quartz.vo;

public class ResultVo {
	private boolean result;
	private String failReason;
	
	public ResultVo() {
	}
	public ResultVo(boolean result) {
		super();
		this.result = result;
	}
	public ResultVo(boolean result, String failReason) {
		super();
		this.result = result;
		this.failReason = failReason;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getFailReason() {
		return failReason;
	}
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	
	
}
