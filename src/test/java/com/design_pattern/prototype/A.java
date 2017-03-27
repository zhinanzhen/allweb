package com.design_pattern.prototype;

import java.io.Serializable;


public class A extends CloneableBase implements Serializable{
	private String name;
	private B b;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
	
}
