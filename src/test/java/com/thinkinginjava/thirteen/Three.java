package com.thinkinginjava.thirteen;

import java.util.ArrayList;
import java.util.List;

public class Three {
	public String toString(){
		return "thredd address :" + super.toString();
	}
	
	public static void main(String[] args) {
		List<Three> list = new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add(new Three());
		}
		System.out.println("----------------");
		System.out.println(list);
	}
	
}
