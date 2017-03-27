package com.foundation.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class GetApplicationContext {
	static{
		//指定文件系统路径下查找
		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\Temp\\build.xml");
		//所有类路径（包含JAR文件）下查找
		ApplicationContext context2 = new ClassPathXmlApplicationContext("build.xml");
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
	}
}
