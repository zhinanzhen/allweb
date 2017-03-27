package com.foundation.thread;

/**
 * ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量
 * @author xxn
 * @date 2016年5月24日  上午10:39:56
 */
public class ThreadLocalTest {
	private ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	private ThreadLocal<String> stringLocal = new ThreadLocal<String>();
	
	public void setValue(){
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}
	
	public Long getLongLocal() {
		return longLocal.get();
	}

	public String getStringLocal() {
		return stringLocal.get();
	}

	public static void main(String[] args) {
		final ThreadLocalTest test = new ThreadLocalTest();
		test.setValue();
		
		System.out.println(test.getLongLocal());
		System.out.println(test.getStringLocal());
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				test.setValue();
				
				System.out.println(test.getLongLocal());
				System.out.println(test.getStringLocal());
			}
		};
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(test.getLongLocal());
		System.out.println(test.getStringLocal());
	}
}
