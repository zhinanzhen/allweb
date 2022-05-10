package com.classloader;

import java.util.Date;

public class Tr extends Date{
	public void test(){
		System.out.println(this.getClass().getClassLoader());
		System.out.println(this.getClass().getClassLoader().getParent());
		System.out.println(this.getClass().getClassLoader().getParent().getParent());
		System.out.println(int.class.getClassLoader());

		System.out.println("-------------------------------");
		System.out.println(System.getProperty("sun.mic.boot.class"));
		System.out.println("-------------------------------");
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println("-------------------------------");
		System.out.println(System.getProperty("java.class.path"));
	}
	public static void main(String[] args) {
		Tr tr = new Tr();
		tr.test();
	}
}
