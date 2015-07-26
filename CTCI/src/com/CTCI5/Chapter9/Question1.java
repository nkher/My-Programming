package com.CTCI5.Chapter9;

public class Question1 {
// Count number of ways to cover 9 steps with hops of 1, 2 and 3
	
	
	// Explanation - at the last hop the boy can either do a single, double or triple hop
	// which would be from step n-1, n-2 and n-3 respectively. In turn the number of ways 
	// of reaching the last step is the sum of the number of ways of reaching each of the three last steps
	// Method 1 - Recursion -> O(3 ^ n)
	public static int countWays(int n) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		else 
			return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
	
	// Method 2 - Dynamic Programming -> O(N)
	public static int countWaysEfficient(int n, int map[]) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		else if (map[n] > 0)
			return map[n];
		else {
			map[n] =  countWaysEfficient(n-1, map) + 
					  countWaysEfficient(n-2, map) + 
					  countWaysEfficient(n-3, map);
			return map[n];
		}
	}
	
	
	public static void main(String args[]) {
		int steps = 9;
		int ways = Question1.countWays(steps);
		System.out.println("Number of ways are : " + ways);
		
		// making a map
		int map[] = new int[steps+1];
		ways = Question1.countWaysEfficient(steps, map);
		System.out.println("Number of ways using map are : " + ways);
	}
}
