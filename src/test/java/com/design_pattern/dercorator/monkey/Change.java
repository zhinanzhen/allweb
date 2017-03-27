package com.design_pattern.dercorator.monkey;

public class Change implements TheGreatestSage {
	private TheGreatestSage ths;
	public Change(TheGreatestSage ths){
		this.ths = ths;
	}
	@Override
	public void move() {
		ths.move();
	}

}
