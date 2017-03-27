package com.spring.applicationcontext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationUtil3 {
	BeanFactory factory = new ClassPathXmlApplicationContext(new String[]{
	        "applicationContext-ibatis-oracle.xml",
	        "applicationContext.xml",
	        "applicationContext-data-oracle.xml"
	      }
	); 

//	UserDao userDao = (UserDao) factory.getBean("userDao");
}
