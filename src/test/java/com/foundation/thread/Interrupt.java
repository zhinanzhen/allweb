package com.foundation.thread;

/**
 * 守护线程依赖于创建它的线程，而用户线程则不依赖。
 * 举个简单的例子：如果在main线程中创建了一个守护线程，当main方法运行完毕之后，守护线程也会随着消亡。
 * 而用户线程则不会，用户线程会一直运行直到其运行完毕
 * @author xxn
 * @date 2016年5月17日  下午7:04:46
 */
public class Interrupt {
	public static void main(String[] args) {
//		testMytask();
		testMyTask2();
//		testMyTask3();

	}
	@SuppressWarnings("static-access")
	private static void testMyTask3(){
		Interrupt interrupt = new Interrupt();
		MyTask3 myTask = interrupt.new MyTask3();
		myTask.start();
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myTask.interrupt();
		myTask.setStop(true);// 设置中断标志
	}
	@SuppressWarnings("static-access")
	private static void testMyTask2(){
		Interrupt interrupt = new Interrupt();
		MyTask2 myTask = interrupt.new MyTask2();
		myTask.start();
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myTask.interrupt();
	}
	@SuppressWarnings("static-access")
	private static void testMytask(){
		Interrupt interrupt = new Interrupt();
		MyTask myTask = interrupt.new MyTask();
		Thread thread = new Thread(myTask);
		thread.start();
		try {
			Thread.currentThread().sleep(5000);//睡5秒后中断线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();//中断线程
		System.out.println("----interrupt-----");
	}
	class MyTask implements Runnable {
		@SuppressWarnings("static-access")
		@Override
		public void run() {
			System.out.println("进入睡眠状态");
			try {
				Thread.currentThread().sleep(1000000);// 一直沉睡
			} catch (InterruptedException e) {
				System.out.println("------e-----");
				e.printStackTrace();
			}
			System.out.println("睡眠完毕");
			System.out.println("run方法执行完毕");
		}
	}
	class MyTask2 extends Thread {
		@Override
		public void run() {
			int i = 0;
			System.out.println("开始");
			// 判断是否中断线程
			while(!isInterrupted() && i < Integer.MAX_VALUE){
				System.out.println(i++);
			}
			System.out.println("结束");
		}
	}
	class MyTask3 extends Thread{
		private volatile boolean isStop = false;
		@Override
		public void run() {
			int i = 0;
			while(!isStop){
				System.out.println(i);
			}
			System.out.println("----stop-----");
		}
		public void setStop(boolean stop){
            this.isStop = stop;
        }
	}
}
