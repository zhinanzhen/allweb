package com.app.common.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * 获得path.properties中的路径
 * @author xxn
 * @date 2016年12月27日  上午11:27:36
 */
public class GetPathByNameUtil {
	private static Properties properties;
	
	private GetPathByNameUtil() {
	}
	/**
	 * 工程WebRoot真实路径
	 */
	public static String contextPath = "";
	static{
		contextPath = GetPathByNameUtil.class.getResource("/").getPath();
		contextPath = contextPath.substring(0, contextPath.indexOf("WEB-INF"));
	}
	/**
	 * 获得Properties
	 * 
	 * @return Properties
	 */
	private static Properties getProperties() {
		if (properties == null) {
			return new Properties();
		}
		return properties;
	}

	/**
	 * 根据名字，得到相应的路径(部分路径)
	 * 
	 * @param name
	 * @return path
	 */
	public static String getPathByName(String name) {
		properties = getProperties();
		
		try {
			if(properties.isEmpty()){
				properties.load(GetPathByNameUtil.class.getClassLoader()
						.getResourceAsStream("path.properties"));
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}

		return properties.getProperty(name);
	}

	/**
	 * 得到全部的路径
	 * 
	 * @param name
	 * @return realPath
	 */
	public static String getRealPathByName(String name) {
		String pathByName = getPathByName(name);
		String realPath = "";
		
		if (!"".equals(pathByName)) {
			realPath = contextPath+pathByName;
		}
		return realPath;
	}
}
