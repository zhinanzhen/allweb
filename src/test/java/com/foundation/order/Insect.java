package com.foundation.order;

public class Insect {
	private int i = 9;
	protected int j;

	Insect() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}

	private int p = print(" Insect.p initialized");
	private static int x1 = print("static Insect.x1 initialized");

	static int print(String s) {
		System.out.println(s);
		return 47;
	}
}
