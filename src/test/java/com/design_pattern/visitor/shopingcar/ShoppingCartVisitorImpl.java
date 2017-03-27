package com.design_pattern.visitor.shopingcar;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	@Override
	public int visit(ItemElement item) {
		if(item instanceof Book){
			return 1;
		}else if(item instanceof Fruit){
			return 2;
		}
		return 0;
	}

}
