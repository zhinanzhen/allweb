package com.foundation.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {
	public static ExecutorService exceutor;
	static{
		// 最小线程10，最大100，任务队列20，空闲缓冲3秒
		exceutor = new ThreadPoolExecutor(10, 100, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20), new ThreadPoolExecutor.DiscardOldestPolicy());
	}
	
	public static void main(String[] args) {
		System.out.println("11111111111111111");
		 exceutor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("9999");
				try {
					Thread.sleep(1*5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("9999");
			}
		});
		System.out.println("11111111111111111");
	}
}
