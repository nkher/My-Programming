package org.CTCI.Chapter5;

public class Question5_1 {
	
	// In an input N = 10000000000, M = 10101, i = 2, j = 6
	// Method would set bits between i and j in N to the ones in M
	public static int updateBits(int N, int M, int start, int end) {
		int max = ~0; //max will contain all 1's (32 1's)
		
		// now get a number which has bits set to 0 j onwards 
		// and to 1 before j
		int left = max - ( (1<<end) -1);
		
		// now get a number which has bits set to 1 i onwards 
		// and to zeros before j
		int right = (1 << start) - 1;
		
		// getting the mask
		int mask = left | right;
		
		int i1 = N & mask;
		System.out.println(i1 + " is " + Integer.toBinaryString(i1));
		int i2 = M << start;
		System.out.println(i2 + " is " + Integer.toBinaryString(i2));
		return i1 | i2;
	}
	
	public static void main(String[] args) {
		int result = Question5_1.updateBits(1024, 21, 2, 6);
		System.out.println(Integer.toBinaryString(result));
	}
}
