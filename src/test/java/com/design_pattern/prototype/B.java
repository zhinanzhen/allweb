package com.design_pattern.prototype;

import java.io.Serializable;


public class B extends CloneableBase implements Serializable{
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
