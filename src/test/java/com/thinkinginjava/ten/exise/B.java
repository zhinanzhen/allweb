package com.thinkinginjava.ten.exise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {
	private Object[] elementData = new Object[10];
	private int size;
	public void removeAll(){
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
	}
	public void storeU(U u) {
		List a = new ArrayList();
		if(u != null){ 
			elementData[size++]  = u;
		}
	}
	public void showAll(){
		for (int i = 0; i < size; i++) {
			U u = (U) elementData[i];
			u.add(12, 23);
			u.substr("23");
			u.print("xxn");
		}
	}
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		U u = a.methodA();
		b.storeU(u);
		b.showAll();
		b.removeAll();
		
	}
}
