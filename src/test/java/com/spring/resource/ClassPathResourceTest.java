package com.spring.resource;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * ClassPathResource 用来访问类加载路径下的资源，相对于其他的 Resource 实现类，
 * 其主要优势是方便访问类加载路径里的资源，尤其对于 Web 应用，
 * ClassPathResource 可自动搜索位于 WEB-INF/classes 下的资源文件，无须使用绝对路径访问。
 * @author xxn
 * @date 2015年12月21日  上午11:47:34
 */
public class ClassPathResourceTest {
	private static final Log log = LogFactory.getLog(UrlResourceTest.class);
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) throws IOException, DocumentException {
//		String path = UrlResourceTest.class.getResource("/").getPath();
		Resource urlRes = null; 
		urlRes = new ClassPathResource("bean.xml");//src路径下
		log.debug(urlRes.getFilename());
		log.debug(urlRes.getDescription());
		log.debug(urlRes.getURL());
		SAXReader sr = new SAXReader();
		Document read = sr.read(urlRes.getFile());
		Element rootElement = read.getRootElement();
		List<Element> elements = rootElement.elements();
		for (Element el : elements) {
			List<Element> elements2 = el.elements();
			log.debug(el.getName());
		}
//		log.debug(urlRes.getInputStream());
	}
}
