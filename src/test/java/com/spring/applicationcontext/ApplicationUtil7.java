package com.spring.applicationcontext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 最后提供一种不依赖于servlet,不需要注入的方式。
 * 但是需要注意一点，在服务器启动时，Spring容器初始化时，不能通过以下方法获取Spring 容器，
 * 细节可以查看spring源码org.springframework.web.context.ContextLoader。
 * @author xxn
 * @date 2016年8月25日  下午3:50:34
 */
public class ApplicationUtil7 {
	WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//	wac.getBean(beanID);
}
