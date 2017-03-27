package com.algorithm.counter;

public class FactoryAdd implements Provider{

	@Override
	public Operate produce() {
		return new AddOperate();
	}

}
