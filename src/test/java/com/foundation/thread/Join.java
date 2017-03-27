package com.foundation.thread;

/**
 * 等待线程执行完毕之后进行主线程
 * @author xxn
 * @date 2016年5月27日  下午12:01:34
 */
public class Join {
	public static void main(String[] args) {
		System.out.println("进入线程"+Thread.currentThread().getName());
		Join join = new Join();
		MyTask myTask = join.new MyTask();
		Thread thread = new Thread(myTask);
		thread.start();
		try {
			System.out.println("线程"+Thread.currentThread().getName()+"等待");
			thread.join();//等待thread线程执行完毕或者等待一定的时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程"+Thread.currentThread().getName()+"继续");
	}
	class MyTask implements Runnable{
		@Override
		public void run() {
			System.out.println("线程："+Thread.currentThread().getName()+"进入睡眠");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程："+Thread.currentThread().getName()+"睡眠结束");
		}
	}
}
