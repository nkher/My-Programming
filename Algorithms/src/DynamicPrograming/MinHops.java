package DynamicPrograming;

import java.util.Arrays;

public class MinHops {
	
	// Note there are two variations to this question. One is in the EFI book where you just need to check whether 
	// you can reach the end or not and not print the whole path/jumps sequence. This takes time of O(N) and space of O(1)
	// Question is in 6th chapter, question number 4
	
	// This question is not to return true or false but to actually print out the minimum number of jumps to reach the end
	
	
	/* DP solution in O(N^2) time and O(N) space */
	
	public static int minHops(int a[], int result[]) {
		
		int n = a.length;
		int hops[] = new int[n];
		
		for (int i=1;i<n;i++)
			hops[i] = Integer.MAX_VALUE;
		
		// For each i from 1 to n check if it is reachable by j from 0 to i
		// and simultaneously update the hops array
		for (int i=1;i<n;i++) {
			for (int j=0;j<i;j++) {
				if ( j+a[j] >= i ) { // checking if reachable
					int minhopsToi = hops[j] + 1;
					if (minhopsToi < hops[i]) {
						hops[i] = minhopsToi;
						result[i] = j; // This will store the actual index from where you would be jumping
					}
				}
			}
		}
		return hops[n-1];
	}
	
	// TC = O(n)
	public static int minHopsOptimized(int a[]) {
		
		int n = a.length;
		if (n == 0 || n == 1) return 0;
		int m = 0, i = 0, nJumps = 0;
		
		while (i < n) {
			
			m = Math.max(m, a[i] + i);
			if (m > 0) { // means we have made  a jump
				nJumps++;
			}
			if (m >= n-1) { // check if we have reached the end
				return nJumps;
			}
			int tmp = 0;
			for (int j=i+1; j<=m; j++) { // from current i to m
				if (j + a[j] > tmp) {
					tmp = j + a[j];
					i = j;
				}
			}
		}
		
		return nJumps;
	}
	
	
	public static void main(String[] args) {
		int b[] = {2,3,1,1,2,4,2,0,1,1};
		int a[] = {1,3,5,3,2,2,6,1,6,8,9};
		int result[] = new int[a.length];
		System.out.println(MinHops.minHops(b, result));
		System.out.println("Actual jumps array : " + Arrays.toString(result));
	}

}
