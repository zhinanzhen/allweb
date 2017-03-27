package com.foundation.thread.product2consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPC {
	public static void main(String[] args) {
		StorageSingle storage = new StorageSingle();
		List<Consumer> listC = new ArrayList<Consumer>();
		List<Productor> listP = new ArrayList<Productor>();
		for(int i = 0 ; i < 10 ; i++){
			listP.add(new Productor(storage,i));
		}
		listC.add(new Consumer(storage,30));
		listC.add(new Consumer(storage,10));
		listC.add(new Consumer(storage,3));
		listC.add(new Consumer(storage,5));
		listC.add(new Consumer(storage,90));
		
		for(int i = 0 ; i < 10 ; i++){
			listP.get(i).start();
		}
		listC.get(0).start();
		listC.get(1).start();
		listC.get(2).start();
		listC.get(3).start();
		listC.get(4).start();
		
		ExecutorService service = Executors.newCachedThreadPool();
	}
}
