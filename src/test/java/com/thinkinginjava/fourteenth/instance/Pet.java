package com.thinkinginjava.fourteenth.instance;

public class Pet extends Animal{

	public Pet() {
		super();
	}

	public Pet(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return "pet";
	}
}
