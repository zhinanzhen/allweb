package com.foundation.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

public class JavaBeanVo {
	public static void main(String[] args) {       
		BeanGenerator bg = new BeanGenerator();    
		bg.addProperty("id",Long.class);           
		bg.addProperty("userName", String.class);      
		Object object = bg.create();
		BeanMap beanMap = BeanMap.create(object);
		BeanCopier copier = BeanCopier.create(BeanType.class, object.getClass(), false);
		BeanType user = new BeanType();
		user.setId(1L);
		user.setUserName("name1");
		user.setPwd("123");
		copier.copy(user, object, null);
		System.out.println(beanMap.get("userName"));
		Class clazz = object.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
		    System.out.println(methods[i].getName());
		}
		
		System.out.println(Boolean.TYPE);
	}
}
