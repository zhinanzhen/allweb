package com.foundation.remote.rmi.client;

import java.rmi.Naming;

import com.foundation.Person;
import com.foundation.remote.rmi.server.IRemote;

public class RmiClient {
	public static void main(String[] args) throws Exception {
		IRemote r = (IRemote) Naming.lookup("rmi://localhost:1234/testrmi");// 获取远程1234端口对象注册表中testrmi的stub
		String a = r.show();// 调用引用的方法,实际上调用的是stub,由stub与服务端交互并返回结果
		System.out.println(a);
		
		System.out.println("--------------------------");
		Person person = r.getPsersion();
		System.out.println(person.getName());
	}
}
