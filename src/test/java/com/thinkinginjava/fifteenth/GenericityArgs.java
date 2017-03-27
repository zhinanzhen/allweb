package com.thinkinginjava.fifteenth;

import java.util.ArrayList;
import java.util.List;

public class GenericityArgs {
	public static <T> List<T> asList(T ... ts){
		List<T> list = new ArrayList<T>();
		for (T t : ts) {
			list.add(t);
		}
		return list;
	}
	public static void main(String[] args) {
		List<String> asList = asList("1","we","rr","tt");
		for (String str : asList) {
			System.out.println(str);
		}
	}
}
