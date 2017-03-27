package com.osc.introspector;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanInfoUtil3 {
	public static void setProperty(UserInfo userInfo,String userName)throws Exception{
        PropertyDescriptor propDesc=new PropertyDescriptor(userName,UserInfo.class);
        Method methodSetUserName=propDesc.getWriteMethod();
        methodSetUserName.invoke(userInfo, "wong");
        System.out.println("set userName:"+userInfo.getUserName());
    }
  
    public static void getProperty(UserInfo userInfo,String userName)throws Exception{
        PropertyDescriptor proDescriptor =new PropertyDescriptor(userName,UserInfo.class);
        Method methodGetUserName=proDescriptor.getReadMethod();
        Object objUserName=methodGetUserName.invoke(userInfo);
        System.out.println("get userName:"+objUserName.toString());
    }

}
