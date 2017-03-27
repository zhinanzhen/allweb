package com.spring.resource;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * 
 * Spring 提供的 FileSystemResource 类用于访问文件系统资源，
 * 使用 FileSystemResource 来访问文件系统资源并没有太大的优势，因为 Java 提供的 File 类也可用于访问文件系统资源。
 * @author xxn
 * @date 2015年12月21日  下午12:15:05
 */
public class FileSystemResourceTest {
	private static final Log log = LogFactory.getLog(UrlResourceTest.class);

	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) throws IOException, DocumentException {
		//String path = UrlResourceTest.class.getResource("/").getPath();
		Resource urlRes = null;
		//资源字符串确定的资源，位于本地文件系统内 ，而且无须使用任何前缀。
		urlRes = new FileSystemResource("d:\\bean.xml");//以文件系统的绝对路径方式进行访问
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
