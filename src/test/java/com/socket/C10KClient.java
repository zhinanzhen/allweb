package com.socket;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @ClassName C10KClient
 * @Description
 * @Author xuxiangnan
 * @Date 2021/11/17 14:12
 */
public class C10KClient {
    public static void main(String[] args) throws Exception {
        LinkedList<SocketChannel> clients = new LinkedList<>();
        InetSocketAddress serverAddress = new InetSocketAddress("152.136.50.215", 9090);
        for (int i = 10000; i < 65000; i++) {
            SocketChannel client1 = SocketChannel.open();
            SocketChannel client2 = SocketChannel.open();

            client1.bind(new InetSocketAddress("172.16.17.80",i));
            client1.connect(serverAddress);
            client1.isOpen();
            clients.add(client1);

            /*client2.bind(new InetSocketAddress("172.16.17.80",i));
            client2.connect(serverAddress);
            client2.isOpen();
            clients.add(client2);*/
        }
    }
}
