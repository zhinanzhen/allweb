package com.thinkinginjava.exception.test3;

public class Test {
	public static void f() throws ArithmeticException{
		int a = 30;
		int b = 0;
		a= a/b;
	}
	public static void main(String[] args) {
		try {
			f();
		} finally{
			System.out.println("bbbbbbbbbbbbbbbb");
		}
		System.out.println("lllllllllllll;;;;;");
	}
}
