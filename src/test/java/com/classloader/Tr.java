package com.classloader;

import java.util.Date;

public class Tr extends Date{
	public void test(){
		System.out.println(super.getClass().getName());
	}
	public static void main(String[] args) {
		Tr tr = new Tr();
		tr.test();
	}
}
