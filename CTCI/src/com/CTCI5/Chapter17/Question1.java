package com.CTCI5.Chapter17;

public class Question1 {
	
	public static void swap(int a, int b) { // 10, 4
		System.out.println("Before a : " + a + " b : " + b);
		a = a - b; // a = 10 - 4 = 6
		b = a + b; // 4 + 6 = 10
		a = b - a;
		System.out.println("After a : " + a + " b : " + b);
	}
	
	public static void swap_opt(int a, int b) {
		System.out.println("Before a : " + a + " b : " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("After a : " + a + " b : " + b);
	}
	
	public static void main(String[] args) {
		swap(10, 4);
		System.out.println();
		swap_opt(10, 20);
	}

}
