package com.foundation.thread.product2consumer;

public class Productor extends Thread{
	private Storage storage;
	private int num;
	public Productor(Storage storage , int num) {
		super();
		this.storage = storage;
		this.num = num;
	}
	@Override
	public void run() {
		product(num);
	}
	public void product(int num){
		storage.product(num);
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
