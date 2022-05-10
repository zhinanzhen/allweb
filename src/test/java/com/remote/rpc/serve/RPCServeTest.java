package com.remote.rpc.serve;

import java.io.IOException;

/**
 * @ClassName RPCServeTest
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/20 15:11
 */
public class RPCServeTest {
    public static void main(String[] args) {
        RPCServe rpcServe = new RPCServe(8088);
        try {
            rpcServe.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
