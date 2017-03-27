package com.app.socket.server;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.socket.servicehandle.ServicesHandler;

/**
 * @author heyong
 *
 */
public class SocketServer{
	private static Logger logger = Logger.getLogger(SocketServer.class);
	
	private static final String systemCharSet = "UTF-8";
	
	private static final int BUFFER_SIZE = 100*1024*1024;
	
	public final static ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[]{ "classpath*:/config/spring/context.xml"
					     ,"classpath*:/config/spring/hessian-client.xml"});
	
	public SocketServer(){
		try {
			// 创建一个非阻塞的server端的Socket
			IoAcceptor acceptor = new NioSocketAcceptor();
			//SSL过滤器
//			SslFilter sslFilter = new SslFilter(new SSLContextGenerator().getSslContext());
//			sslFilter.setNeedClientAuth(true);
//			acceptor.getFilterChain().addLast("SSL", sslFilter);
			// 设置过滤器（添加自带的编解码器）
//			acceptor.getFilterChain().addLast(
//					"codec",
//					new ProtocolCodecFilter(new MessageCodecFactory(
//							new RxtMessageDecoder(Charset.forName(systemCharSet)),
//							new RxtMessageEncoder(Charset.forName(systemCharSet)))));
			acceptor.getFilterChain().addLast("logger", new LoggingFilter());
			// 设置日志过滤器
//			LoggingFilter lf = new LoggingFilter();
//			lf.setMessageReceivedLogLevel(LogLevel.DEBUG);
//			acceptor.getFilterChain().addLast("logger", lf);
			// 获得IoSessionConfig对象
			IoSessionConfig cfg = acceptor.getSessionConfig();
			cfg.setReadBufferSize(BUFFER_SIZE);
			// 读写通道100秒内无操作进入空闲状态
			cfg.setIdleTime(IdleStatus.BOTH_IDLE, 100);
			// 绑定逻辑处理器
			acceptor.setHandler((ServicesHandler)context.getBean("servicesHandler"));
			// 绑定多端口
			InetSocketAddress[] inetSocketAddresses = new InetSocketAddress[]{new InetSocketAddress(18999)};
			acceptor.bind(inetSocketAddresses);
			//可以继续绑定端口
			//acceptor.bind(new InetSocketAddress(8888));
			for(InetSocketAddress inetSocketAddres : inetSocketAddresses){
				logger.info("融信通CPM_SOCKET服务器在端口号" + inetSocketAddres.getPort() + "上启动成功！");
			}
		} catch (Exception e) {
			logger.error("融信通CPM_SOCKET服务器启动失败！", e);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SocketServer();
	}
}