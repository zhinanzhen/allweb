package com.foundation.volatiles.syncchronized.producerandconsumer.wait2notify;

import java.util.LinkedList;

/**
 * 
 * wait() / nofity()方法是基类Object的两个方法，也就意味着所有Java类都会拥有这两个方法，这样，
 * 我们就可以为任何对象实现同步机制。
 * wait()方法：当缓冲区已满/空时，生产者/消费者线程停止自己的执行，放弃锁，使自己处于等等状态，让其他线程执行。
 * notify()方法：当生产者/消费者向缓冲区放入/取出一个产品时，向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态。
 * 
 * @author xxn
 * @date 2016年1月27日  下午12:00:36
 */
public class Storage {
	// 仓库最大存储量
	private final int MAX_SIZE = 100;
	// 仓库存储的载体
	private LinkedList<Object> list = new LinkedList<Object>();

	// 生产num个产品
	public void produce(int num) {
		// 同步代码段
		synchronized (list) {
			// 如果仓库剩余容量不足
			while (list.size() + num > MAX_SIZE) {
				System.out.println(Thread.currentThread().getName()+":     "+"【要生产的产品数量】:" + num + "/t【库存量】:"
						+ list.size() + "/t暂时不能执行生产任务!");
				try {
					// 由于条件不满足，生产阻塞
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 生产条件满足情况下，生产num个产品
			for (int i = 1; i <= num; ++i) {
				list.add(new Object());
			}
			System.out.println(Thread.currentThread().getName()+":     "+"【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());
			list.notifyAll();
		}
	}

	// 消费num个产品
	public void consume(int num) {
		// 同步代码段
		synchronized (list) {
			// 如果仓库存储量不足
			while (list.size() < num) {
				System.out.println(Thread.currentThread().getName()+":     "+"【要消费的产品数量】:" + num + "/t【库存量】:"
						+ list.size() + "/t暂时不能执行生产任务!");
				try {
					// 由于条件不满足，消费阻塞
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 消费条件满足情况下，消费num个产品
			for (int i = 1; i <= num; ++i) {
				list.remove();
			}

			System.out.println(Thread.currentThread().getName()+":     "+"【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());

			list.notifyAll();
		}
	}

	// get/set方法
	public LinkedList<Object> getList() {
		return list;
	}

	public void setList(LinkedList<Object> list) {
		this.list = list;
	}

	public int getMAX_SIZE() {
		return MAX_SIZE;
	}
}
