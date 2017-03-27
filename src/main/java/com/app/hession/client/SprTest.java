package com.app.hession.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.hession.IHello;

/**
 * spring 测试，测试配置文件在下面
 * @author xxn
 * @date 2016年8月22日  下午6:48:00
 */
public class SprTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-hessian-client.xml");  //这里只是你声明的bean的xml文件所在的路径
		IHello b = (IHello) context.getBean("myServiceClient");
        String hello = b.sayHello();
        System.out.println(hello);
	}
}
