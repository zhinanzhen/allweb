package com.spring.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 这个地方使用了Spring的注解@Component，
 * 如果不是使用annotation的方式，而是使用xml的方式管理Bean，记得写入配置文件
 * @author xxn
 * @date 2016年8月25日  下午3:30:47
 */
@Component
public class ApplicationUtil2 implements ApplicationContextAware {
	private static ApplicationContext applicationContext; // Spring应用上下文环境

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ApplicationUtil2.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T) applicationContext.getBean(name);
	}
}
