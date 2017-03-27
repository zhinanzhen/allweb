package com.design_pattern.factory.abstracefactory;

public class CreateFacroty2 extends Factory2 {

	@Override
	IProductA getProductA2() {
		return new ProductA2();
	}

	@Override
	IProductB getProductB2() {
		return new ProductB2();
	}

}
