package com.foundation.volatiles;

/**
 * java 内存模型
 * volatile 只能保证从主内存到工作内存的值是最新的，但是并不能防止并发的发生
 * @author xxn
 * @date 2016年1月7日  上午10:34:09
 */
public class Counter {
	private volatile static int count = 0;
	private static void inc(){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					inc();
				}
			}).start();
		}
		System.out.println(count);
	}
}
