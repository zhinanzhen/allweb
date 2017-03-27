package com.design_pattern.visitor.shopingcar;

public class Fruit implements ItemElement {

	@Override
	public void acctpt(ShoppingCartVisitor visitor) {
		visitor.visit(this);
	}

}
