package com.design_pattern.dercorator.monkey;


public class Client {
	public static void main(String[] args) {
		/*TheGreatestSage tsage = new Monkey();
		TheGreatestSage fish = new Fish(tsage);
		TheGreatestSage bird = new Bird(fish);
		bird.move();*/
		Monkey monkey = new Rabbit();
		monkey.move();
	}
}
