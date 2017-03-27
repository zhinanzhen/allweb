package com.thinkinginjava.thread.liftoff;

public class _1_MainThread {
	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			new Thread(new LiftOff()).start();
			System.out.println("thread 之后的输出语句！");
		}
	}
}
