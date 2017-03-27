package com.design_pattern.visitor.shopingcar;

public class Book implements ItemElement{

	@Override
	public void acctpt(ShoppingCartVisitor visitor) {
		visitor.visit(this);
	}

}
