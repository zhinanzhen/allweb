package com.thinkinginjava.eleven;

import java.util.LinkedList;
import java.util.ListIterator;

public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	public boolean empty(){
		return storage.isEmpty();
	}
	public T peek(){
		return storage.peek();
	}
	public T push(T e){
		storage.addFirst(e);
		return e;
	}
	public T pop(){
		return storage.pop();
	}
	public int search(T e){
		ListIterator<T> it = storage.listIterator();
		while(it.hasNext()){
			if(it.next() == e){
				return it.previousIndex();
			}
		}
		return -1;
	}
}
