package com.CTCI5.Chapter3;

import java.util.Stack;

import org.CTCILibrary.AssortedMethods;

public class Question6 {
	
	// Method 1 - Sort a stack using another stack
	// Time complexity - O(N^2) and Space Com - O(N)
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!r.isEmpty() && temp < r.peek()) {
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}
	
	// Method 2 using many stacks
	public static Stack<Integer> mergesort(Stack<Integer> s) {
		if (s.size() <= 1) return s;
		
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		while (s.size() != 0) {
			count++;
			if(count % 2 == 0)
				left.push(s.pop());
			else
				right.push(s.pop());
		}
		
		left = mergesort(left);
		right = mergesort(right);
		
		while (left.size() > 0 || right.size() > 0) {
			
			if (left.size() == 0) {
				s.push(right.pop());
			}
			else if(right.size() == 0) {
				s.push(left.pop());
			}
			else if (right.peek().compareTo(left.peek()) <= 0) {
				s.push(left.pop());
			}
			else
				s.push(right.pop());
		}
		
		Stack<Integer> reverseStack = new Stack<Integer>();
		while (s.size() > 0) {
			reverseStack.push(s.pop());
		}
		return reverseStack;
	}
	
	
	public static void main(String[] args) {
//		for (int k = 1; k < 100; k++) {
//			c = 0;
//			Stack<Integer> s = new Stack<Integer>();
//			for (int i = 0; i < 10 * k; i++) {
//				int r = AssortedMethods.randomIntInRange(0,  1000);
//				s.push(r);
//			}
//			s = mergesort(s);
//			int last = Integer.MAX_VALUE;
//			while(!s.isEmpty()) {
//				int curr = s.pop();
//				if (curr > last) {
//					System.out.println("Error: " + last + " " + curr);
//				}
//				last = curr;
//			}
//			System.out.println(c);
//		}
		
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10 * 2; i++) {
			int r = AssortedMethods.randomIntInRange(0,  1000);
			s.push(r);
		}
		
		s = mergesort(s);
		
		while (!s.isEmpty()) {
			int x = s.pop();
			System.out.println(x);
		}
	}

}
