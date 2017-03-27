package com.foundation.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueTest {
	public static void main(String []args) {
		BlockingQueue q = new SynchronousQueue();
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}

class Producer implements Runnable {
	private final BlockingQueue queue;

	Producer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				queue.put(produce());
			}
		} catch (InterruptedException ex) {
			System.out.println();
		}
	}

	Object produce() {
		System.out.println("Producer:==>" );
		return new A();
	}
}

class Consumer implements Runnable {
	private final BlockingQueue queue;

	Consumer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				consume(queue.take());
			}
		} catch (InterruptedException ex) {
			System.out.println("Consumer ex");
		}
	}

	void consume(Object x) {
		System.out.println("Consumer:===>" + x);
	}
}

class A {
}
