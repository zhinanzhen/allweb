package com.thinkinginjava.fifteenth.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArray {
	public static void main(String[] args) {
//		testArray();
//		testArray2();
//		testFruit();
//		testFruit2();
		testFruit3();
		
	}
	public static void testFruit3(){
		List<? extends Fruit> list = Arrays.asList(new Apple(),new Banana());
		Apple apple = (Apple) list.get(0);
		System.out.println(apple);

		boolean b = list.contains(new Apple());
		System.out.println(b);

		int i = list.indexOf(new Apple());
		System.out.println(i);
		System.out.println("---------------------");
		boolean b2 = list.contains(apple);
		System.out.println(b2);

		int i2 = list.indexOf(apple);
		System.out.println(i2);
		
		System.out.println("===================================");
		
		Banana banana = (Banana) list.get(1);
		System.out.println(banana);

		boolean bs = list.contains(new Banana());
		System.out.println(bs);

		int is = list.indexOf(new Banana());
		System.out.println(is);
		System.out.println("---------------------");
		boolean b2s = list.contains(banana);
		System.out.println(b2s);

		int i2s = list.indexOf(banana);
		System.out.println(i2s);
	}
	
	public static void testFruit2(){
//		ArrayList<Number> list = new ArrayList<Integer>();;
		List<? extends Number> list = new ArrayList<Number>();
		list.add(null);
		System.out.println(list.get(0));
	}
	public static void testFruit(){
		Fruit[] f = new Apple[3];
		f[0] = new Apple();
		f[1] = new Banana();// java.lang.ArrayStoreException 异常
		System.out.println(f[0]);
//		System.out.println(f[1]);
	}
	public static void testArray2(){
		GeneratorArray2<Integer> g = new GeneratorArray2<Integer>(Integer.class,5);
		g.put(0, 14);
		g.put(1, 345);
		Integer integer = g.get(1);
		System.out.println(integer);
		Integer[] array = g.allArray();
		System.out.println(array);
	}
	public static void testArray(){
		GeneratorArray<Integer> g = new GeneratorArray<Integer>(5);
		g.put(0, 14);
		g.put(1, 345);
		Integer integer = g.get(1);
		System.out.println(integer);
		
		// 报错---类型已经擦出
//		Integer[] allArray = g.allArray();
		
		Object[] allArray = g.allArray();
		System.out.println(allArray);
	}
}
