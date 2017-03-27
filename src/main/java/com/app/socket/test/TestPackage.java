package com.app.socket.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.app.socket.servicehandle.ServicesHandler;


public class TestPackage {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		byte[] requestStr = "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".getBytes();
		socketCall(requestStr);
	}

	
	/**
	 * socket客户端调用
	 * @param requestStr
	 * @throws Exception
	 */
	public static void socketCall(byte[] requestStr) throws Exception{
		//创建socket客户端
		Socket socket = new Socket("127.0.0.1", 18999); 
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		//发送请求报文
		os.write(requestStr);
		//获取响应报文
		BufferedReader r = new BufferedReader( new InputStreamReader(is,"UTF-8") );
		String line = null;
	    while ((line = r.readLine()) != null) {
	    	System.out.println("[Recieved]:"+line);
	    }
	}
	
	
	 public static void main2(String[] args){
	        // 创建客户端连接器.
	        NioSocketConnector connector = new NioSocketConnector();
	        connector.getFilterChain().addLast("logger", new LoggingFilter());
	        connector.getFilterChain().addLast("codec", 
	                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
	        
	        // 设置连接超时检查时间
	        connector.setConnectTimeoutCheckInterval(30);
	        connector.setHandler(new ServicesHandler());
	        
	        // 建立连接
	        ConnectFuture cf = connector.connect(new InetSocketAddress("192.168.2.109", 6488));
	        // 等待连接创建完成
	        cf.awaitUninterruptibly();
	        
	        cf.getSession().write("Hi Server!");
	        cf.getSession().write("quit");
	        
	        // 等待连接断开
	        cf.getSession().getCloseFuture().awaitUninterruptibly();
	        // 释放连接
	        connector.dispose();
	    }
}
