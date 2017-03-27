package com.design_pattern.bridge.test1;

public abstract class Bridge {
	private SourceAble source;
	public void method(){
		source.method();
	}
	public SourceAble getSource() {
		return source;
	}
	public void setSource(SourceAble source) {
		this.source = source;
	}
}
