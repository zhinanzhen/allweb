package com.foundation.remote.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SockServer {
	private static final Log log = LogFactory.getLog(SockServer.class);
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket accept = null;
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		try {
			server = new ServerSocket(7000);
			log.debug("server start……");
			accept = server.accept();
			SocketAddress clientIp = accept.getRemoteSocketAddress();
			InetAddress ip = accept.getInetAddress();
			log.info("客户端 [" + clientIp + "]: ");
			log.info("服务器"+ip.toString());
			while(true){
				bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
				printWriter = new PrintWriter(accept.getOutputStream());
				String readLine = bufferedReader.readLine();
				if("bye".equals(readLine)){
					break;
				}
				System.out.println("接收:"+readLine);
				printWriter.println(readLine);
				printWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				accept.close();
				bufferedReader.close();
				printWriter.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		log.debug("server end");
	}
}
