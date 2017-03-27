package com.foundation.remote.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
	public static void main(String[] args) throws Exception {
		RemoteImpl r = new RemoteImpl();//创建远程对象
        Registry rr = LocateRegistry.createRegistry(1234); //创建1234端口上的对象注册表,如果已经创建了就用getRegistry方法获取
        rr.bind("testrmi", r);//向注册表中注册对象
        System.out.println(r.toString());
	}
}
