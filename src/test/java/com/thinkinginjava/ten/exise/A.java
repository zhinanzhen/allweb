package com.thinkinginjava.ten.exise;

public class A {
	public U methodA(){
		return new U(){

			@Override
			public void print(String msg) {
				System.out.println(msg);
			}

			@Override
			public int add(int a, int b) {
				return a + b;
			}

			@Override
			public String substr(String str) {
				return str+"hello";
			}
			
		};
	}
}
