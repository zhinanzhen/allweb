package com.app.hession.client;

import java.net.MalformedURLException;

import com.app.hession.IHello;
import com.caucho.hessian.client.HessianProxyFactory;

public class ClientTest {
	public static String url = "http://127.0.0.1:8080/all_web/remoting";

	public static void main(String[] args) {
		HessianProxyFactory factory = new HessianProxyFactory();
		try {
			IHello iHello = (IHello) factory.create(IHello.class, url);
			System.out.println(iHello.sayHello());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
