package Leetcode.Google;

import java.util.Arrays;

public class PerfectSquares {
	
	public static int numSquares(int n) {
		
	   int dp[] = new int[n+1];
       Arrays.fill(dp, Integer.MAX_VALUE);
       
       // Putting one in all square places
       for (int i=1; i*i<=n; i++) {
    	   dp[i*i] = 1;
       }
       System.out.println(Arrays.toString(dp));
       for (int i=1; i<=n; i++) {
    	   for (int j=1; i+(j*j)<=n; j++) {
    		   dp[i + ( j*j )] = Math.min(dp[i] + 1, dp[i + (j*j)]);
    	   }
       }
       System.out.println(Arrays.toString(dp));
       
       return dp[n];
	}
	
	public static void main(String[] args) {
		
		//System.out.println(numSquares(13));
		System.out.println(numSquares(5));
	}

}
