package AmazonQuestions;

import java.util.Arrays;

// Quick Select Algorithm
public class MedianUnsortedArray {
	
	private int A[];
	
	public MedianUnsortedArray(int size) {
		this.A = new int[size];
	}
	
	public int randomizedPartition(int low, int high) {
		int pIndex = low;
		int pivot = A[high];
		for(int i=low;i<=high-1;i++) {
			if(A[i] < pivot) {
				int temp = A[i];
				A[i] = A[pIndex];
				A[pIndex] = temp;
				pIndex++; // Increment the pIndex
			}
		}
		// Swap the pivot with pIndex 
		int temp = A[high];
		A[high] = A[pIndex];
		A[pIndex] = temp;
		return pIndex;
	}
	
	public int randomizedSelect(int left, int right, int kth) {
		for(;;) {
			int pivotIndex = randomizedPartition(left, right);
			int actualPivotI = pivotIndex-left+1;
			if(kth == actualPivotI)
				return A[pivotIndex-1];
			else if(kth < actualPivotI)
				right = pivotIndex-1;
			else {
				kth = kth-pivotIndex;
				left = pivotIndex+1;
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = {7,3,1,4,6,2,5}; // 1 2 3 4 5 6 7
		MedianUnsortedArray mua = new MedianUnsortedArray(a.length);
		int len, i;
		len = a.length;
		for (i=0;i<len;i++) {
			mua.A[i] = a[i];
		}
		Arrays.toString(mua.A);
		int median = mua.randomizedSelect(0, len-1, len/2);
		System.out.println("Median is " + median);
	} // 0 1 2 3 4 12 32 76 344 654 
}
