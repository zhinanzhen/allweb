package com.app.showpic.test.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextTest implements ApplicationContextAware{
	private static ApplicationContext context = null;
	
	public String sayHello(String name){
		AT at = (AT) context.getBean("at");
		System.out.println(at.sayworld(name));
		return "hello" + name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
}
