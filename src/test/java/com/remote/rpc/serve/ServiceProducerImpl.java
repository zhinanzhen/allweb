package com.remote.rpc.serve;

/**
 * @ClassName ServiceProducerImpl
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/20 15:07
 */
public class ServiceProducerImpl implements ServiceProducer {
    @Override
    public String sendData(String data) {
        return "serve:" + data;
    }
}
