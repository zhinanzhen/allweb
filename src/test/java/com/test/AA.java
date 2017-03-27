package com.test;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Enumeration;


public class AA extends BB {
	private String a;
	public static void main(String[] args) throws IntrospectionException {
		Class a = AA.class;
		BeanInfo info = Introspector.getBeanInfo(a,BB.class);
		PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : descriptors) {
			System.out.println(propertyDescriptor.getName());
		}
//		try {
//			String str = "aa";
//			try {
//				System.out.println(a);
//				a.getDeclaredField(str);
//			} catch (Exception e) {
//				Class superclass = a.getSuperclass();
//				System.out.println(superclass);
//				Field field = a.getSuperclass().getDeclaredField(str);
//			}
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	
	
}
