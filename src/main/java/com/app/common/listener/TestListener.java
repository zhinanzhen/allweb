package com.app.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

import com.app.showpic.test.controller.AT;

public class TestListener implements ServletContextListener,ApplicationContextAware {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext conn = (ApplicationContext) sce.getServletContext().getAttribute(WebApplicationContext.class.getName() + ".ROOT");
		AT at = (AT) conn.getBean("at");
		String sayworld = at.sayworld("xx");
		System.out.println(sayworld);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}

}
