package com.foundation;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanUtilsTest {
	private static final Log log = LogFactory.getLog(BeanUtils.class);
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Person person = new Person();
		person.setName("xi");
		person.setAddress("hh");
		Manager manager = new Manager();
		BeanUtils.copyProperties(manager,person);
		System.out.println(manager.getName());
		System.out.println(log.isTraceEnabled());
	}
}
