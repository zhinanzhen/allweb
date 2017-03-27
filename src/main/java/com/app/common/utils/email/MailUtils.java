package com.app.common.utils.email;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeUtility;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public final class  MailUtils {
	
	
	/**
	 * 功能：可发送带有附件的邮件
	 * @param mailParams
	 * smtp:SMTP服务器地址
	 * username:发送者邮箱账号
	 * password:发送者邮箱密码
	 * mailToAddress:接受者邮件地址
	 * mailToName:接受者名称
	 * mailFromAddress:发送者邮件地址
	 * mailFromName:发送者名称
	 * mailSubject:邮件主体内容
	 * mailContent:邮件正文内容
	 * 以下为附件参数（非必填）
	 * existsAttchment:有附件true，否则false
	 * attachmentPath:附件本地绝对路径
	 * attachmentUri:附件网络资源位置
	 * attachmentName:附件名称（需带扩展名）
	 *
	 * @throws UnsupportedEncodingException 抛出不支持编码异常
	 * @throws MalformedURLException 抛出URI资源找不到异常
	 * @throws EmailException 抛出邮件发送异常
	 * </PRE>
	 */
	public static void sendMail(Map<String, String> mailParams) throws Exception{
		//获得邮件所需参数
		String smtp = mailParams.get("smtp");
		String username = mailParams.get("username");
		String password = mailParams.get("password");
		String mailToAddress = mailParams.get("mailToAddress");
		String mailToName = mailParams.get("mailToName");
		String mailFromAddress = mailParams.get("mailFromAddress");
		String mailFromName = mailParams.get("mailFromName");
		String mailSubject = mailParams.get("mailSubject");
		String mailContent = mailParams.get("mailContent");
		String attachmentPath = mailParams.get("attachmentPath");
		String attachmentUri = mailParams.get("attachmentUri");
		String attachmentName = mailParams.get("attachmentName");
		
		
		//构造邮件对象
		HtmlEmail email = new HtmlEmail();
		email.setDebug(true);
		email.setHostName(smtp);
		email.setAuthentication(username, password);// 需要邮件发送服务器验证,用户名/密码
		email.addTo(mailToAddress, mailToName);
		email.setFrom(mailFromAddress, mailFromName);
		email.setCharset("UTF-8");
		email.setSubject(mailSubject);
		email.setHtmlMsg(mailContent);
//		email.setTextMsg(mailContent);
		
		//构造邮件附件
		if (mailParams.get("existsAttchment")!=null&&"true".equals(mailParams.get("existsAttchment"))) {
			EmailAttachment attachment = new EmailAttachment();
			if (attachmentPath!=null&&!"".equals(attachmentPath)) {
				attachment.setPath(attachmentPath);
			}else {
				attachment.setURL(new URL(attachmentUri));
			}
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Attachment");
			attachment.setName(MimeUtility.encodeText(attachmentName,"UTF-8","B"));
			email.attach(attachment);
		}
		
		//发送邮件
		try {
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendException(e.getMessage());
		}
		
	}
	
	/**
	 * 功能：可群发带有附件的邮件
	 * @param mailParams
	 * <PRE>
	 * smtp:SMTP服务器地址
	 * username:发送者邮箱账号
	 * password:发送者邮箱密码
	 * 
	 * mailToAddress:接受者邮件地址
	 * mailToName:接受者名称
	 * 
	 * mailFromAddress:发送者邮件地址
	 * mailFromName:发送者名称
	 * 
	 * mailSubject:邮件主体内容
	 * mailContent:邮件正文内容
	 * 以下为附件参数（非必填）
	 * existsAttchment:有附件true，否则false
	 * attachmentPath:附件本地绝对路径
	 * attachmentUri:附件网络资源位置
	 * attachmentName:附件名称（需带扩展名）
	 *
	 * @throws UnsupportedEncodingException 抛出不支持编码异常
	 * @throws MalformedURLException 抛出URI资源找不到异常
	 * @throws EmailException 抛出邮件发送异常
	 * </PRE>
	 */
	public static void groupMail(GroupMailInfoVo groupMailInfoVo) throws Exception{
		//获得邮件所需参数
		String smtp = groupMailInfoVo.getSmtp();
		String username = groupMailInfoVo.getUsername();
		String password =groupMailInfoVo.getPassword();
		List<SendMailObj> SendMailObjList = groupMailInfoVo.getSendMailObjList();
		String mailFromAddress = groupMailInfoVo.getMailFromAddress();
		String mailFromName = groupMailInfoVo.getMailFromName();
		String mailSubject = groupMailInfoVo.getMailSubject();
		String mailContent = groupMailInfoVo.getMailContent();
		String attachmentPath = groupMailInfoVo.getAttachmentPath();
		String attachmentUri = groupMailInfoVo.getAttachmentUri();
		String attachmentName = groupMailInfoVo.getAttachmentName();
		
		
		//构造邮件对象
		HtmlEmail email = new HtmlEmail();
		email.setDebug(true);
		email.setHostName(smtp);
		email.setAuthentication(username, password);// 需要邮件发送服务器验证,用户名/密码
		for (SendMailObj sendMailObj : SendMailObjList) {
			email.addTo(sendMailObj.getMailToAddress(), sendMailObj.getMailToName());
		}
		email.setFrom(mailFromAddress, mailFromName);
		email.setCharset("UTF-8");
		email.setSubject(mailSubject);
		email.setHtmlMsg(mailContent);
//		email.setTextMsg(mailContent);
		
		//构造邮件附件
		if (groupMailInfoVo.getExistsAttchment()!=null&&"true".equals(groupMailInfoVo.getExistsAttchment())) {
			EmailAttachment attachment = new EmailAttachment();
			if (attachmentPath!=null&&!"".equals(attachmentPath)) {
				attachment.setPath(attachmentPath);
			}else {
				attachment.setURL(new URL(attachmentUri));
			}
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Attachment");
			attachment.setName(MimeUtility.encodeText(attachmentName,"UTF-8","B"));
			email.attach(attachment);
		}
		
		//发送邮件
		try {
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendException(e.getMessage());
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception{
		GroupMailInfoVo groupMailInfoVo = new GroupMailInfoVo();
		SendMailObj sendMailObj = new SendMailObj();
		sendMailObj.setMailToAddress("xuxiangnan@rokesoft.com");
		sendMailObj.setMailToName("尊敬的徐向南");
//		SendMailObj sendMailObj1 = new SendMailObj();
//		sendMailObj1.setMailToAddress("geyao@rokesoft.com");
//		sendMailObj1.setMailToName("尊贵的张兆凯");
//		SendMailObj sendMailObj2 = new SendMailObj();
//		sendMailObj2.setMailToAddress("liuxingye@rokesoft.com");
//		sendMailObj2.setMailToName("尊贵的刘兴业");
		List<SendMailObj> sendMailObjList = new ArrayList<SendMailObj>();
		sendMailObjList.add(sendMailObj);
//		sendMailObjList.add(sendMailObj1);
//		sendMailObjList.add(sendMailObj2);
		groupMailInfoVo.setSendMailObjList(sendMailObjList);
		groupMailInfoVo.setMailSubject("测试邮件！请勿当真");
		groupMailInfoVo.setMailContent("你好！当你收到这封邮件的时候请您不要激动！因为这句是一封测试邮件没有任何卵用~~~~~~~~~~<br/>但是，附件还是值的一下的！里面有非常漂亮的照片");
		groupMailInfoVo.setExistsAttchment("true");
		groupMailInfoVo.setAttachmentPath("C:\\Users\\Administrator\\Desktop\\广汽租赁\\在线融资平台和三一金融技术对接文档v1.3.docx");
		groupMailInfoVo.setAttachmentName("在线融资平台和三一金融技术对接文档v1.3.docx");
//		mailParams.put("attachmentPath", "C:/Users/jun.liu/Desktop/喜迎18大.png");
//		mailParams.put("attachmentUri", "");
//		mailParams.put("attachmentName", "喜迎28大.png");
		MailUtils.groupMail(groupMailInfoVo);
	}
}
