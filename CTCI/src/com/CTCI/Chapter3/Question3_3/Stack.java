package com.CTCI.Chapter3.Question3_3;

public class Stack {
	public int size = 0;
	public int capacity;
	public Node top;
	public Node bottom;
	
	public Stack(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void join(Node above, Node below) {
		if (above != null) above.below =  below;
		if (below != null) below.above =  above;

	}
	
	public boolean push(int value) {
		// Checking if the stack is full 
		if (size >= capacity) return false;
		size++;
		Node n = new Node(value); // Making a new node
		if (size == 1) bottom = n; // If it is the first node then make it the bottom
		join(n, top); // join  above the top 
		top = n; // Make n as the top
		return true;
	}
	
	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int removeBottom() {
		Node b = bottom; // Store current bottom in a variable
		bottom = bottom.above; // make the node above the bottom as the bottom
		size--; // decrement the size
		if (bottom != null) { // If the botom not null then make the below one to point to null
			bottom.below = null; // Very important step
		}
		return b.value;
	}
}
