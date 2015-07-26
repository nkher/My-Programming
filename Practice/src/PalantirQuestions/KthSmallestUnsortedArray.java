package PalantirQuestions;

import java.util.Arrays;

public class KthSmallestUnsortedArray {
	
	// Worst Case - O(N^2)
	// Average Case - O(N)
	public int kthSmallest(int a[], int left, int right, int k) {
			
		if (k > 0 && k <= right-left+1) {
			int pivotIndex = partition(a, left, right); // partition on last element
			
			// if the position is same as k then return
			if (pivotIndex-left == k-1) return pivotIndex;
			if (pivotIndex-left > k-1) 
				return kthSmallest(a, left, pivotIndex-1, k); // left sub array
			return kthSmallest(a, pivotIndex+1, right, (k-pivotIndex+1-left)); // if recursing in right sub array then k will change
		}
		return Integer.MAX_VALUE;
	}
	
	public int partition(int a[], int left, int right) {
		int pivot = a[right], i = left;
		for (int j=left;j<=right-1;j++) {
			if (a[j] <= pivot) {
				// swap a[i] and a[j], then increment i
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		// we get the pivot position, swap the last element with the element in the pivot position
		int temp = a[right];
		a[right] = a[i];
		a[i] = temp;
		return i;
	}
	
	public static void main(String[] args) {
		int a[] = {12, 3, 5, 7, 4, 19, 26};
		Arrays.sort(a);
		int len = a.length;
		System.out.println(Arrays.toString(a));
		System.out.println();
		KthSmallestUnsortedArray obj = new KthSmallestUnsortedArray();
		int result = obj.kthSmallest(a, 0, a.length-1, 3);
		System.out.println(a[result]);
		
		System.out.println("Median is : ");
		if ((len&1) == 0) {
			int n1 = obj.kthSmallest(a, 0, len, len/2);
			int n2= obj.kthSmallest(a, 0, len, (len/2)-1);
			System.out.println( (a[n1] +a[n2])/2 );
		}
		else
			System.out.println(a[obj.kthSmallest(a, 0, len, len/2)]);
	}

}
