package com.test;

public class E extends AbstractClass implements InterfaceClass {

	@Override
	public void test() {
		System.out.println("eeeeeeeeeeeeeee");
	}

	public static void main(String[] args) {
		System.out.println(InterfaceClass.a);
		System.out.println(AbstractClass.a);
		AbstractClass ab = new E();
		InterfaceClass in = new E();
		E e = new E();
		ab.test();
		in.test();
		e.test();
	}

}
