package com.foundation.thread.product2consumer;

import java.util.LinkedList;

public class StorageSync implements Storage{
	private final int MAX_SIZE = 100;
	private LinkedList<Object> list = new LinkedList<Object>();
	public void product(int num){
		synchronized (list) {
			while(list.size() + num > MAX_SIZE){
				System.out.println(Thread.currentThread().getName()+" : 【要生产的产品数量】:" + num + "   【库存量】:"  
                        + list.size() + "  暂时不能执行生产任务!");
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i = 1; i < num ; i++){
				list.add(new Object());
			}
			 System.out.println(Thread.currentThread().getId()+" : 【已经生产产品数】:" + num + "   【现仓储量为】:" + list.size());
			 list.notifyAll();
		}
	}
	
	public void consumer(int num){
		synchronized(list){
			while(list.size() < num){
				System.out.println(Thread.currentThread().getId()+" : 【要消费的产品数量】:" + num + "  【库存量】:"  
                        + list.size() + "  暂时不能执行生产任务!");
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < num; i++) {
				list.remove();
			}
			System.out.println(Thread.currentThread().getId()+" : 【已经消费产品数】:" + num + "  【现仓储量为】:" + list.size());  
			list.notifyAll();
		}
	}
}
