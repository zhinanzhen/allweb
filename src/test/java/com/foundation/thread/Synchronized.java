package com.foundation.thread;

import java.util.ArrayList;

public class Synchronized {
	public static void main(String[] args) {
		testSync();
//		testSync2();
	}
	
	public static void testSync2(){
		final InsertData2 id = new InsertData2();
		new Thread(){
			@Override
			public void run() {
				id.insert(Thread.currentThread());
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				InsertData2.insert2(Thread.currentThread());
			}
		}.start();
	}
	
	public static void testSync(){
		final InsertData id = new InsertData();
		//如果一个线程A需要访问对象object1的synchronized方法fun1，
		//另外一个线程B需要访问对象object2的synchronized方法fun1，
		//即使object1和object2是同一类型），也不会产生线程安全问题，因为他们访问的是不同的对象，所以不存在互斥问题
		final InsertData id2 = new InsertData();//
		new Thread(){
			@Override
			public void run() {
				id.insert(Thread.currentThread());
			}
		}.start();
		
		/*new Thread(){
			@Override
			public void run() {
				id2.insert(Thread.currentThread());
			}
		}.start();*/
		
		new Thread(){
			@Override
			public void run() {
				id.insert(Thread.currentThread());
			}
		}.start();
	}
}


class InsertData{
	private ArrayList<Integer> list = new ArrayList<Integer>();
	public synchronized void insert(Thread thread){
		for (int i = 0; i < 15; i++) {
			System.out.println(thread.getName()+":"+i);
			list.add(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 访问static synchronized方法占用的是类锁，而访问非static synchronized方法占用的是对象锁，所以不存在互斥现象
 * @author xxn
 * @date 2016年5月19日  下午4:33:30
 */
class InsertData2{
	private ArrayList<Integer> list = new ArrayList<Integer>();
//	private Object obj = new Object();
	public void insert(Thread thread){
//		synchronized (obj) {
		synchronized (this) {
			for (int i = 0; i < 15; i++) {
				System.out.println(thread.getName()+":"+i);
				list.add(i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static synchronized void insert2(Thread thread){
		for (int i = 0; i < 15; i++) {
			System.out.println(thread.getName()+":"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
