package com.thinkinginjava.fifteenth;

import java.util.Arrays;
import java.util.List;

import com.thinkinginjava.fifteenth.array.Apple;
import com.thinkinginjava.fifteenth.array.Fruit;

public class GenericReading {
	static List<Fruit> flist = Arrays.asList(new Fruit());
	static List<Apple> alist = Arrays.asList(new Apple());
	static <T> T readExact(List<T> list){
		return list.get(0);
	}
	static void f1(){
		Fruit fruit = readExact(flist);
		Apple apple = readExact(alist);
		fruit = readExact(alist);
	}
	
	static class Read<T>{
		T readExact(List<T> list){
			return list.get(0);
		}
	}
	
	static void f2(){
		Read<Fruit> fread = new Read<Fruit>();
		Fruit fruit = fread.readExact(flist);
//		read.readExact(alist);// Error
		
		Read<Apple> aread = new Read<Apple>();
		Apple apple = aread.readExact(alist);
	}
	
	static class CovariantReader<T>{
		T readCovariant(List<? extends T> list){
			return list.get(0);
		}
	}
	
	static void f3(){
		CovariantReader<Fruit> cread = new CovariantReader<Fruit>();
		Fruit fruit = cread.readCovariant(flist);
		Fruit fruit2 = cread.readCovariant(alist);
	}
}
