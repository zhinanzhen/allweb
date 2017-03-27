package com.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	//合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088902387390775";
	public static String partner2 = "2088902387390775";
	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ1x7nSeijAZNX6yQeS/FfV/KCqAud+SQcRTs3K+K9fgoha+466M/LI0eGTQFmpIi0G4KK6K2wOhsjJETtog1g8BMeGKGfP/LwFbU2YvaRoCzV9755eZs7th6UB3aUTFfYOG5+jHrqnwTmuE9HzMVBZfYgtIGNCc//JEOcELkC9BAgMBAAECgYEAgn4hc0rLod3i9qVr89lkq9q+Qav7Yo/oLn5pJtrzn7Mw5MVGFDAKaPEQMA4/5ctGkCvAnBm+OJ5WAU+YQzYf83bK5kZuyJCaYHS99LIJVbS2OLMB3TfghTLkvRRjEJ6MJhU1Lvnu5UrkOrPtfi7sAQKgMDnIgXjTBnALtz8o0KECQQDOy8XGdBCyPWYmOCNAbrnxFU0PPQhd/Qw+rFpoIiC1L7M+bgxnKJ+wAseor6qzwSMMCyPKDeVhpD/Sma9yOSoFAkEAwuggEzeSLvvM2UlA4PFPBt69dl9SANvry+p8zdBXMSZc6YgaRatq7MiaJDnNG5IS/my2Qri37fC5o+cWXUlpDQJATGod/fQ7izGHAo5x8Eg6K2y8menqoph0IuCbU6lwvqMOr/4IVUI8p9SPJLUs9dljcvrW0b4KyebgspiZrTKUZQJAJp4JZOVY0HhRgSfTc/470zekwGRoggUQ9ikyqzDBZdqdBCRUWEN7fwjMCatuKS1LGCAACL5CqyFMFt59fuRBrQJAG86UhLtK7AgphfSP6fYrRPLEOtA5FDCBz4VXsrunkuJNinQogZWmn9vw7nYrVKk1LAFGJ9E7Q+E7spDMIDhPXQ==";
	public static String private_key2 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMfRG+ePYO5phPbWaSOgWI68gQFcvjl2/1wrbbB0ip+MHuP6/Tdy9/eJ3IErCgWsfPWJOgFhA5eSmD++Dkg+AkKD9b2lO4wk/h7SKrN1pRvJxkJcK5IqCDeYermRRbiK3As4Jf6weDH0LDCDurT7gWYhfG9S2cDeBhjnFERhMdjFAgMBAAECgYAHsgn9FQyKog244/EQqjA+7wuY3dWFqQuUpSeIUDS2iFL4PMZbyFW8dtbDMsEkDsyROEO/odjdkYvDiLJMHfdAPxJ7DGt4PeDyDD/U+7o17LKMANtCoqiHLMotJTBzZuUE7Pe6wndlw4QFJjigvyrkiTYnvY5fFFPFPciDkSmv0QJBAPUrRmq6CRo/GF3lAoMWV06yGiSU4sUSxHUY13WGBrt0pDvjAYanSgHzkyFFxrRWc1M0bYRqArplbInOAmdzuHcCQQDQpOz+nKCFjfE8f/zb64GmcP4VlYUBpVcCyfQGFaTk3RM1ZlAcNX9ia6qLqI9dHMdifxYe9SfBKGzqsAKD9gOjAkEA74FaJjMdZ1WSIU/yt0rg+dEFtwz3x9xArcAZ5AaNlx0owBRQzlGo++UOq6d1qYD24qbKAlxp09v3P1xQfu3OmwJAfspawvdHjSGO4acdcD+TkCPGJDOymidx0t4LDs+EXxgBnkfIkvvnp1WqVChgxsLAX5i/RpzQRc9dMNk5DhwoZQJAexLxv2c/I5tcLMeFCHzEQB4YPDzJrr90CldSEGSZ7RCkkJjnRV8cxpsAXz4hn4ukyiZWCLClA2wUwfp+iMZcug==";
	
	//支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdce50noowGTV+skHkvxX1fygqgLnfkkHEU7NyvivX4KIWvuOujPyyNHhk0BZqSItBuCiuitsDobIyRE7aINYPATHhihnz/y8BW1NmL2kaAs1fe+eXmbO7YelAd2lExX2Dhufox66p8E5rhPR8zFQWX2ILSBjQnP/yRDnBC5AvQQIDAQAB";
	public static String alipay_public_key2  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDH0Rvnj2DuaYT21mkjoFiOvIEBXL45dv9cK22wdIqfjB7j+v03cvf3idyBKwoFrHz1iToBYQOXkpg/vg5IPgJCg/W9pTuMJP4e0iqzdaUbycZCXCuSKgg3mHq5kUW4itwLOCX+sHgx9Cwwg7q0+4FmIXxvUtnA3gYY5xREYTHYxQIDAQAB";
	
	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path ="C://";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "UTF-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}

