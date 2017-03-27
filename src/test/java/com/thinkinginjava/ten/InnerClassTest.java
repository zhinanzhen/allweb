package com.thinkinginjava.ten;

import com.thinkinginjava.ten.A.B;

public class InnerClassTest {
	public static void main(String[] args) {
		A a = new A();
		B b = a.new B();
		b.abc();
	}
}
