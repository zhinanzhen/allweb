package com.foundation.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable 有返回值、可以抛出异常
 * @author xxn
 * @date 2016年6月20日  下午12:21:20
 */
public class CallableTest{
	public static void main(String[] args) {
		MyCallable callable = new MyCallable();
		MyCallable2 callable2 = new MyCallable2();
		MyCallable3 callable3 = new MyCallable3();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		Future<String> future = fixedThreadPool.submit(callable);
		Future<String> future2 = fixedThreadPool.submit(callable2);
		Future<String> future3 = fixedThreadPool.submit(callable3);
		try {
			System.out.println(future.get());
			System.out.println(future2.get());
			System.out.println(future3.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		fixedThreadPool.shutdown();
	}
}
class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"future");
		return "MyCallable";
	}
}
class MyCallable2 implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"future2");
		return "MyCallable2";
	}
}
class MyCallable3 implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"future3");
		return "MyCallable3";
	}
}
