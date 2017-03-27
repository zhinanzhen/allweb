package com.thinkinginjava.thread.daemon;

/**
 * Java有两种Thread：“守护线程Daemon”与“用户线程User”。
 * 
 * 守护线程与普通线程的唯一区别是：
 * 理解一 : 守护线程就是main同生共死，当main退出，它将终止，而普通线程是在任务执行结束才停止。 
 * 理解二： 用户线程：Java虚拟机在它所有非守护线程已经离开后自动离开。守护线程则是用来服务用户线程的，
 * 如果没有其他用户线程在运行，那么就没有可服务对象，也就没有理由继续下去。
 * 
 * 例如：我们所熟悉的Java垃圾回收线程就是一个典型的守护线程，当我们的程序中不再有任何运行中的Thread，
 * 程序就不会再产生垃圾，垃圾回收器也就无事可做，所以当垃圾回收线程是Java虚拟机上仅剩的线程时，Java虚拟机会自动离开。
 * 
 * 
 * 当你在一个守护线程中产生了其他线程，那么这些新产生的线程不用设置Daemon属性，都将是守护线程，用户线程同样。
 * 
 * 
 * @author xxn
 * @date 2016年1月28日 下午1:25:35
 */
public class ThreadDemo implements Runnable {

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
