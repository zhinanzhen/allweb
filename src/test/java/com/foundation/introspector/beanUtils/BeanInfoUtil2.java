package com.foundation.introspector.beanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import com.foundation.introspector.beans.UserInfo;

/**
 * Introspector类:
 * 将JavaBean中的属性封装起来进行操作。
 * 在程序把一个类当做JavaBean来看，就是调用Introspector.getBeanInfo()方法，
 * 得到的BeanInfo对象封装了把这个类当做JavaBean看的结果信息，即属性的信息。
 * @author xxn
 * @date 2016年1月29日  上午10:58:16
 */
public class BeanInfoUtil2 {
	public static void setPropertyByIntrospector(UserInfo userInfo,String property,Object value) throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(userInfo.getClass());
//		PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(userInfo.getClass());
		//获得属性信息
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if (propertyDescriptors != null && propertyDescriptors.length > 0) {
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				if (propertyDescriptor.getName().equals(property)) {
					// 获得应该用于写入属性值的方法
					Method writeMethod = propertyDescriptor.getWriteMethod();
					writeMethod.invoke(userInfo, value);
					System.out.println("set value:" + userInfo);
				}
			}
		}
	}
	public static void setPropertyByIntrospector(UserInfo userInfo,String property) throws Exception{
		BeanInfo beanInfo = Introspector.getBeanInfo(userInfo.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if (propertyDescriptors != null && propertyDescriptors.length > 0) {
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				if(propertyDescriptor.getName().equals(property)){
					// 获得应该用于读取属性值的方法
					Method readMethod = propertyDescriptor.getReadMethod();
					Object value = readMethod.invoke(userInfo);
					System.out.println("get value:"+value);
				}
			}
		}
	}
	
}
