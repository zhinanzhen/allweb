package com.design_pattern.dercorator;

public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA(Component component) {
		super(component);
	}
	@Override
	public void operation() {
		super.operation();
		System.out.println("A");
	}
}
