package com.algorithm.fibonacci;

public class FibonacciSequence {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = fibonacci(i);
			System.out.println(sum);
		}
		
	}

	private static int fibonacci(int i) {
		if(i < 2){
			return i;
		}
		return fibonacci(i-1) + fibonacci(i-2) ;
	}
}
