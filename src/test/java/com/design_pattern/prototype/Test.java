package com.design_pattern.prototype;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.setB(b);
		a.setName("aaaa");
		A aa = (A) a.clone();
		System.out.println(aa.getB() == b);
	}
}
