package com.foundation.listener.source;

import java.util.EventListener;

public interface DemoEventListener extends EventListener{
	public void processEvent(DemoEvent demoEvent); 
}
