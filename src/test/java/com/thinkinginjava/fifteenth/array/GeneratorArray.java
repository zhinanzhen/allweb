package com.thinkinginjava.fifteenth.array;

public class GeneratorArray<T> {
	private T[] array;

	@SuppressWarnings("unchecked")
	public GeneratorArray(int size) {
		array = (T[]) new Object[size];
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
