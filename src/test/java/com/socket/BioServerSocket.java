package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName BioServerSocket
 * @Description
 * @Author xuxiangnan
 * @Date 2021/11/17 14:34
 */
public class BioServerSocket {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9090),2);
        serverSocket.setReceiveBufferSize(10);
        serverSocket.setReuseAddress(false);
        serverSocket.setSoTimeout(0);

        while(true){
            Socket client = serverSocket.accept();
            client.setKeepAlive(false);
            client.setOOBInline(false);
            client.setReceiveBufferSize(20);
            client.setReuseAddress(false);
            client.setSendBufferSize(20);
            client.setSoTimeout(0);
            client.setSoLinger(true,0);
            client.setTcpNoDelay(false);
            System.out.println("client port:" + client.getPort());
            new Thread(() ->{
                try {
                    String s = "";
                    InputStream inputStream = client.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while ((s = bufferedReader.readLine())!= null){
                        System.out.println(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
