package com.design_pattern.bridge.test1;

public class MyBridge extends Bridge {
	public void method(){
		getSource().method();
	}
}
