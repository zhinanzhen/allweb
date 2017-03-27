package com.foundation.volatiles.syncchronized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SyncTest implements Runnable{
	private List<Map<Integer,Integer>> lMap = new ArrayList<>();
	public static void main(String[] args) {
		Object obj = new Object();
		SyncTest sy = new SyncTest();
		for (int i = 0; i < 2; i++) {
			Thread th = new Thread(sy);
			th.start();
		}
	}

	@Override
	public void run() {
		try {
			 for (int i = 0; i < 5; i++) {  
				 Map<Integer,Integer> map = new HashMap<Integer, Integer>();
				 map.put(i, i);
				 lMap.add(map);
				 System.out.println(Thread.currentThread().getName()+":"+i+"   :====10200200202");
				 Thread.sleep(1000);
			 }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
