package com.app.common.utils.email;
/**
 * 群发邮件接收者对象
 * @author gy
 *
 */
public class SendMailObj {
	private String mailToAddress;//接收者邮件地址
	private String mailToName;//接收者名称
	/**
	 * @return the mailToAddress
	 */
	public String getMailToAddress() {
		return mailToAddress;
	}
	/**
	 * @param mailToAddress the mailToAddress to set
	 */
	public void setMailToAddress(String mailToAddress) {
		this.mailToAddress = mailToAddress;
	}
	/**
	 * @return the mailToName
	 */
	public String getMailToName() {
		return mailToName;
	}
	/**
	 * @param mailToName the mailToName to set
	 */
	public void setMailToName(String mailToName) {
		this.mailToName = mailToName;
	}
	
}
