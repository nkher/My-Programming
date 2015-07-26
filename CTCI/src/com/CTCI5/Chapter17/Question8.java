package com.CTCI5.Chapter17;

public class Question8 {
	
	public static int getMaxSum(int a[]) {
		int runningSum = 0, maxSum = 0;
		for (int i=0;i<a.length;i++) {
			runningSum += a[i];
			if (maxSum < runningSum) {
				maxSum = runningSum;
			}
			else if (runningSum < 0) {
				runningSum = 0;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] a = {2, -8, 3, -2, 4, -10};
		System.out.println(getMaxSum(a));
	}
}
