package com.spring.applicationcontext;



/**
 * 这种方式适合于采用Spring框架的B/S系统，通过ServletContext对象获取ApplicationContext对象，
 * 然后在通过它获取需要的类实例。上面两个工具方式的区别是，前者在获取失败时抛出异常，后者返回null。 
 * @author xxn
 * @date 2016年8月25日  下午3:49:27
 */
public class ApplicationUtil6 {
//	ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletContext sc);
//	ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(ServletContext sc);
//	ac1.getBean("beanId");
//	ac2.getBean("beanId");
	
}
