package com.spring.test;

import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"classpath*:applicationContext.xml");
		System.out.println("---"+context.getId()+"----");
		AbstractApplicationContext a;
		AbstractBeanFactory aa;
	}
}
