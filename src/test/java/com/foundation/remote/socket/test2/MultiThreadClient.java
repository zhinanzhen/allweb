package com.foundation.remote.socket.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadClient {
	public static void main(String[] args) {
		int numTasks = 10;
		ExecutorService exeService = Executors.newCachedThreadPool();
		for (int i = 0; i < numTasks; i++) {
			exeService.execute(createTask(i));
		}
	}

	private static Runnable createTask(int i) {
		return new Runnable() {
			private Socket socket;
			private int port = 8888;

			@Override
			public void run() {
				System.out.println("Task start");
				try {
					socket = new Socket("127.0.0.1", port);
					// 发送关闭命令
					OutputStream socketOut = socket.getOutputStream();
					socketOut.write("shutdown\r\n".getBytes());

					// 接收服务器的反馈
					BufferedReader br = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					String msg = null;
					while ((msg = br.readLine()) != null)
						System.out.println(msg);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
	}
}
