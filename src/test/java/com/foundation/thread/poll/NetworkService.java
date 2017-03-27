package com.foundation.thread.poll;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkService implements Runnable {
	private final ServerSocket serverSocket;
	private final ExecutorService pool;
	
	public NetworkService(int port,int poolSize) throws IOException {
		super();
		this.serverSocket = new ServerSocket(port);
		this.pool = Executors.newFixedThreadPool(poolSize);
	}

	@Override
	public void run() {
		for(;;){
			try {
				pool.execute(new Handle(serverSocket.accept()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class Handle implements Runnable{
		private final Socket socket;
		
		public Handle(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			
		}
		
	}

}
