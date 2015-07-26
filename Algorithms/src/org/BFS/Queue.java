package org.BFS;

public class Queue {
	
	private final int SIZE=20;
	private int qArray[];
	private int front;
	private int rear;
	
	//Constructor initializing the Q
	public Queue(){
		qArray = new int[SIZE];
		front=0;
		rear=-1;
	}
	
	//Put item at the rear of the Q
	public void insert(int j){
		if(rear==SIZE)
			rear=-1;
		qArray[++rear]=j;
	}
	
	//Take item from the Q
	public int remove(){
		int temp = qArray[front++];
		if(front==SIZE)
			front=0;
		return temp;
	}
	
	//Check if Q is Empty
	public boolean isEmpty(){
		return (rear+1 == front || (front+SIZE-1==rear));
	}
	
}
