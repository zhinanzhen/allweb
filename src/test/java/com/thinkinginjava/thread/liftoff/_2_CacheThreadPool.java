package com.thinkinginjava.thread.liftoff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _2_CacheThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 1; i < 4; i++) {
			exec.execute(new LiftOff());
			System.out.println("thread 之后的输出语句！");
		}
		exec.shutdown();
	}
}
