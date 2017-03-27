package com.algorithm.subarraysum;

/**
 * 求最大和
 * @author xxn
 * @date 2016年2月2日  下午2:41:37
 */
public class SubArraySum {
	public static void main(String[] args) {
		int arr[] = new int[]{1,-2,1,-3,4,-5,-6,14};
		System.out.println(findMaxSum(arr));
	}
	public static int findMaxSum(int arr[]){
		int maxSum = 0;
		int currSum = 0;
		for (int i=0;i<arr.length;i++) {
			currSum += arr[i];
			if(currSum < 0) {
				currSum = 0; 
			}
			if(maxSum < currSum){
				maxSum = currSum;
			}
		}
		if(maxSum == 0){
			for (int i : arr) {
				if(maxSum < i){
					maxSum = i;
				}
			}
		}
		return maxSum;
	}
}
