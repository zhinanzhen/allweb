package com.mq.client2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * MessageListener是最原始的消息监听器，它是JMS规范中定义的一个接口。
 * 其中定义了一个用于处理接收到的消息的onMessage方法，该方法只接收一个Message参数
 * @author xxn
 * @date 2016年7月6日  下午3:02:44
 */
public class ConsumerMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// 这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换，或者直接把onMessage方法的参数改成Message的子类TextMessage
		TextMessage textMsg = (TextMessage) message;
		System.out.println("接收到一个纯文本消息。");
		try {
			System.out.println("消息内容是：" + textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
