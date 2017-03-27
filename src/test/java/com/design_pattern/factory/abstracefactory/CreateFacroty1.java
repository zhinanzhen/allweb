package com.design_pattern.factory.abstracefactory;

public class CreateFacroty1 extends Factory1 {

	@Override
	IProductA getProductA1() {
		return new ProductA1();
	}

	@Override
	IProductB getProductB1() {
		return new ProductB1();
	}

}
