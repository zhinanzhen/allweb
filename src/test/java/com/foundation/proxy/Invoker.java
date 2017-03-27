package com.foundation.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Jdk 动态代理
 * @author xxn
 * @date 2016年7月27日  上午10:59:54
 */
public class Invoker implements InvocationHandler{
	private AbstractClass ac;
	public Invoker(AbstractClass ac){
		this.ac = ac;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		method.invoke(ac, args);
		return null;
	}
	
}
