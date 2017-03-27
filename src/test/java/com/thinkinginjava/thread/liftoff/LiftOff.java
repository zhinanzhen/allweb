package com.thinkinginjava.thread.liftoff;

public class LiftOff implements Runnable {
	private int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff(){
	}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	private String status(){
		return "#" + id +"("+(countDown > 0 ? countDown :"LiftOff")+")";
	}
	@Override
	public void run() {
		while(countDown-- >0){
			System.out.println(status());
			//线程调度器。让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
			//因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
			//但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中
//			Thread.yield();
		}
	}
}
