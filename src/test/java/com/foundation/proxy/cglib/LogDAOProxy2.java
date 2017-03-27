package com.foundation.proxy.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.apache.log4j.Logger;

public class LogDAOProxy2 implements MethodInterceptor {
	private Logger log = Logger.getLogger(LogDAOProxy2.class);
	private Object dao = null;
	private Enhancer enhancer = new Enhancer();

	// 返回DAO的子类
	public Object getDAO(Class clz, Object dao) {
		this.dao = dao;
		enhancer.setSuperclass(clz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	// 默认的拦截方法
	public Object intercept(Object o, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		log.info("调用日志方法" + method.getName());
		log.info(Arrays.toString(args));
		Object result = proxy.invoke(dao, args);
		return result;
	}
	
	public static void main(String[] args) {
		LogDAOProxy2 proxy = new LogDAOProxy2();
		CargosDao  dao = (CargosDao)proxy.getDAO(CargosDao.class,new CargosDao());
	    dao.insert("hahahaha");
	}
}
