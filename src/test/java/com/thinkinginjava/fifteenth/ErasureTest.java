package com.thinkinginjava.fifteenth;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.thinkinginjava.fifteenth.coffee.Coffee;

public class ErasureTest{
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Erasure<Coffee> er = new Erasure<>(Coffee.class);
		Erasure<Coffee> er2 = new Erasure<>(Coffee.class);
		System.out.println(er.getClass()==er2.getClass());
		Coffee c = new Coffee();
		Coffee c2 = new Coffee();
		System.out.println(c.getClass() == c2.getClass());
		
		System.out.println("-------------------------");
		
		List list = new ArrayList();
		list.add("1wewe");
		list.add(123);
//		list.getClass().getMethod("add", Object.class).invoke(list, 123);
		for (Object string : list) {
			System.out.println(string);
		}
		
		ArrayList<String> arrayList1=new ArrayList<String>();  
        arrayList1.add(new String());  
        arrayList1.add(new String());  
	}
}

class Erasure<T> {
	private Class<T> cls;
	public Erasure(Class<T> cls){
		this.cls = cls;
	}
	public T getInit() throws InstantiationException, IllegalAccessException{
		return cls.newInstance();
	}
}
