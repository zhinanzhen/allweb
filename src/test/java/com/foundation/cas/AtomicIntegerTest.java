package com.foundation.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	private int value;
	AtomicIntegerTest(int value){
		this.value = value;
	}
	public int getAndAdd(int value){
		return this.value + value;
	}
	public static void main(String[] args) {
		long stat = System.currentTimeMillis();
		AtomicIntegerTest at = new AtomicIntegerTest(0);
		for(int i=0;i<100000;i++){
			at.getAndAdd(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - stat);
		
		stat = System.currentTimeMillis();
		AtomicInteger ai = new AtomicInteger(0);
		for(int i=0;i<100;i++){
			ai.getAndAdd(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end - stat);
		
		System.out.println(ai.get());
		int andAdd = ai.getAndAdd(100);
		System.out.println(andAdd);
		andAdd = ai.getAndAdd(1);
		System.out.println(andAdd);
	}
}
