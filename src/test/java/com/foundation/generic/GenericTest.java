package com.foundation.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thinkinginjava.fourteenth.instance.Animal;
import com.thinkinginjava.fourteenth.instance.Cat;
import com.thinkinginjava.fourteenth.instance.Pet;


/**
 * 不能创建一个确切泛型类型的数组--只能创建带通配符的泛型数组
 * @author xxn
 * @date 2016年5月5日  下午12:17:11
 */
public class GenericTest {
	public static <T> void getData(Box<T> box){
		System.out.println(box.getData());
	}
	public static void getWildcard(Box<?> box){
		System.out.println(box.getData());
	}
	
	//类型通配符上限和类型通配符下限
	public static void getUpperNumberData(Box<? extends Number> box){
		System.out.println(box.getData());
	}
	public static void getDownNumberData(Box<? super Number> box){
		System.out.println(box.getData());
	}
	
	//类型通配符上限
	public static void getUpperPetData(Box<? extends Pet> box){
		System.out.println(box.getData());
	}
	//类型通配符下限
	public static void getDownPetData(Box<? super Pet> box){
		System.out.println(box.getData());
	}
	
	public static <T> void fromArrayToCollec(T[] a , Collection<T> c ){
		for (T t : a) {
			c.add(t);
		}
	}
	
	public static void fromArrayToCollec(String[] a , Collection<String> c ){
		for (String t : a) {
			c.add(t);
		}
	}
	public static void test(){
		List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.  
		Object o = lsa;  
		Object[] oa = (Object[]) o;  
		List<Integer> li = new ArrayList<Integer>();  
		li.add(new Integer(3));  
		lsa[1] = li; // Correct.  
		String s = (String) lsa[1].get(0); // Run time error, but cast is explicit.
	}
	public static void main(String[] args) {
		Box<Cat> box = new Box<Cat>(new Cat());
		Box<Pet> box2 = new Box<Pet>(new Pet());
		Box<Animal> box3 = new Box<Animal>(new Animal());
//		getUpperPetData(box);
//		getUpperPetData(box2);
//		getDownPetData(box3);
		
		String[] str = new String[]{"123","34","we"};
		List<String> list = new ArrayList<>();
		fromArrayToCollec(str, list);
		for (String s : list) {
			System.out.println(s);
		}
		
		Integer[] integer = new Integer[]{11,22,33,44};
		List<Integer> list2 = new ArrayList<>();
		fromArrayToCollec(integer, list2);
		for (Integer s : list2) {
			System.out.println(s);
		}
		System.out.println("--------------------");
		test();
	}
}
class Box<T> implements IBox<T>{
	private T data;

	public Box() {
		super();
	}

	public Box(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public T get() {
		return data;
	}

	@Override
	public void set(T data) {
		this.data = data;
	}
	
}
