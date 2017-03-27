package com.thinkinginjava.fourteenth.instance;

public class Animal implements Comparable<Animal>{
	private String name;

	public Animal() {
	}

	public Animal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Animal o) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "animal";
	}
}
