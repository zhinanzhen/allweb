package com.thinkinginjava.fifteenth;

import java.util.ArrayList;
import java.util.List;

import com.thinkinginjava.fifteenth.array.Apple;
import com.thinkinginjava.fifteenth.array.Fruit;

public class GenericWriting {
	static <T> void writeExact(List<T> list,T item ){
		list.add(item);
	}
	
	static List<Fruit> flist = new ArrayList<Fruit>();
	static List<Apple> alist = new ArrayList<Apple>();
	
	static void f1(){
		writeExact(flist,new Fruit());
		writeExact(alist,new Apple());
		writeExact(flist,new Apple());
	}
	
	static <T> void writeWithWileCard(List<? super T> list,T item){
		list.add(item);
	}
	
	static void f2(){
		writeWithWileCard(flist,new Fruit());
		writeWithWileCard(alist,new Apple());
		writeWithWileCard(flist,new Apple());
	}
	public static void main(String[] args) {
		f1();
		System.out.println(flist);
		System.out.println(alist);
		f2();
		System.out.println(flist);
		System.out.println(alist);
	}
}
