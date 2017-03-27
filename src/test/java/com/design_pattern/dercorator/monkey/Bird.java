package com.design_pattern.dercorator.monkey;

public class Bird extends Change {
	private TheGreatestSage ths;
	public Bird(TheGreatestSage ths) {
		super(ths);
		this.ths = ths;
	}
	@Override
	public void move() {
		ths.move();
		fly();
	}
	public void fly(){
		System.out.println("fly in sky");
	}
}
