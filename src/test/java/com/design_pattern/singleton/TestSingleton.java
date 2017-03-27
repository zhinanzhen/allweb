package com.design_pattern.singleton;

public class TestSingleton implements Runnable{
	private String str;
	public TestSingleton(String str) {
		this.str = str;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			System.out.println(str+" : " + Singleton.getSingleton());
		}
	}
	
	public static void main(String[] args) {
			TestSingleton tst = new TestSingleton("Number-1");
			new Thread(tst).start();
			
			new Thread(tst).start();
	}
}
