package com.design_pattern.proxy.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * InvocationHandler 代理实例的调用处理程序 实现的接口
 * @author xxn
 * @date 2016年1月18日  下午12:00:58
 */
public class BusiProxy implements InvocationHandler{
	private Object obj;
	
	public BusiProxy() {
	}

	public BusiProxy(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		doBefor();
		Object result = method.invoke(obj, args);
		doAfter();
		return result;
	}
	private void doAfter() {
		System.out.println("doAfter");
	}

	private void doBefor() {
		System.out.println("doBefor");
	}

	public static Object factory(Object obj){
		@SuppressWarnings("rawtypes")
		Class cla = obj.getClass();
		return Proxy.newProxyInstance(cla.getClassLoader(), cla.getInterfaces(), new BusiProxy(obj));
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
