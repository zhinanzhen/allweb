package com.thinkinginjava.fifteenth.array;

import java.lang.reflect.Array;

public class GeneratorArray2<T> {
	private T[] array;
	@SuppressWarnings("unchecked")
	public GeneratorArray2(Class<T> cls,int size){
		array = (T[]) Array.newInstance(cls, size);
	}
	public void put(int index,T item){
		array[index] = item;
	}
	
	public T get(int index){
		return array[index];
	}
	
	public T[] allArray(){
		return array;
	}
}
