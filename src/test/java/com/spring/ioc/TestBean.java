package com.spring.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;

public class TestBean {
	private Resource res;
	// 依赖注入 Resource 资源的 setter 方法
	public void setResource(Resource res) {
		this.res = res;
	}

	@SuppressWarnings("unused")
	public void parse() throws Exception {
		// 获取该资源的简单信息
		System.out.println(res.getFilename());
		System.out.println(res.getDescription());
		// 创建 Dom4j 的解析器
		SAXReader reader = new SAXReader();
		Document doc = reader.read(res.getFile());
		// 获取根元素
		Element el = doc.getRootElement();
	}
}
