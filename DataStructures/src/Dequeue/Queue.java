package Dequeue;

import java.util.Scanner;

public class Queue {
	
	int[] queue;
	int rear1 = -1, front1 =-1;
	int rear2 = 0, front2 = 0;
			
	public Queue(int size) {
		queue = new int[size];
		rear2 = queue.length;
		front2 = queue.length;
	}
	
	// Idea is only to add only and only from the rear and then 
	// remove only and only from the front
	public void push1(int v) {
		if(rear1 + 1 == rear2) {
			System.out.println("Queue is full");
			return;
		}
		queue[++rear1] = v;
	}
	
	public void push2(int v) {
		if(rear2 - 1 == rear1) {
			System.out.println("Queue is full");
			return;
		}
		queue[--rear2] = v;
	}
	
	public int remove1() {
		if(rear1 == front1) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		return queue[++front1];
	}
	
	public int remove2() {
		if(rear2 == front2) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		return queue[--front2];
	}
	
	public boolean isEmpty() {
		return rear1 == front1 && rear2 == front2;
	}
	
	public void print1() {
		for(int i=0;i<=rear1;i++) {
			System.out.println(queue[i]);
		}
	}
	
	public void print2() {
		for(int i=rear2;i>=0;i--) {
			System.out.println(queue[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Size of the queue");
		//int size = scan.nextInt();
		Queue queue = new Queue(10);
		
		// Pusing Values from one end
		queue.push1(10);
		queue.push1(23);
		queue.push1(5);
		queue.push1(500);
		
		// Printing the queue from the first end
		//queue.print1();
		
		// Pushing the values from the other end
		queue.push2(4);
		queue.push2(37);
		queue.push2(776);
		queue.push2(98);
		
		queue.print2();

	}

}
