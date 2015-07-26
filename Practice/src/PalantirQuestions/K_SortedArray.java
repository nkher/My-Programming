package PalantirQuestions;

import java.util.Arrays;

public class K_SortedArray {
	
	// Method 1. Modification of insertion sort
	// Time Complexity is O(nk)
	public static void insertionSort(int a[], int k) {
		int i, key, j;
		for (i = 1; i<a.length; i++) {
			key = a[i];
			j = i-1;
			
			// Move elements of A[0 .. i-1], that are greater than key, to one
			// position ahead of their current position.
			// This loop will run at most 'k' times
			while ( j >= j-k && a[j] > key ) {
				a[j+1] = a[j];
				j = j-1;
			}
			a[j+1] = key; // put the key in the right position
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 6, 3, 12, 56, 8, 9};
		System.out.println(Arrays.toString(arr));
		K_SortedArray.insertionSort(arr, 3);
		System.out.println(Arrays.toString(arr));
	}
}
