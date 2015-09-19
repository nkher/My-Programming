package org.DynamicPrograming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	// Time complexity is O(N ^ 2)
	public int LIS(int array[], int size) {
		
		int i, j, max = 0;
		int lis[] = new int[array.length];
		
		// Initializing the LIS array
		for (i=0;i<lis.length;i++) 
			lis[i] = 1;
		
		// Computing LIS array values in bottom up manner
		for (i=1;i<size;i++) {
			for(j=0;j<i;j++) {
				if((array[i] > array[j]) &&
					(lis[i] < lis[j] + 1)) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		System.out.println(Arrays.toString(lis));
		
		// Now getting the max LIS value for returning 
		for (i=0; i<size; i++) {
			if(max < lis[i])
				max = lis[i];
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		LongestIncreasingSubsequence lis =  new LongestIncreasingSubsequence();
		int array[] = {34, 22, 9, 10, 33, 21, 50, 41, 60};
					// 1   1   1   2   3   3   4   4   5
		int retVal = lis.LIS(array, array.length);
		System.out.print("Maximum sub sequence in the given array [ ");
		for(int i=0;i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("] is : " + retVal);
	}
}
