package com.app.common.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 线程池工具类
 * @author wangjinping
 *
 */
public class ThreadPoolUtils {
	
	public static ExecutorService exceutor;
	static{
		// 最小线程10，最大100，任务队列20，空闲缓冲3秒
		exceutor = new ThreadPoolExecutor(10, 100, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20), new ThreadPoolExecutor.DiscardOldestPolicy());
	}
	
	public static void execute(Runnable thread){
		exceutor.execute(thread);
	};
}


