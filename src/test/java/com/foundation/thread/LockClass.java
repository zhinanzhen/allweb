package com.foundation.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1）Lock不是Java语言内置的，synchronized是Java语言的关键字，因此是内置特性。
 * Lock是一个类，通过这个类可以实现同步访问；
 * 
 * 2）Lock和synchronized有一点非常大的不同，采用synchronized不需要用户去手动释放锁，
 * 当synchronized方法或者synchronized代码块执行完之后，系统会自动让线程释放对锁的占用；
 * 而Lock则必须要用户去手动释放锁，如果没有主动释放锁，就有可能导致出现死锁现象
 * @author xxn
 * @date 2016年5月20日  上午10:01:23
 */
public class LockClass {
	public static void main(String[] args) {
		testLock();
	}
	public static void testLock(){
//		final Lock1 lock = new Lock1();
//		final Lock2 lock = new Lock2();
		final Lock3 lock = new Lock3();
		startThread(lock);
	}
	
	public static void startThread(final Locks lock){
		new Thread(){
			@Override
			public void run() {
				try {
					lock.lock(Thread.currentThread());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				try {
					lock.lock(Thread.currentThread());//此时启动第二个线程，当有其它线程已经获得锁时，第二个线程中断
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
// ----------------------------------
interface Locks{
	void lock(Thread thread) throws InterruptedException;
}
// --------------ReenTrantWriteReadLock--------------------------
class Lock3 implements Locks{
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	@Override
	public void lock(Thread thread) throws InterruptedException {
		lock.readLock().lock();
		try {
			long start = System.currentTimeMillis();
			while(System.currentTimeMillis() - start <= 2){
				System.out.println(thread.getName()+"：正在执行！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(thread.getName()+"：结束-----！");
			lock.readLock().unlock();
		}
	}
	
}
// --------------tryLock--------------------
class Lock1 implements Locks{
	private Lock lock = new ReentrantLock();
	public void lock(Thread thread) throws InterruptedException{
		// 拿不到锁时会等待一定的时间，在时间期限之内如果还拿不到锁，就返回false
		if(lock.tryLock(6, TimeUnit.SECONDS)){
			try {
				System.out.println("开始了-------");
				for(int i= 0 ; i < 5 ; i++){
					Thread.sleep(1000);
					System.out.println("thread:"+Thread.currentThread().getName()+":"+i);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
			System.out.println("结束了----------");
		}else{
			System.out.println("尝试失败------");
		}
	}
}
// -------------------lockInterruptibly----------------------------
class Lock2 implements Locks{
	private Lock lock = new ReentrantLock();
	public void lock(Thread thread) throws InterruptedException{
		lock.lockInterruptibly();
		try {
			System.out.println("开始了-------");
			for(int i= 0 ; i < 5 ; i++){
				Thread.sleep(1000);
				System.out.println("thread:"+Thread.currentThread().getName()+":"+i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		System.out.println("结束了----------");
	}
}
