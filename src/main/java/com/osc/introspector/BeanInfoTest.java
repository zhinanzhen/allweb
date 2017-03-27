package com.osc.introspector;

/**
 * 内省
 * @author xxn
 * @date 2015年11月4日  下午5:19:17
 */
public class BeanInfoTest {
	public static void main(String[] args) {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("peida");
        try {
//            BeanInfoUtil.getProperty(userInfo, "userName");
//            BeanInfoUtil.setProperty(userInfo, "userName");
//            BeanInfoUtil.getProperty(userInfo, "userName");
//            BeanInfoUtil.setPropertyByIntrospector(userInfo, "userName");            
            BeanInfoUtil.getPropertyByIntrospector(userInfo, "userId");
//            BeanInfoUtil.setProperty(userInfo, "age");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
