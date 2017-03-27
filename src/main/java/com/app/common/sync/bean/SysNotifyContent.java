package com.app.common.sync.bean;

/**
 * 通知内容
 * @author xxn
 * @date 2015年12月4日  下午3:50:01
 */
@SuppressWarnings("serial")
public class SysNotifyContent implements java.io.Serializable {

	private String id;
	private String notifyId;// 通知主键
	private String src;// 签名原数据
	private String sign;// 签名密文数据

	public SysNotifyContent() {
	}

	public SysNotifyContent(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

}