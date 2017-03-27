package com.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler{
	private Object delegate;
	
	public Object bind(Object delegate){
		this.delegate = delegate;
		// 等价于 注释部分
		Object instance = null;
		Class<?> proxyClass = Proxy.getProxyClass(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces());
		try {
			instance = proxyClass.getConstructor(new Class[] { InvocationHandler.class }).newInstance(this);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return instance;
		/*return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), 
				delegate.getClass().getInterfaces(), this);*/
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("start");
		method.invoke(delegate, args);
		System.out.println("end");
		return null;
	}
}
