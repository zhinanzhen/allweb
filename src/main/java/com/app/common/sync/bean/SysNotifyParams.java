package com.app.common.sync.bean;

/**
 * 通知参数
 * @author xxn
 * @date 2015年12月4日  下午3:50:25
 */
public class SysNotifyParams implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String tradeId;// 行业商户代码
	private String createTime;// 生成时间
	private String type;// 类型：
	private String flag;// 异步通知结果0-不成功；1-成功
	private String exception;// 异步通知异常
	private String notifyUrl;// 通知地址
	private String isRepeat;// 是否需要重复通知，0-不需要；1-需要
	private String maxSendNum = "10";// 最大发送次数
	private String hasSendNum = "1";// 实际发送的次数
	private String lastSendTime; // 上次发送时间

	private String typeName; // 类型名字

	public SysNotifyParams() {
	}

	public SysNotifyParams(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeId() {
		return this.tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getException() {
		return this.exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getIsRepeat() {
		return isRepeat;
	}

	public void setIsRepeat(String isRepeat) {
		this.isRepeat = isRepeat;
	}

	public String getMaxSendNum() {
		return maxSendNum;
	}

	public void setMaxSendNum(String maxSendNum) {
		this.maxSendNum = maxSendNum;
	}

	public String getHasSendNum() {
		return hasSendNum;
	}

	public void setHasSendNum(String hasSendNum) {
		this.hasSendNum = hasSendNum;
	}

	public String getLastSendTime() {
		return lastSendTime;
	}

	public void setLastSendTime(String lastSendTime) {
		this.lastSendTime = lastSendTime;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}