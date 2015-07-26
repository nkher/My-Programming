package org.CTCI.Chapter5;

public class Question5_2 {
	
	// Write a function to determine the number of bits 
	// required to convert integer A to integer B
	
	public static int bitSwapRequired(int A, int B) {
		System.out.println(Integer.toBinaryString(A));
		System.out.println(Integer.toBinaryString(B));
		int count = 0;
		for (int c = A ^ B; c != 0; c = c >> 1) {
			System.out.println("c is : " + Integer.toBinaryString(c) + "  Count is : " + count);
			count += c & 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int numberOfBits = bitSwapRequired(1, 15);
		System.out.println(numberOfBits + " swaps required.");
	}

}
