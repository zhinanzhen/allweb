package com.design_pattern.dercorator.monkey;

public class Fish extends Change{
	private TheGreatestSage ths;
	public Fish(TheGreatestSage ths) {
		super(ths);
		this.ths = ths;
	}
	@Override
	public void move() {
		ths.move();
		swim();
	}
	public void swim(){
		System.out.println("swim in water");
	}
}
