package com.foundation.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	public static void main(String[] args) {
//		newFixedThreadPool();
//		newSingleThreadExecutor();
//		newCachedThreadPool();
		newScheduledThreadPool();
	}
	
	private static void newScheduledThreadPool(){
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
		Runnable t1 = new MyThread();  
		Runnable t2 = new MyThread();  
		Runnable t3 = new MyThread();  
		scheduledThreadPool.execute(t1);
		
		scheduledThreadPool.schedule(t2, 1000, TimeUnit.MILLISECONDS);
		scheduledThreadPool.schedule(t3, 500, TimeUnit.MILLISECONDS);
		scheduledThreadPool.shutdown();
	}
	
	/**
	 * 可变尺寸的线程池
	 */
	private static void newCachedThreadPool(){
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.shutdown();
	}
	/**
	 * 单任务线程池
	 */
	private static void newSingleThreadExecutor(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.shutdown();
	}
	
	/**
	 * 固定大小的线程池
	 */
	private static void newFixedThreadPool(){
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.execute(new MyThread());
		executorService.shutdown();
	}
}
class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"………………");
	}
	
}