package com.thinkinginjava.eight;

public class Base {
	static{
		System.out.println("base");
	}
	public void print(){
		System.out.println("Base");
	}
	public B getObj(){
		return new B();
	}
	public Base() {
		super();
		System.out.println("cBase");
	}
	
}
