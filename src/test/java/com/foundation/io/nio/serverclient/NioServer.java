package com.foundation.io.nio.serverclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NioServer {
	private static final Log log = LogFactory.getLog(NioServer.class);
	private Selector selector;// 通道管理器

	public void initServer(int port) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();// 获得一个ServerSocket通道
		ssc.configureBlocking(false);// 设置通道为非阻塞
		ssc.socket().bind(new InetSocketAddress(port));// 将该通道对应的ServerSocket绑定到port端口
		this.selector = Selector.open();// 获得一个通道管理器
		// 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后
		// 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
		ssc.register(selector, SelectionKey.OP_ACCEPT);
	}

	/**
	 * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理 
	 * @throws IOException
	 */
	public void listen() throws IOException {
		log.info("nio server start");
		while (true) {
			// 当注册的事件到达时，方法返回；否则,该方法会一直阻塞
			selector.select();
			// 获得selector中选中的项的迭代器，选中的项为注册的事件
			Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey sk = iterator.next();
				iterator.remove();// 删除已选的key,以防重复处理
				// 客户端请求连接事件
				if (sk.isAcceptable()) {
					ServerSocketChannel ssc = (ServerSocketChannel) sk.channel();
					SocketChannel channel = ssc.accept(); // 获得和客户端连接的通道
					channel.configureBlocking(false);
					channel.write(ByteBuffer.wrap("发送短信".getBytes()));
					//在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
					channel.register(selector, SelectionKey.OP_READ);
				}else if(sk.isReadable()){
					read(sk);
				}
			}
		}
	}

	public void read(SelectionKey sk) throws IOException {
		SocketChannel channel = (SocketChannel)sk.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		byte[] array = buffer.array();
		String msg = new String(array).trim();
		log.info("客户端："+msg);
		ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
		channel.write(outBuffer);
	}
	
	public static void main(String[] args) throws IOException {
		NioServer ns = new NioServer();
		ns.initServer(8888);
		ns.listen();
	}
}
