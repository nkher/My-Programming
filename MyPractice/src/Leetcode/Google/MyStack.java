package Leetcode.Google;

import java.util.LinkedList;
import java.util.Queue;

// This approach is by making the push operation expensive
public class MyStack {
	
	Queue<Integer> q1;
	Queue<Integer> q2;
	
	public MyStack() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	
	public void push(int x) {
		q2.add(x); // add to q2
		
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		
		Queue<Integer> temp = q2;
		q2 = q1;
		q1 = temp;
	}
	
	public int peek() {
		return q1.peek();
	}
	
	public int top() {
		int top = q1.remove();
		return top;
	}
	
	public boolean size() {
		return (q1.size() + q2.size() == 0);
	}
	
	public static void main(String[] args) {
		
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.peek());
		
		int top = stack.top();
		System.out.println(top);
		
		System.out.println(stack.peek());
	}

}
