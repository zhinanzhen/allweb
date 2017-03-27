package com.foundation.thread;

/**
 * sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象
 * @author xxn
 * @date 2016年5月17日  下午2:08:27
 */
public class SleepAndSync {
	private int i = 10;
	private Object obj = new Object();
	public static void main(String[] args) {
		SleepAndSync ts = new SleepAndSync();
		MyTask task = ts.new MyTask();
		MyTask task2 = ts.new MyTask();
		task.start();
		task2.start();
		System.out.println("-------------over---------");
		
	}
	class MyTask extends Thread{
		@Override
		public void run() {
			synchronized (obj) {
				i++;
				System.out.println("i: "+i);
				try {
					System.out.println("线程："+Thread.currentThread().getName()+"进入睡眠");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程："+Thread.currentThread().getName()+"睡眠结束");
			}
		}
	}
}
