package com.app.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 将父类所有的属性COPY到子类中
 * @author xxn
 * @date 2015年11月9日  下午2:03:36
 */
public class FatherToChildUtils{
	/**
	 * 将父类所有的属性COPY到子类中、类定义中child一定要extends father、都遵循javaBean规范
	 * @param father  父类
	 * @param child		子类
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void fatherToChild (Object father,Object child){
		 if(!(child.getClass().getSuperclass()==father.getClass())){  
	            System.err.println("child不是father的子类"); 
	        }
	        Class fatherClass= father.getClass(); 
	        Class childClass= child.getClass();
	        Field[] fatherFields= fatherClass.getDeclaredFields();  
	        for(int i=0;i<fatherFields.length;i++){
	            Field fatherField=fatherFields[i];//取出每一个属性
				try {
					PropertyDescriptor fpd = new PropertyDescriptor(fatherField.getName(), fatherClass);
					PropertyDescriptor cpd = new PropertyDescriptor(fatherField.getName(), childClass);
					Method getter = fpd.getReadMethod();
					Method setter = cpd.getWriteMethod();
	    			Object value = getter.invoke(father);
	    			setter.invoke(child, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
             }
	}
}
