package com.app.common.utils;

import java.util.Random;

public class TransNoUtils {
	
	public synchronized static String getTransNo(){
		Random random = new Random();
		return DateUtils.getNowTime().concat(String.valueOf(random.nextInt(1000000)));
	}
	
	public static void main(String[] args) {
		System.out.println(TransNoUtils.getTransNo());
	}

}
