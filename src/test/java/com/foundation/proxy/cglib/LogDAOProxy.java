package com.foundation.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.apache.log4j.Logger;

/**
 * cglib 动态代理
 * @author xxn
 * @date 2016年7月27日  上午11:00:11
 */
public class LogDAOProxy implements MethodInterceptor {
	private Logger log = Logger.getLogger(LogDAOProxy.class);
	private Enhancer enhancer = new Enhancer();

	// 返回DAO的子类
	public Object getDAO(Class clz) {
		enhancer.setSuperclass(clz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		log.info("调用日志方法" + method.getName());
		Object result = proxy.invokeSuper(obj, args);
		return result;
	}
	
	public static void main(String[] args) {
		LogDAOProxy proxy = new LogDAOProxy();
	    GoodsDAO  dao = (GoodsDAO)proxy.getDAO(GoodsDAO.class);
	    dao.insert("goods");
	}

}
