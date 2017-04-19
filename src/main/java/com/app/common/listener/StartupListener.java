package com.app.common.listener;

import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;

public class StartupListener implements ServletContextListener {
	private ICacheManager<IMemcachedCache> manager;
	public static final String MANAGER = "manager";

	private static Map<String, String> unmodifybelImageServerMap = null;
	private static int treeDeepth = 3;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		if (manager != null) {
			manager.stop();
		}
	}

	@Override
	public void contextInitialized(final ServletContextEvent event) {
		class StartupConfig {
			private static final String START_UP_CONFIG_FILE_NAME = "startupConfig.xml";
			private Document document = null;
			private Element rootElement = null;

			private Map<String, String> imageServerMap = new LinkedHashMap<String, String>();

			/**
			 * 读取memcached配置
			 */
			private void initMemcached() {
				manager = CacheUtil.getCacheManager(IMemcachedCache.class,
						MemcachedCacheManager.class.getName());
				manager.setConfigFile("memcached.xml");
				manager.start();

				ServletContext servletContext = event.getServletContext();
				servletContext.setAttribute("manager", manager);
				IMemcachedCache cache = manager.getCache("mclient");

				servletContext.setAttribute("mclient", cache);
			}

			private void readConfigration() {
				InputStream startupConfigStream = this.getClass()
						.getClassLoader()
						.getResourceAsStream(START_UP_CONFIG_FILE_NAME);
				SAXReader saxReader = new SAXReader();
				try {
					document = saxReader.read(startupConfigStream);
					rootElement = document.getRootElement();
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}

			private void parseParams() {
				parseImageServers();
				parseCategoryTree();

			}

			@SuppressWarnings("unchecked")
			private void parseImageServers() {
				Element imageServers = (Element) rootElement
						.selectSingleNode("/params/imageServers");
				List<Element> imageServerList = (List<Element>) imageServers
						.elements();
				for (Element imageServer : imageServerList) {
					String key = imageServer.attributeValue("name");
					String value = imageServer.attributeValue("path");
					imageServerMap.put(key, value);
				}
				unmodifybelImageServerMap = Collections
						.unmodifiableMap(imageServerMap);
			}

			private void parseCategoryTree() {
				Element categoryTree = (Element) rootElement
						.selectSingleNode("/paramscategoryTree");
				if (categoryTree != null) {
					String deepth = categoryTree.attributeValue("deepth");
					treeDeepth = Integer.parseInt(deepth);
				}
			}

		}
		StartupConfig config = new StartupConfig();
		config.initMemcached();

//		config.readConfigration();

//		config.parseParams();
	}
	
	public static Map<String,String> getImageServerMap(){
		return unmodifybelImageServerMap;
	}
	
	public static int getCategoryTreeDeepth(){
		return treeDeepth;
	}
}
