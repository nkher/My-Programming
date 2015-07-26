package com.CTCI5.Chapter17;

import java.util.Arrays;

public class Question6 {
	
	public static void findUnsortedSequence(int []arr) {
		// find left subseq
		int end_left = findEndOfLeftSubSequence(arr);
		if (end_left > arr.length) return;
		
		// find right sub sequence
		int start_right = findEndOfRightSubSequence(arr);
		
		int max_index = end_left, min_index = start_right;
		System.out.println(max_index + " " + min_index);
		for (int i=end_left+1;i<start_right;i++) {
			if (arr[i] > arr[max_index]) max_index = i;
			if (arr[i] < arr[min_index]) min_index = i;
		}
		System.out.println(max_index + " " + min_index);
		
		
		// slide left and right until
		// 1. left is less than arr[min_index]
		// 2. right is greater than arr[max_index]
		
		int left_index = shrinkLeft(arr, min_index, end_left);
		int right_index = shrinkRight(arr, max_index, start_right);
		
		System.out.println(Arrays.toString(arr));
		
		if (validate(arr, left_index, right_index))
			System.out.println("TRUE: " + left_index + " " + right_index);
		else 
			System.out.println("FALSE: " + left_index + " " + right_index);
	}
	
	public static int shrinkLeft(int a[], int min_index, int end_left) {
		int comp = a[min_index];
		for (int i=end_left-1;i>=0;i--) {
			if (a[i] <= comp)
				return i + 1;
		}
		return 0;
	}
	
	public static int shrinkRight(int a[], int max_index, int start_right) {
		int comp = a[max_index];
		for (int i=start_right;i<a.length;i++) {
			if (comp <= a[i])
				return i-1;
		}
		return 0;
	}
	
	public static int findEndOfLeftSubSequence(int a[]) {
		for (int i=0;i<a.length-2;i++) {
			if (a[i+1] < a[i])
				return i;
		}
		return a.length - 1;
	}
	
	public static int findEndOfRightSubSequence(int a[]) {
		for (int i=a.length-1;i>=0;i--) {
			if (a[i-1] > a[i])
				return i;
		}
		return a.length - 1;
	}
	
	public static boolean validate(int a[], int left_index, int right_index) {
		// get the middle array
		int middle[] = new int[right_index - left_index + 1];
		for (int i=left_index; i<=right_index; i++) {
			middle[i - left_index] = a[i];
		}
		Arrays.sort(middle); // sort the middle array
		// put it back in the original array
		for (int i=left_index; i<=right_index; i++) {
			a[i] = middle[i - left_index];
		}
		
		System.out.println(Arrays.toString(a));
		
		// check the whole array
		for (int i=1;i<a.length;i++) {
			if (a[i] < a[i-1])
				 return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 4, 7, 10, 11, 8, 12, 5, 7, 16, 18, 19};
		findUnsortedSequence(array);
		
	}
}
