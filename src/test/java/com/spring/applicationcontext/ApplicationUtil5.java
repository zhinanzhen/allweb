package com.spring.applicationcontext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * 利用FileSystemResource，则配置文件必须放在project直接目录下，或者写明绝对路径，否则就会抛出找不到文件的异常
 * @author xxn
 * @date 2016年8月25日  下午3:46:02
 */
public class ApplicationUtil5 {
	Resource rs = new FileSystemResource("D:/tomcat/webapps/test/WEB-INF/classes/ applicationContext.xml"); 
	BeanFactory factory = new XmlBeanFactory(rs); 	
}
