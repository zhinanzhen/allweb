package com.app.common.memcached;

import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

public class MemcachedUtils {
	private static ServletContext servletContext;
	private static String defaultClient = "mclient";
	private MemcachedUtils() {

	}
	static{
		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
		servletContext = context.getServletContext();
	}
	public static IMemcachedCache getMemClient() {
		return getMemClient(defaultClient);
	}
	public static IMemcachedCache getMemClient(String clientName) {
		if (clientName == null || clientName.trim().length() == 0) {
			return null;
		}
		IMemcachedCache client = null;
		try {
			client = (IMemcachedCache) servletContext.getAttribute(clientName);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return client;
	}
}
