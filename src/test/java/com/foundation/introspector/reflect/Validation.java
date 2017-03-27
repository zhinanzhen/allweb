package com.foundation.introspector.reflect;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

public class Validation {
	public static String validation(Object obj){
		Class<? extends Object> cls = obj.getClass();
		Field[] declaredFields = cls.getDeclaredFields();
		for (Field field : declaredFields) {
			Annotation[] annotations = field.getAnnotations();
			String type = field.getGenericType().toString();
			System.out.println(field.getName());
			boolean exists = false;
			for (Annotation annotation : annotations) {
				Class<? extends Annotation> annotationType = annotation.annotationType();
				if(annotationType.toString().equals(IsNeedField.class.toString())){
					exists = true;
				}
			}
			if(!exists){
				continue;
			}
			IsNeedField isNeedField = field.getAnnotation(IsNeedField.class);
			try {
				PropertyDescriptor propertyDes = new PropertyDescriptor(field.getName(), cls);
				Method readMethod = propertyDes.getReadMethod();
				if("class java.lang.String".equals(type)){
					String value = (String)readMethod.invoke(obj);
					if(isNeedField.notNull() == true){
						if (!StringUtils.isNotEmpty(value)) {
							throw new RuntimeException("\r\n属性名称：【"+field.getName()+"】校验非法，不能为空值！");
						}
					}
				}else{
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
}
