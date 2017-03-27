package com.foundation.thread;


/**
 * 
 * 并发编程中，我们通常会遇到以下三个问题：原子性问题，可见性问题，有序性问题。
 * 
 * volatile关键字能保证可见性（）没有错，但是上面的程序错在没能保证原子性。
 * 可见性只能保证每次读取的是最新的值，但是volatile没办法保证对变量的操作的原子性
 * 
 * 
 * 1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面；
 * 即在执行到内存屏障这句指令时，在它前面的操作已经全部完成；
 * 2）它会强制将对缓存的修改操作立即写入主存；
 * 3）如果是写操作，它会导致其他CPU中对应的缓存行无效。
 * 
 * 
 * 
 * 
 * @author xxn
 * @date 2016年5月20日  下午5:34:58
 */
public class Volatile {
//	public  AtomicInteger inc = new AtomicInteger(); // 原子操作类
	public volatile int i = 0;
	public void increase(){
		i++;
	}
	public static void main(String[] args) {
		final Volatile v = new Volatile();
		for(int i = 0 ; i < 10 ; i++){
			new Thread(){
				public void run() {
					for(int j = 0 ; j < 1000 ; j++){
						v.increase();
					}
				};
			}.start();
		}
		while(Thread.activeCount() > 1){
			Thread.yield();
		}
		
		System.out.println(v.i);// 小于10000
	}
}
