package com.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @ClassName NioServerSocket
 * @Description
 * @Author xuxiangnan
 * @Date 2021/11/17 18:01
 */
public class NioServerSocket {
    public static void main(String[] args) throws Exception{
        LinkedList<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        // 不阻塞
        ss.configureBlocking(false);
        while(true){
            Thread.sleep(1000);
            SocketChannel client = ss.accept();
            if(client == null){
                System.out.println("null ……");
            }else{
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client port:" + port);
                clients.add(client);
            }
            ByteBuffer allocate = ByteBuffer.allocate(4096);
            for (SocketChannel cli : clients) {
                int read = cli.read(allocate);
                if(read > 0){
                    allocate.flip();
                    byte[] aa = new byte[allocate.limit()];
                    allocate.get(aa);
                    String str = new String(aa);
                    System.out.println(cli.socket().getPort() + ":" + str);
                    allocate.clear();
                }
            }
            
        }
    }
}
