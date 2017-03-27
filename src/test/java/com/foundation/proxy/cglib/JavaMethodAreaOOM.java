package com.foundation.proxy.cglib;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class JavaMethodAreaOOM {
	private Logger log = Logger.getLogger(JavaMethodAreaOOM.class);
	
	public static Object createObject(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(OOMobject.class);
		enhancer.setUseCache(false);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
				return proxy.invoke(obj, args);
			}
		});
		return enhancer.create();
	}
	
	public static void main(String[] args) {
//		OOMobject obj = (OOMobject)createObject();
//		obj.print();
	}
	static class OOMobject{
		public static void print(){
			System.out.println("33333333333333");
		}
	}
}
