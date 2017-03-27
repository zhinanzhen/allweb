package com.app.common.utils.email;

import java.util.List;

public class GroupMailInfoVo {
	private  final String smtp = "smtp.rokesoft.com";
	private final String username = "p2b@rokesoft.com";
	private  final String password = "123qweQWE";
	private  final String mailFromAddress = "p2b@rokesoft.com";
	private  final String mailFromName = "融信通金融服务平台";
	private List<SendMailObj> sendMailObjList;
	private String mailSubject;//邮件主题
	private String mailContent;//邮件内容
	private String existsAttchment;//是否存在附件；false-不存在；true-存在
	private String attachmentPath;//附件本地绝对路径
	private String attachmentUri;//附件网络资源位置
	private String attachmentName;//附件名称（需带扩展名）
	
	
	/**
	 * @return the smtp
	 */
	public String getSmtp() {
		return smtp;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the mailFromAddress
	 */
	public String getMailFromAddress() {
		return mailFromAddress;
	}
	/**
	 * @return the mailFromName
	 */
	public String getMailFromName() {
		return mailFromName;
	}
	/**
	 * @return the sendMailObjList
	 */
	public List<SendMailObj> getSendMailObjList() {
		return sendMailObjList;
	}
	/**
	 * @param sendMailObjList the sendMailObjList to set
	 */
	public void setSendMailObjList(List<SendMailObj> sendMailObjList) {
		this.sendMailObjList = sendMailObjList;
	}
	/**
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return mailSubject;
	}
	/**
	 * @param mailSubject the mailSubject to set
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	/**
	 * @return the mailContent
	 */
	public String getMailContent() {
		return mailContent;
	}
	/**
	 * @param mailContent the mailContent to set
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	/**
	 * @return the existsAttchment
	 */
	public String getExistsAttchment() {
		return existsAttchment;
	}
	/**
	 * @param existsAttchment the existsAttchment to set
	 */
	public void setExistsAttchment(String existsAttchment) {
		this.existsAttchment = existsAttchment;
	}
	/**
	 * @return the attachmentPath
	 */
	public String getAttachmentPath() {
		return attachmentPath;
	}
	/**
	 * @param attachmentPath the attachmentPath to set
	 */
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	/**
	 * @return the attachmentUri
	 */
	public String getAttachmentUri() {
		return attachmentUri;
	}
	/**
	 * @param attachmentUri the attachmentUri to set
	 */
	public void setAttachmentUri(String attachmentUri) {
		this.attachmentUri = attachmentUri;
	}
	/**
	 * @return the attachmentName
	 */
	public String getAttachmentName() {
		return attachmentName;
	}
	/**
	 * @param attachmentName the attachmentName to set
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	
}
