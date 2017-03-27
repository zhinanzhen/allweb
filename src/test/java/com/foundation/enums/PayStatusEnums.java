package com.foundation.enums;

import java.lang.reflect.Method;

public enum PayStatusEnums {
	
	失败("0"),成功("1");
	
	private String value;
	PayStatusEnums(String value){
		this.value = value;
	}
 
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	public static void main(String[] args) {
		System.out.println(PayStatusEnums.失败.getClass());
		System.out.println(PayStatusEnums.成功.getClass());
	}
}

