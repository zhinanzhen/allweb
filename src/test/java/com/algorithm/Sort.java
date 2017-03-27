package com.algorithm;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int [] a = new int[]{4,6,1,6,7,2,23,45,5};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	public static void sort(int[] a){
		for (int i=0;i<a.length;i++) {
			for(int j = i+1;j<a.length;j++){
				if(a[j] > a[i]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					System.out.println(Arrays.toString(a));
				}
			}
			System.out.println("第"+ i + "次：" + Arrays.toString(a));
		}
	}
}
