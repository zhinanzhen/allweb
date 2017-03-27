package com.spring.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationUtil1 {
	 public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	 
     public static Object getBean(String serviceName){
           return context.getBean(serviceName);
     }
}
