package com.foundation.thread;
public class Test {
	public static void main(String[] args) {
		final DualSynch ds = new DualSynch();
		new Thread() {
			public void run() {
				ds.f(1);
			}
		}.start();
		new Thread(){
			public void run() {
				ds.f2(2);
			}
		}.start();
	}
}
class DualSynch{
	public void f(int flag) {
		synchronized (this) {
			System.out.println("f()" + flag);
			try {
//				Thread.sleep(1000);
				this.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("f………………");
		}
	}

	public void f2(int flag) {
		synchronized (this) {
			System.out.println("f2()开始" + flag);
			try {
				Thread.sleep(2000);
//				this.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("f2()结束" + flag);
		}
	}
}
