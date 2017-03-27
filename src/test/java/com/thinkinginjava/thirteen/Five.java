package com.thinkinginjava.thirteen;

import java.util.Formatter;

public class Five {
	public static void main(String[] args) {
		int a = 12;
		float f = 23.45f;
		System.out.printf("Row1:[%d ===== %f]\n", a,f);
		Formatter form = new Formatter(System.out);
		form.format("Row1:[%d ===== %f]\n", a,f);
		System.out.printf("Row1:[%-15s %5s %10.2f]\n", "sdfeeeeeeeeeeee","237",45.6678);
		System.out.printf("Row1:[%-15s %5s %10.2f]\n", "sdffgdfg","23",45.6);
		System.out.printf("Row1:[%-15s %5s %10.2f]\n", "sdffgg","23",45.6);
		System.out.printf("Row1:[%-15s %5s %10.2f]\n", "sdfhhh","23",45.6);
		System.out.printf("Row1:[%-15s %5s %10.2f]\n", "sdfbbbb","23",45.6);
//		String.format(format, args);
	}
}
