package com.foundation.introspector.beanUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.foundation.introspector.beans.UserInfo;

/**
 * BeanUtils工具包
 * 由上述可看出，内省操作非常的繁琐，所以所以Apache开发了一套简单、易用的API来操作Bean的属性——BeanUtils工具包。
 * 
 * 
 * 1.获得属性的值，例如，BeanUtils.getProperty(userInfo,"userName")，返回字符串
 * 2.设置属性的值，例如，BeanUtils.setProperty(userInfo,"age",8)，参数是字符串或基本类型自动包装。设置属性的值是字符串，获得的值也是字符串，不是基本类型。
 * 3.BeanUtils的特点：
 * 1). 对基本数据类型的属性的操作：在WEB开发、使用中，录入和显示时，值会被转换成字符串，但底层运算用的是基本类型，这些类型转到动作由BeanUtils自动完成。
 * 2）. 对引用数据类型的属性的操作：首先在类中必须有对象，不能是null，例如，private Date birthday=new Date();
 * 操作的是对象的属性而不是整个对象，例如，BeanUtils.setProperty(userInfo,"birthday.time",111111);　　　
 * 
 * @author xxn
 * @date 2016年1月29日  上午11:16:15
 */
public class BeanInfoUtil3 {
	public static void main(String[] args) throws Exception {
		UserInfo userInfo=new UserInfo();
		BeanUtils.setProperty(userInfo, "userName", "peida");
		System.out.println("set userName:"+userInfo.getUserName());
		System.out.println("get userName:"+BeanUtils.getProperty(userInfo, "userName"));
      
		BeanUtils.setProperty(userInfo, "age", 18);
		System.out.println("set age:"+userInfo.getAge());
		System.out.println("get age:"+BeanUtils.getProperty(userInfo, "age"));
      
		System.out.println("get userName type:"+BeanUtils.getProperty(userInfo, "userName").getClass().getName());
		System.out.println("get age type:"+BeanUtils.getProperty(userInfo, "age").getClass().getName());
      
		/* PropertyUtils.setProperty(userInfo, "age", 8);
      	System.out.println(PropertyUtils.getProperty(userInfo, "age"));
      	System.out.println(PropertyUtils.getProperty(userInfo, "age").getClass().getName());
      	PropertyUtils.setProperty(userInfo, "age", "8");   */
	}
}
