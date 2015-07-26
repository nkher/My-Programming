package com.CTCI5.Chapter17;

public class Question3 {

	// Method 1
	public static int countFactZeros(int num) {
		int count = 0;
		for (int i=2;i<=num;i++) {
			count += factorsOf5(i);
		}
		return count;
	}
	
	public static int factorsOf5(int i) {
		int count  = 0;
		while (i%5 == 0) {
			count ++;
			i = i/5;
		}
		return count;
	}
	
	// Method
	public static int countFactZerosDirectly(int num) {
		int count = 0;
		if (num < 0) return -1;
		for (int i=5; num/i > 0; i=i*5) 
			count += num/i;
		return count;
	}
	
	public static void main(String[] args) {
		int result = countFactZeros(20);
		System.out.println(result);
		
		result = countFactZerosDirectly(25);
		System.out.println(result);
	}

}
