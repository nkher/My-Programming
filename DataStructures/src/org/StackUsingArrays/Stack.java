package org.StackUsingArrays;

import java.util.Scanner;

public class Stack {
	
	int top = -1;
	Object stack[];
	
	public Stack(int size) {
		stack = new Object[size];
	}
	
	public int getStackSize() {
		return top+1;
	}
	
	public void push(Object object) {
		if (top == stack.length) {
			System.out.println("Your Stack is Full Currently ! No insert is possible. ");
		}
		else {
			stack[++top] = object;
			System.out.println("Successfully inserted into the stack");
		}
	}
	
	public Object pop() {
		Object object = null;
		if (top == -1) {
			System.out.println("Currently the stack is Empty ! So nothing to pop.");
		}
		else {
			object = stack[top];
			System.out.println("  :  " + object);
			top--;
		}
		return object;
	}
	
	public void displayStack() {
		System.out.println("Elements in the stack are: ");
		int i;
		for (i=0;i<stack.length;i++) {
			System.out.println(stack[i]);
		}
	}
	
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		else 
			return false;
	}
	
	public static void main(String[] args) {
		
		int i, size = 10;
		Scanner scanner =  new Scanner(System.in);
		Stack myStack = new Stack(size);
		
		System.out.println("Please start entering elements into the stack.");
		for (i=0;i<size;i++) {
			int element = scanner.nextInt();
			myStack.push(element);
			System.out.println(element + " entered. Please enter next element");
		}
		
		System.out.println("Insertion is done. Your elements in the stack are : ");
		myStack.displayStack();
		System.out.println("Size is : " + myStack.getStackSize());
		System.out.print("Popping one element.");
		myStack.pop();
		System.out.println("Size is : " + myStack.getStackSize());

	}
}
