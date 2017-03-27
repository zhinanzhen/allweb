package com.algorithm.counter;

public class FactorySub implements Provider{

	@Override
	public Operate produce() {
		return new SubOperate();
	}

}
