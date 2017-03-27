package com.foundation.queue;

import java.util.concurrent.LinkedBlockingQueue;

import com.app.common.utils.ThreadPoolUtils;

public class BlockingQueueUtil {
	private static LinkedBlockingQueue<String> blockQueue = new LinkedBlockingQueue<String>();
	static{
		ThreadPoolUtils.execute(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						String msg = blockQueue.take();
						System.out.println("-------------"+msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
	}
	public static void setBlockQueue(String msg) {
		try {
			blockQueue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
