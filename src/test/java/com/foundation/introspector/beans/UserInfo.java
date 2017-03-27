package com.foundation.introspector.beans;

import com.foundation.introspector.reflect.IsNeedField;

/**
 * 内省(Introspector) 是Java 语言对 JavaBean 类属性、事件的一种缺省处理方法
 * Java JDK中提供了一套 API 用来访问某个属性的 getter/setter 方法，这就是内省。
 * @author xxn
 * @date 2016年1月29日  上午10:23:16
 */
public class UserInfo {
	@IsNeedField(notNull=true,length=20)
	private long userId;
	@IsNeedField(notNull=true,length=30)
	private String userName;
	@IsNeedField(notNull=true,length=4)
	private int age;
	@IsNeedField(notNull=true,length=40)
	private String emailAddress;

	public UserInfo() {
	}

	public UserInfo(long userId, String userName, int age, String emailAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
		this.emailAddress = emailAddress;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName
				+ ", age=" + age + ", emailAddress=" + emailAddress + "]";
	}
	
}
