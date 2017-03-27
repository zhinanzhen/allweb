package com.thinkinginjava.fifteenth;

public class LinkStack<T> {
	public static class Node<U>{
		U item;
		Node<U> next;
		Node(){
			item = null;
			next = null;
		}
		Node(U item,Node<U> next){
			this.item = item;
			this.next = next;
		}
		boolean end(){
			return item == null && next == null;
		}
	}
	private Node<T> top = new Node<T>(); 
	public void push(T item){
		top = new Node<T>(item, top);
	}
	public T pop(){
		T result = top.item;
		if(!top.end()){
			top = top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkStack<String> linkstack = new LinkStack<String>();
		for (String string : "123344".split("")) {
			linkstack.push(string);
		}
		String str;
		while((str = linkstack.pop()) != null){
			System.out.println(str);
		}
	}
}
