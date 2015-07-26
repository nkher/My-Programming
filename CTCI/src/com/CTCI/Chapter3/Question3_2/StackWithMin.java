package com.CTCI.Chapter3.Question3_2;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}
	
	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else 
			return peek().min;
	}
	
	public static void main(String args[]) {
		StackWithMin stack =  new StackWithMin();
		stack.push(10);
		System.out.println("Min is " + stack.min());
		stack.push(30);
		System.out.println("Min is " + stack.min());
		stack.push(1);
		System.out.println("Min is " + stack.min());
		stack.push(40);
		System.out.println("Min is " + stack.min());
		stack.push(0);
		System.out.println("Min is " + stack.min());
	}
}
