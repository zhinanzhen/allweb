package com.foundation.thread.product2consumer;

public class Consumer extends Thread {
	private Storage storage;
	private int num;
	public Consumer(Storage storage,int num) {
		super();
		this.storage = storage;
		this.num = num;
	}
	@Override
	public void run() {
		consum(num);
	}
	public void consum(int num){
		storage.consumer(num);
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
