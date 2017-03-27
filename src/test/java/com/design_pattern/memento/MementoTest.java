package com.design_pattern.memento;

public class MementoTest {
	public static void main(String[] args) {
		Original original = new Original();
		original.setNum(23);
		original.setValue("xu");
		Storage storage = new Storage(original.createMemento());
		
		System.out.println("not update : " + original.getValue());
		
		original.setValue("xiang");
		System.out.println("has update : "+ original.getValue());
		
		original.restoreMemento(storage.getMemento());
		System.out.println("recover data : " + original.getValue());
		
		
	}
}
