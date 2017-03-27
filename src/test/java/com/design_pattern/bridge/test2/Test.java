package com.design_pattern.bridge.test2;

public class Test {
	public static void main(String[] args) {
		Implementor im = new ConcreteImplementorA();
		RefinedAbstraction abs = new RefinedAbstraction(im);
		abs.operation();
		abs.otherOperation();
	}
}
