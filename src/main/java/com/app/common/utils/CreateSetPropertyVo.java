package com.app.common.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import com.app.showpic.register.bean.User;

/**
 * 生成set属性方法
 * @author xxn
 * @date 2016年10月14日  下午4:08:49
 */
public class CreateSetPropertyVo {
	public static void main(String[] args) throws IntrospectionException {
		// 需要更改需要生成set属性方法的类名======== ？ 
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if (propertyDescriptors != null && propertyDescriptors.length > 0) {
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				if(propertyDescriptor.getWriteMethod() != null){
					// 需要更改引用名称=========？
					System.out.println("user."+propertyDescriptor.getWriteMethod().getName()+"();");
				}
			}
		}
	}
}
