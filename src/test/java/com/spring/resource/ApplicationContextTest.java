package com.spring.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.spring.ioc.TestBean;

public class ApplicationContextTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String path = ApplicationContextTest.class.getResource("/").getPath();
		System.out.println(path);
		/*ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"classpath*:bean.xml");*/
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"bean*.xml");*/
		AbstractApplicationContext ab ;
		ApplicationContext ctx = new FileSystemXmlApplicationContext("file:/bean.xml"); 
		System.out.println("wwwwwwww--------" + ctx);
		TestBean obj = (TestBean) ctx.getBean("test");
		try {	
			obj.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Resource resource = ctx.getResource("book.xml");
		System.out.println(resource.getDescription());
	}

}
