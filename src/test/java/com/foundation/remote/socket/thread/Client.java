package com.foundation.remote.socket.thread;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			socket = new Socket("127.0.0.1", 8000);
			new Thread(new ClientReadHandlerThread(socket)).start();  
            new Thread(new ClientWriteHandlerThread(socket)).start();  
			/*br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			pw.println("end");
			pw.flush();
			
			String readLine = br.readLine();
			System.out.println("client receive:"+readLine);*/
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
            try {
            	if(br != null){
					br.close();
				}
				if(pw != null){
					pw.close();			
				}
				if(socket != null){
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
	}
}
/*  
 *处理读操作的线程   
 */  
class ClientReadHandlerThread implements Runnable{  
    private Socket client;  
  
    public ClientReadHandlerThread(Socket client) {  
        this.client = client;  
    }  
  
    @Override  
    public void run() {  
        DataInputStream dis = null;  
        try {  
            while(true){  
                //读取服务器端数据    
                dis = new DataInputStream(client.getInputStream());  
                String receive = dis.readUTF();     
                System.out.println("服务器端返回过来的是: " + receive);    
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(dis != null){  
                    dis.close();  
                }  
                if(client != null){  
                    client = null;  
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
class ClientWriteHandlerThread implements Runnable{  
    private Socket client;  
  
    public ClientWriteHandlerThread(Socket client) {  
        this.client = client;  
    }  
  
    @Override  
    public void run() {  
        DataOutputStream dos = null;  
        BufferedReader br = null;  
        try {  
            while(true){  
                //取得输出流  
                dos = new DataOutputStream(client.getOutputStream());  
                System.out.print("请输入: \t");    
                //键盘录入  
                br = new BufferedReader(new InputStreamReader(System.in));  
                String send = br.readLine();    
                //发送数据  
                dos.writeUTF(send);    
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  finally{  
            try{  
                if(dos != null){  
                    dos.close();  
                }  
                if(br != null){  
                    br.close();  
                }  
                if(client != null){  
                    client = null;  
                }  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
        }  
    }  
}  