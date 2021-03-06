package com.mq;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class Receiver {
	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"classpath:applicationContext-mq.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
		while (true) {
			Map<String, Object> map = (Map<String, Object>) jmsTemplate
					.receiveAndConvert();

			System.out.println("收到消息：" + map.get("message"));
		}
	}
}
