package com.foundation.remote.socket.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SockClient {
	private static final Log log = LogFactory.getLog(SockClient.class);
	public static void main(String[] args) {
		Socket socket = null;
		PrintWriter printWriter = null;
		BufferedReader sin = null;
		
		try {
			socket = new Socket("127.0.0.1",7000);
			log.debug(socket);
			printWriter = new PrintWriter(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			sin = new BufferedReader(new InputStreamReader(System.in));
			String readLine = sin.readLine();
			while(!readLine.equals("bye")){
				printWriter.println(readLine);
				printWriter.flush();
				System.out.println("发送：" + readLine);
				System.out.println("server:" + br.readLine());
				readLine = sin.readLine();
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				sin.close();
				printWriter.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
