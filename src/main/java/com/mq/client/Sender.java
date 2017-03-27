package com.mq.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * JMS有四个组成部分：JMS服务提供者、消息管理对象、消息的生产者消费者和消息本身。
 * 
 * JMS AP中有两个消息管理对象：创建jms连接使用的工厂（ConnectionFactory）和目的地（Destination），
 * 根据消息的消费方式的不同ConnectionFactory可以分为QueueConnectionFactory和TopicConnectionFactory，
 * 目的地（Destination）可以分为队列（Queue）和主题（Topic）两种。
 * 
 * 消息的生产者可以分为――点对点消息发布者（P2P）和主题消息发布者（TopicPublisher）。
 * 所以，消息的消费者分为两类：主题消息的订阅者（TopicSubscriber)和点对点消息的接收者（queue receiver）。
 * 
 * @author xxn
 * @date 2016年7月4日  上午11:58:10
 */
public class Sender {
	private static final int SEND_NUMBER = 5;

	public static void main(String[] args) {
		// ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory;
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session;
		// Destination ：消息的目的地;消息发送给谁.
		Destination destination;
		// MessageProducer：消息发送者
		MessageProducer producer;
		// TextMessage message;
		// 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar

		connectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, 
				"tcp://localhost:61616"
				);
		try {
			// 构造从工厂得到连接对象
			connection = connectionFactory.createConnection();
			// 启动
			connection.start();
			// 获取操作连接
			session = connection.createSession(Boolean.TRUE,
					Session.AUTO_ACKNOWLEDGE);
			// 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
			destination = session.createQueue("test-persistence");
			// 得到消息生成者【发送者】
			producer = session.createProducer(destination);
			// 设置不持久化，可以更改
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			// 构造消息
			sendMessage(session, producer);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != connection)
					connection.close();
			} catch (Throwable ignore) {
			}
		}

	}

	public static void sendMessage(Session session, MessageProducer producer)throws Exception {
		for (int i = 1; i <= SEND_NUMBER; i++) {
			TextMessage message = session.createTextMessage("ActiveMq 发送的消息" + i);
//			MapMessage mapMessage = session.createMapMessage();
//			mapMessage.setString("", "");
			// 发送消息到目的地方
			System.out.println("发送消息:" + i);
			producer.send(message);
		}
	}
}
