package com.foundation.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
	public static void main(String[] args) {
//		testCurrModiExcept();
//		testCurrModiExcept2();
//		Collections.synchronizedMap(null);
		ConcurrentHashMap m ;
//		Hashtable t;
		testHashMap();
	}
	
	/**
	 * 多线程环境下，使用Hashmap进行put操作会引起死循环，导致CPU利用率接近100%，所以在并发情况下不能使用HashMap。
	 */
	private static void testHashMap(){
		final HashMap<String, String> map = new HashMap<String, String>(2);
		new Thread(new Runnable(){
			public void run() {
				for (int i = 0 ; i < 10000 ; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					},"123"+i).start();
				}
			};
		},"123").start();
	}
	
	private static void testCurrModiExcept2(){
		final CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		new Thread(){
			@Override
			public void run() {
				Iterator<Integer> it = list.iterator();
				System.out.println("///////////////");
				while(it.hasNext()){
//					System.out.println(it.next());
					Integer next = it.next();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread(){
			public void run() {
				Iterator<Integer> it = list.iterator();
				while(it.hasNext()){
					Integer next = it.next();
					if(next == 2){
						list.remove(next);
					}
				}
			};
		}.start();
		
		System.out.println("-----------------3------------");
		System.out.println(Thread.activeCount());
		System.out.println("----------------3-------------");
		while(Thread.activeCount() > 1){
			System.out.println("++++++++++");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("-----------------------------");
		System.out.println(Thread.activeCount());
	}
	
	private static void testCurrModiExcept(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			Integer next = it.next();
			if(next == 12){
//				list.remove(next);  //抛出异常 ConcurrentModificationException
				it.remove();
			}
		}
	}
}
