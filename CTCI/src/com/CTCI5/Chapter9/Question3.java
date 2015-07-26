package com.CTCI5.Chapter9;

public class Question3 {

	// Method 1  Iterate over the array in O(N)
	
	// Method 2
	// Find magic index with in array with distinct numbers
	// Iterate over the array using binary search O(N)
	public static int magicIndex(int a[], int low, int high) {
		if (low > high || low < 0 || high > a.length) return -1;
		
		int mid = (low + high)/2;
		if (a[mid] == mid) return mid;
		else if (a[mid] < mid)
			return magicIndex(a, mid+1, high);
		else
			return magicIndex(a, low, mid-1);
	}
	
	// Method 2
	public static int magicIndexWithDups(int a[], int low, int high) {
		if (low > high || low < 0 || high > a.length) return -1;
		
		int midIndex = (low + high)/2;
		int midValue = a[midIndex];
		
		if (midValue == midIndex) return midIndex;
		
		// Have to search both ways on both conditions
		
		/* Search left */
		int leftIndex = Math.min(midIndex-1, midValue);
		int left = magicIndexWithDups(a, low, leftIndex);
		if(left >= 0)
			return left;
		
		/* Search right */
		int rightIndex = Math.min(midIndex+1, midValue);
		int right = magicIndexWithDups(a, rightIndex, high);
		
		return right;
	}
	
	public static void main(String[] args) {
		
		int a[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
		int magicIndex = Question3.magicIndex(a, 0, a.length);
		System.out.println("Magical index is : " + magicIndex);
		
		int b[] = {-10,-5,2,2,2,3,4,8,9,12,13};
		magicIndex = Question3.magicIndexWithDups(b, 0, b.length);
		System.out.println("Magical index is : " + magicIndex);
	}
}
