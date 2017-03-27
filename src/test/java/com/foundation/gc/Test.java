package com.foundation.gc;

public class Test {
	String str;
	public String toString(){
		return str;
	}
	
	public Test(String str) {
		super();
		this.str = str;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("我是"+str+".我被回收了..");
	}
	public static void main(String[] args) {
		Test a=new Test("李四");
		a=null;
		System.gc();   //运行结果 我是李四.我被回收了..
	}
}
