package com.remote.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @ClassName RPCClient
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/20 14:27
 */
public class RPCClient<T> {
    public static <T> T getRemoteProxyObj(final Class<?> serviceInterface, final InetSocketAddress addr) {
        return (T)Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class[]{serviceInterface}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;
                ObjectInputStream oInputStream = null;
                ObjectOutputStream oOutputStream = null;

                try {
                    socket = new Socket();
                    socket.connect(addr);

                    oOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    oOutputStream.writeUTF(serviceInterface.getSimpleName());
                    oOutputStream.writeUTF(method.getName());
                    oOutputStream.writeObject(method.getParameterTypes());
                    oOutputStream.writeObject(args);

                    oInputStream = new ObjectInputStream(socket.getInputStream());
                    return oInputStream.readObject();
                }finally {
                    if (socket != null){
                        socket.close();
                    }
                    if (oInputStream != null){
                        oInputStream.close();
                    }
                    if (oOutputStream != null){
                        oOutputStream.close();
                    }
                }
            }
        });
    }
}
