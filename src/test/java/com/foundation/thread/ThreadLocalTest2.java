package com.foundation.thread;

/**
 * ThreadLocal的作用是提供线程内的局部变量，这种变量在线程的生命周期内起作用，减少同一个线程内多个函数或者组件之间一些公共变量的传递的复杂度
 * @author xxn
 * @date 2016年5月24日  上午11:53:17
 */
public class ThreadLocalTest2 {
	private ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
		protected Long initialValue() {
			return Thread.currentThread().getId();
		};
	};
	private ThreadLocal<String> stringLocal = new ThreadLocal<String>(){
		protected String initialValue() {
			return Thread.currentThread().getName();
		};
	};
	
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
		final ThreadLocalTest2 test = new ThreadLocalTest2();
//		test.setValue();// 如果不重写注释掉，则为null，init返回为空。
		
		System.out.println(test.getLongLocal());
		System.out.println(test.getStringLocal());
		Thread thread = new Thread(){
			@Override
			public void run() {
//				test.setValue();
				
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
