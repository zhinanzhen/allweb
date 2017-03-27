package com.foundation.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	public static void main(String[] args) {
		InvocationHandler handler = new Invoker(new ClassA());
		AbstractClass ac1 = (AbstractClass)Proxy.newProxyInstance(AbstractClass.class.getClassLoader(), 
				new Class[]{AbstractClass.class}, handler);
		System.out.println(ac1.getClass().getName());
		ac1.show();
	}
}
