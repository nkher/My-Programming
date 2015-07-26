package com.CTCI.Chapter3.Question3_5;

import java.util.ArrayList;
import java.util.Stack;

public class MyQueue<T> {

	Stack<T> s1, s2;
	
	public MyQueue() {
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	public void add(T v) {
		s1.push(v);
	}
	
	public T peek() {
		if (!s2.empty()) {
			return s2.peek();
		}
		else {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.peek();
	}
	
	public T remove() {
		if (!s2.empty()) {
			return s2.pop();
		}
		else {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public int size() {
		return s1.size() + s2.size();
	}
	
	public void print() {
		if (size() < 1) {
			System.out.println("Queue is empty");
			return;
		}
		else {
			System.out.print("[ ");
			if (!s2.empty()) {
//				ArrayList<T> list = new ArrayList<T>(s2);
//				for(T t : list) {
//					System.out.print(t + " ");
//				}
				for(T t : s2) {
					System.out.print(t + " ");
				}
			}
			if (!s1.empty()) {
				ArrayList<T> list = new ArrayList<T>(s1);
				for(T t : list) {
					System.out.print(t + " ");
				}	
			}
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>(); // Create an instance of the MyQueue Class
		// Adding to the queue
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		
		System.out.println("Queue now : " ); // Print the queue and check 
		queue.print();
		System.out.println("Popping from the queue");
		int ret = queue.remove();
		System.out.println("Removed value is " + ret);
		System.out.println("Queue now : " ); // Print the queue and check 
		queue.print();
		
	}

}
