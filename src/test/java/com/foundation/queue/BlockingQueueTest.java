package com.foundation.queue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		for ( int i=0;i<100;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					BlockingQueueUtil.setBlockQueue("www");
				}
			}).start();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				BlockingQueueUtil.setBlockQueue("----  end  --------");
			}
		}).start();
	}
}
