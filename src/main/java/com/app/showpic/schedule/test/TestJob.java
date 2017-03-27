package com.app.showpic.schedule.test;

import org.springframework.stereotype.Service;

import com.app.common.utils.DateUtils;

@Service
public class TestJob{
	
	public void print(){
		System.out.println("TestJob----------->:" + DateUtils.getNowTime());
	}
	
}
