package com.CTCI.Chapter3.Question3_1;

public class Question3_1 {
	
	int stackSize = 10;
	int buffer[] =  new int[stackSize*3]; // The main array 
	int stackPointer[] = {-1,-1,-1};
	
	public void printStack(int stackNum) {
		int start = (stackSize*stackNum);
		int end = absTopOfStack(stackNum);
		System.out.println("Stack " + stackNum + " elements.");
		while (start <= end) {
			System.out.println("Element --> " + buffer[start]);
			start++;
		}
	}
	
	public int absTopOfStack(int stackNum) {
		return (stackSize * stackNum) + stackPointer[stackNum];
	}
	
	public void push(int stackNum, int value) throws FullStackException {
		// Check if the stack is full
		if (stackPointer[stackNum]+1 >= stackSize) {
			throw new FullStackException();
		}
		// Else enter the value
		buffer[absTopOfStack(stackNum) + 1] = value;
		stackPointer[stackNum]++;
	}
	
	public int pop(int stackNum) throws EmptyStackException {
		// Checking if the stack is empty 
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int value = buffer[absTopOfStack(stackNum)];
		stackPointer[stackNum]--;
		return value;
	}
	
	public int peek(int stackNum) {
		return buffer[absTopOfStack(stackNum)];
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}
	
	public static void main(String[] args) throws Exception {
		// Now start pushing
		Question3_1 triple_stack = new Question3_1();
		
		// First stack
		triple_stack.push(0, 1);
		triple_stack.push(0, 2);
		triple_stack.push(0, 3);
		triple_stack.push(0, 4);
		triple_stack.push(0, 5);
		triple_stack.push(0, 6);
		triple_stack.push(0, 7);
		triple_stack.push(0, 8);
		triple_stack.push(0, 9);
		triple_stack.push(0, 10);
		
		// Second stack
		triple_stack.push(1, 10);
		triple_stack.push(1, 20);
		triple_stack.push(1, 30);
		
		// First stack
		triple_stack.push(2, 11);
		triple_stack.push(2, 22);
		triple_stack.push(2, 33);
		
		// Printing the three stacks
		triple_stack.printStack(0);
		triple_stack.printStack(1);
		triple_stack.printStack(2);
		
		// Popping on the first stack
		triple_stack.pop(0);
		triple_stack.pop(0);
		triple_stack.pop(0);
		triple_stack.pop(0);
		triple_stack.pop(0);
		triple_stack.pop(0);
		triple_stack.pop(0);
		
		triple_stack.printStack(0);

	}

}
