package com.spring.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class ApplicationUtil4 {
	String[] path={
		     "WebRoot/WEB-INF/applicationContext.xml",
		     "WebRoot/WEB-INF/applicationContext_task.xml"
		   }; 
//	String path="WebRoot/WEB-INF/applicationContext*.xml"; 
	ApplicationContext context = new FileSystemXmlApplicationContext(path);
	ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:地址");
		
}
