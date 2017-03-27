package com.foundation.gc;

public class GarbageTest {
	public Object instance = null;
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("00000000000000");
	}
	public static void main(String[] args) throws InterruptedException {
		GarbageTest an1 = new GarbageTest();
		GarbageTest an2 = new GarbageTest();
		an1.instance = an2;
		an2.instance = an1;
		
		an1 = null;
		an2 = null;
		
		System.gc();
		//finalize优先级低延迟0.5秒执行
		Thread.sleep(500);
	}
}
