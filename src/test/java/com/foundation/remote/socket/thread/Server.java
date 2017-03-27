package com.foundation.remote.socket.thread;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.directwebremoting.util.Logger;

public class Server {
	private static final int PORT = 8000;
	private static final Logger log = Logger.getLogger(Server.class);

	public static void main(String[] args) {
		Server server = new Server();
		server.init();
	}

	public void init() {
		ServerSocket ssocket = null;
/*		BufferedReader br = null;
		PrintWriter pw = null;*/
		try {
			log.debug("开启端口-----------：" + PORT);
			ssocket = new ServerSocket(PORT);
			while (true) {
				// 等待请求,此方法会一直阻塞,直到获得请求才往下走
				Socket socket = ssocket.accept();
				// 一个客户端连接就开户两个线程处理读写
				new Thread(new ReadHandlerThread(socket)).start();
				new Thread(new WriteHandlerThread(socket)).start();
				// 用于接收客户端发来的请求
				/*br = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				// 用于发送返回信息,可以不需要装饰这么多io流使用缓冲流时发送数据要注意调用.flush()方法
				pw = new PrintWriter(new OutputStreamWriter(
						socket.getOutputStream()), true);
				String readLine = br.readLine();
				System.out.println("server receive:" + readLine);
				pw.println("server: send message");
				pw.flush();*/
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ssocket != null) {
					ssocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/*
 * 处理写操作的线程
 */
class WriteHandlerThread implements Runnable {
	private Socket client;

	public WriteHandlerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		DataOutputStream dos = null;
		BufferedReader br = null;
		try {
			while (true) {
				// 向客户端回复信息
				dos = new DataOutputStream(client.getOutputStream());
				System.out.print("请输入:\t");
				// 键盘录入
				br = new BufferedReader(new InputStreamReader(System.in));
				String send = br.readLine();
				// 发送数据
				dos.writeUTF(send);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
				if (br != null) {
					br.close();
				}
				if (client != null) {
					client = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
class ReadHandlerThread implements Runnable {
	private Socket client;

	public ReadHandlerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			while (true) {
				// 读取客户端数据
				dis = new DataInputStream(client.getInputStream());
				String reciver = dis.readUTF();
				System.out.println("客户端发过来的内容:" + reciver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
				if (client != null) {
					client = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}