package com.thinkinginjava.eight;

public class A extends Base{
	public A() {
		System.out.println("CA");
	}
	static{
		System.out.println("A");
	}
	public void print(){
		System.out.println("A");
	}
	public void you(){
		System.out.println("A you");
	}
	public C getObj(){
		return new C();
	}
	
	public static void main(String[] args) {
		new A();
	}
}
