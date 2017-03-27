package com.foundation.remote.socket.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MultiThreadServer {
	private static final Log log = LogFactory.getLog(MultiThreadServer.class);
	private ServerSocket server;
	private final int PORT = 8888;
	private ExecutorService exeService;
	private final int POOL_SIZE = 10;
	public MultiThreadServer() throws IOException{
		server = new ServerSocket(PORT);
		exeService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
		log.info("服务器启动");
	}
	public void service(){
		while(true){
			Socket socket = null;
			try {
				socket = server.accept();
				exeService.execute(new Handler(socket));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		new MultiThreadServer().service();
	}
}

class Handler implements Runnable{
	private static final Log log = LogFactory.getLog(Handler.class);
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	public Handler(Socket socket){
		this.socket = socket;
	}
	public void setPrintWriter() throws IOException{
		pw = new PrintWriter(socket.getOutputStream(),true);
	}
	public void setBufReader() throws IOException{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	public String addSome(String str){
		return "server: " + str;
	}
	@Override
	public void run() {
		log.info("New connection accepted "+socket.getInetAddress()+":"+socket.getPort());
		String str = "";
		try {
			setPrintWriter();
			setBufReader();
			while((str = br.readLine()) != null){
				System.out.println(str);
				pw.print(addSome(str));
				if("bye".equals(str)){
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	
}
