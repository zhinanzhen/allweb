package com.spring.resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

/**
 * 访问网络资源通过 UrlResource 类实现，UrlResource 是 java.net.URL 类的包装，
 * 主要用于访问之前通过 URL 类访问的资源对象。URL 资源通常应该提供标准的协议前缀。
 * 例如：file: 用于访问文件系统；http: 用于通过 HTTP 协议访问资源；ftp: 用于通过 FTP 协议访问资源等。
 * @author xxn
 * @date 2015年12月21日  上午11:47:05
 */
public class UrlResourceTest {
	private static final Log log = LogFactory.getLog(UrlResourceTest.class);
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) throws IOException, DocumentException {
//		String path = UrlResourceTest.class.getResource("/").getPath();
		Resource urlRes = null; 
		try {
			urlRes = new UrlResource("file:///D:\\bean.xml");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
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
