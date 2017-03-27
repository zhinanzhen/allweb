package com.app.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.XmlWebApplicationContext;

import com.app.showpic.test.controller.ContextTest;

public class TeatListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());// 抛出异常
//		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());//返回空
//		ContextTest ct = (ContextTest) applicationContext.getBean("contextTest");
//		ApplicationContext conn = (ApplicationContext) sce.getServletContext().getAttribute(WebApplicationContext.class.getName() + ".ROOT");
		XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
		applicationContext.setConfigLocations(new String[]{"/WEB-INF/config/applicationContext.xml"});
		applicationContext.setServletContext(sce.getServletContext());
		applicationContext.refresh();
		ContextTest ct = (ContextTest) applicationContext.getBean("contextTest");
		String str = ct.sayHello("context");
		System.out.println(str);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("==============================yyyyuuuuu==================");
	}

}
