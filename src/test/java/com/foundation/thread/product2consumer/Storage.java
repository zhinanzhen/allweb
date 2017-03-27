package com.foundation.thread.product2consumer;

public interface Storage {
	void consumer(int num);
	void product(int num);
}
