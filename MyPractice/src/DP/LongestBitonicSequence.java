package DP;

import java.util.Arrays;

public class LongestBitonicSequence {
	
	public int longestBitonicSequence(int list[]) {
		
		int n = list.length;
		int lisLR[] = new int[n];
		int lisRL[] = new int[n];
		
		lisLR = fillLIS_LR(lisLR, list);
		lisRL = fillLIS_RL(lisRL, list);
		
		/* Add both the arrays at same indices and -1 to get the bitonic array 
		 * Return the max value from the array 
		 */
		
		int result[] = new int[n];
		for (int i=0;i<n;i++) {
			result[i] = lisLR[i] + lisRL[i] - 1;
		}
		
		int maxBitonicSeqLen = 0;
		for (int i=0;i<n;i++) {
			if (maxBitonicSeqLen < result[i])
				maxBitonicSeqLen = result[i];
		}
		
		return maxBitonicSeqLen;
	}
	
	/* Creates the lis array from left to right */
	public int[] fillLIS_LR(int lis[], int list[]) {
		
		initialize(lis);
		
		for (int i=1;i<list.length;i++) {
			for (int j=0;j<i;j++) {
				if (list[i] > list[j] && (lis[i] < lis[j] + 1)) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(lis));
		return lis;
	}
	
	/* Creates the lis array from right to left */
	public int[] fillLIS_RL(int lis[], int list[]) {
		
		initialize(lis);
		
		for (int i=list.length-2;i>=0;i--) {
			for (int j=list.length-1;j>i;j--) {
				if (list[i] > list[j] && (lis[i] < lis[j] + 1)) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(lis));
		return lis;
	}
	
	public void initialize(int a[]) {
		// Initialize the array
		for (int i=0;i<a.length;i++) {
			a[i] = 1;
		}
	}
	
	public static void main(String[] args) {
		LongestBitonicSequence lbs = new LongestBitonicSequence();
		// int list[] = {1,4,3,7,2,1,8,11,13,0};
		int list[] = {2,-1,4,3,5,-1,3,2};
		System.out.println(lbs.longestBitonicSequence(list));
	}
}
