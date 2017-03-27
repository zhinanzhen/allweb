package com.algorithm.subarraysum;

/**
 * 求1+2+…+n， 要求不能使用乘除法、for、while、if、else、switch、case等关键字以及条件判断语句（A?B:C）。
 * @author xxn
 * @date 2016年2月2日  下午2:40:30
 */
public class SumByArgu {

	public static void main(String[] args) {
		int a = sumNum(50);
		System.out.println(a);
	}
	
	public static int sumNum(int x){
		if(x > 0){
			x --;
			return sumNum(x) + x;
		}
		return 0;
	}

}
