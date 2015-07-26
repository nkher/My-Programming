package com.CTCI.Chapter3.Question3_3;

import java.util.ArrayList;

public class SetOfStacks {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	public Stack getLastStack() {
		if (stacks.size() == 0) return null;
		return stacks.get(stacks.size() - 1);
	}
	
	public void push(int v) {
		Stack last = getLastStack();
		if (last != null && !last.isFull())
			last.push(v);
		else {
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		Stack last = getLastStack();
		int v = last.pop();
		if (last.size == 0) stacks.remove(stacks.size() - 1); // Remove the last stack from the list of stacks if it does not have any thing
		return v;
	}
	
	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		if(removeTop) removed_item = stack.pop();
		else removed_item = stack.removeBottom();
		if (stack.isEmpty()) // Remove the stack from the list if it is empty
			stacks.isEmpty();
		else if (stacks.size() > index + 1) { 
			// Checking if there are more stacks above. If yes then do the roll-over
			// In roll-over we will move the bottom of the above stack to the top of the below stack, on which the pop was done
			int removed_above = leftShift(index + 1, false);
			stack.push(removed_above);
		}
		return removed_item;
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
}
