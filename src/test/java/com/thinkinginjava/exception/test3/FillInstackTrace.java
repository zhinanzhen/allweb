package com.thinkinginjava.exception.test3;

import com.sun.star.uno.Exception;

/**
 * 重新抛出异常信息
 * @author xxn
 * @date 2016年3月15日  上午10:06:47
 */
public class FillInstackTrace {
	public static void f() throws Exception{
		System.out.println("originating the exception f()");
		throw new Exception("throw f()");
	}
	public static void g() throws Exception{
		try {
			f();
		} catch (Exception e) {
			System.out.println("inside g(),e.printstacktrace");
			e.printStackTrace();
			throw e;
		}
	}
	public static void h() throws Throwable{
		try {
			g();
		} catch (Exception e) {
			System.out.println("inside h(),e.printstacktrace");
			e.printStackTrace();
			throw e.fillInStackTrace();// 异常的新发生地点
		}finally{
			System.out.println("dddddddd");
		}
	}
	public static void main(String[] args) {
		/*try {
			g();
		} catch (Exception e) {
			System.out.println("main:e.printStackTrace");
			e.printStackTrace();
		}*/
		try {
			h();
		} catch (Throwable e) {
			System.out.println("main:e.printstacktrace");
			e.printStackTrace();
		}
	}
}
