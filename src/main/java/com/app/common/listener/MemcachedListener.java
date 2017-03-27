package com.app.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.app.common.memcached.MemcachedUtils;

public class MemcachedListener implements ServletContextListener{
	private static Log log = LogFactory.getLog(MemcachedListener.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
//		Object obj = context.getBean("");
		IMemcachedCache memClient = MemcachedUtils.getMemClient();
		if(memClient != null){
			log.info("--------------memcached init success---------------------");
		}else{
			log.info("--------------memcached init faile---------------------");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("--------------listener destoryed -----------");
	}

}
