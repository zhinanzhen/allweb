package com.foundation.introspector.beanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import com.foundation.introspector.beans.UserInfo;

/**
 * PropertyDescriptor类表示JavaBean类通过存储器导出一个属性。主要方法： 　　
 * 1.getPropertyType()，获得属性的Class对象; 　　
 * 2.getReadMethod()，获得用于读取属性值的方法；getWriteMethod()，获得用于写入属性值的方法; 　　
 * 3.hashCode()，获取对象的哈希值; 　　
 * 4. setReadMethod(Method readMethod)，设置用于读取属性值的方法; 　　
 * 5.setWriteMethod(Method writeMethod)，设置用于写入属性值的方法。
 * 
 * @author xxn
 * @date 2016年1月29日 上午10:46:16
 */
public class BeanInfoUtil {
	public static void setProperty(UserInfo userInfo, String userName,Object value) throws Exception {
		PropertyDescriptor proDes = new PropertyDescriptor(userName,userInfo.getClass());
		Method writeMethod = proDes.getWriteMethod();
		writeMethod.invoke(userInfo, value);
		System.out.println("set value:" + userInfo.getUserName());
	}

	public static void getProperty(Object userInfo, String userName)throws Exception {
		PropertyDescriptor proDes = new PropertyDescriptor(userName,userInfo.getClass());
		Method readMethod = proDes.getReadMethod();
		Object value = readMethod.invoke(userInfo);
		System.out.println("get value:" + value.toString());
	}

	public static void main(String[] args) throws Exception {
		UserInfo userInfo = new UserInfo(112300L, "xuxiangnan", 25,"xuxn163com@163com");
		setProperty(userInfo, "userName", "haha");
		getProperty(userInfo, "userName");
	}
}
