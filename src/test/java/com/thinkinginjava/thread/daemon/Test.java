package com.thinkinginjava.thread.daemon;

/**
 * 如果我们把 thread.setDaemon(true);删除，那么就可以打印出数字了。
 * 这就是守护线程，守护着最后一个用户线程，如果没有用户线程了，他也没作用了
 * 
 * @author xxn
 * @date 2016年1月28日 下午1:30:04
 */
public class Test {
	public static void main(String[] args) {
		Thread daemonThread = new Thread(new ThreadDemo());
		daemonThread.setName("测试");
		// daemonThread.setDaemon(true);
		daemonThread.start();
		System.out.println("isDeamon = " + daemonThread.isDaemon());
		/*
		 * Thread th = new Thread(new ThreadDemo()); th.start();
		 */
	}
}
