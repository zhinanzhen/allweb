package com.app.quartz.job;

import org.springframework.stereotype.Service;

import com.app.common.utils.ThreadPoolUtils;

@Service
public class Qt1 {
	public void qt1(){
		System.out.println("----------qt1w----------------");
		ThreadPoolUtils.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("=================qt1w--start================");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("=================qt1w--end================");
			}
		});
	}
}
