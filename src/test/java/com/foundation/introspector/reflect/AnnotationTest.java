package com.foundation.introspector.reflect;

import com.foundation.introspector.beans.UserInfo;

public class AnnotationTest {
	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo(2355666, "xiangnan", 25, "xuxn@163.com");
		Validation.validation(userInfo);
//		System.out.println(IsNeedField.class.toString());
		String obj;
	}
}
