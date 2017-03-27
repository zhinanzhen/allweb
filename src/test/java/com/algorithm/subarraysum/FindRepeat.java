package com.algorithm.subarraysum;

import java.util.Arrays;

/**
 * 找出数组中重复次数最多的元素并打印
 * @author xxn
 * @date 2016年2月2日  下午4:16:48
 */
public class FindRepeat {
	public static void main(String[] args) {
		find(new int[]{1,2,4,4,5,6,2,4,5});
	}
	public static void find2(int[] arr){
		for (int i : arr) {
			
		}
	}
	public static void find(int[] arr){
		String str = "#";
		for (int i : arr) {
			str = str +i+"#";
		}
		String string = Arrays.toString(arr);
		int max = 0;
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			int split = str.split("#"+String.valueOf(arr[i])+"#").length;
			if(arr[i] == arr[0]){
				split --;
			}
			if(split > max){
				max = split;
				num = arr[i];
			}
		}
		System.out.println(num + ":" + max);
	}
}
