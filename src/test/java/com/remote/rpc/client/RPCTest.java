package com.remote.rpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @ClassName RPCTest
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/20 14:59
 */
public class RPCTest {
    public static void main(String[] args) throws IOException {
        ServiceProducer service = RPCClient.getRemoteProxyObj(ServiceProducer.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sendData("test"));
    }
}
