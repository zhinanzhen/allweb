package com.thinkinginjava.nine;

public class ClassA implements InterA{
	public void move2(){
		System.out.println("AAAA");
	}

	@Override
	public int move() {
		return 0;
	}
	public static void main(String[] args) {
		ClassA aa  = new ClassA();
		System.out.println(aa.a);
		
	}
}
