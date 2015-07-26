package com.CTCI5.Chapter9;

public class Question8 {
	// Method 1 - Simple without dynamic programming
	public static int makeChange(int n) {
		int[] denoms = {25, 10, 5, 1};
		return makeChange(n, denoms, 0);
	}
	
	private static int makeChange(int amount, int[] denoms, int index) {
		if (index >= denoms.length-1) return 1; //last denom
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i=0; (i*denomAmount) <= amount; i++) {
			int amountRemaining = amount - (i * denomAmount);
			ways += makeChange(amountRemaining, denoms, index+1);
		}
		return ways;
	}
	
	
	// Method 2
	// Here we have an array that will store the amount, index value so that we dont need 
	// to calculate it over and over again
	public static int makeChangeImproved(int cents) {
		int[] denoms = {25, 10, 5, 1};
		int[][] map = new int[cents+1][denoms.length];
		return makeChangeImproved(cents, denoms, 0, map);
	}
	
	private static int makeChangeImproved(int amount, int[]  denoms, int index, int [][]map) {
		if (map[amount][index] > 0)
			return map[amount][index];
		
		if(index >= denoms.length-1) return 1;
		int denomAmount = denoms[index], ways =0;
		for (int i=0; (i*denomAmount) <= amount; i++) {
			int amountRemaining = amount - (i*denomAmount);
			ways += makeChangeImproved(amountRemaining, denoms, index+1, map);
		}
		
		// add to the map here
		map[amount][index] = ways;
		return ways;
	}
	
	public static void main(String[] args) {
		int cents = 100;
		int ways = Question8.makeChange(cents);
		System.out.println("Number of ways - " + ways);
		
		ways = Question8.makeChangeImproved(cents);
		System.out.println("Number of ways using improved method - " + ways);
	}

}
