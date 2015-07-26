package com.CTCI5.Chapter17;

import java.util.Arrays;

public class Question12 {

	public static void printPairSums(int a[], int sum) {
		Arrays.sort(a);
		int left = 0, right = a.length-1;
		int current_sum;
		while (left < right) {
			current_sum = a[left] + a[right];
			if (current_sum == sum) {
				System.out.println("(" + a[left] + ", " + a[right] + ")");
				left++;
				right--;
			}
			else {
				if (current_sum < sum)
					left++;
				else if (current_sum > sum)
					right--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] test = {9, 3, 6, 5, 7, -1, 13, 14, -2, 12, 0};
		printPairSums(test, 12);
	}

}
