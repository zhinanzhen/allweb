package com.foundation.listener.source;

public class SecondEventListener implements DemoEventListener {

	@Override
	public void processEvent(DemoEvent demoEvent) {
		System.out.println("Second event listener process event...");  
	}

}
