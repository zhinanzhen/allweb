package com.design_pattern.proxy.test2;

public class BusinessBarImpl implements BusinessBar{

	@Override
	public String bar(String message) {
		System.out.println("bar:" + message);
		return message;
	}

	@Override
	public String bar2(String message) {
		System.out.println("bar2:" + message);
		return message;
	}
}
