package com.CTCI.Chapter3.Question3_2;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer>{

	Stack<Integer> s2;
	
	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}
	
	public void push(int value) {
		if (value < min()) {
			s2.push(value);
		}
		super.push(value); // If the new element is greater than the one at the top then 
						   // compare with the next element
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}
	
	public int min() {
		if (s2.isEmpty())
			return Integer.MAX_VALUE;
		else
			return s2.peek();
	}
	
	public static void main(String[] args) {
		StackWithMin2 stack = new StackWithMin2();
		stack.push(10);
		System.out.println("Min is : " + stack.min());
		stack.push(5);
		System.out.println("Min is : " + stack.min());
		stack.push(1000);
		System.out.println("Min is : " + stack.min());
		stack.push(4);		
		System.out.println("Min is : " + stack.min());
	}

}
