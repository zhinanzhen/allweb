package com.app.showpic.ws.client;

import java.rmi.ConnectException;

/**
 * test测试 ---生成客户端
 * @author xxn
 * @date 2016年3月11日  上午11:21:21
 */
public class Test {
	public static void main(String[] args) throws ConnectException {
		Client client = new Client();
		String sayhello = client.sayhello("ddd");
		System.out.println(sayhello);
	}
}
