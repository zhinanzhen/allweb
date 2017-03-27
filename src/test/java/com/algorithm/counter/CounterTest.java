package com.algorithm.counter;

public class CounterTest {
	public static void main(String[] args) {
		Provider provider = new FactoryAdd();
		Operate produce = provider.produce();
		produce.operate(12, 23);
	}
}
