package com.CTCI.Chapter2;

import java.util.Random;

import org.CTCILibrary.LinkedListNode;

// To delete a node from a linked list
public class Question2_3 {
	
	// Cannot happen for the last node
	public static boolean deleteNode(LinkedListNode node) {
		if (node == null || node.next == null)
			return false;		
		LinkedListNode next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;
	}
	
	public static void main(String[] args) {
		
		LinkedListNode first =  new LinkedListNode(90, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;
		Random random =  new Random();
		int number = 10;
		for (int i=0;i<9;i++) {
			//int number  = random.nextInt(10) +1; // (max - min + 1) + min
			second =  new LinkedListNode(number*i, null, null);
			first.setNext(second); // Setting first's next as second
			second.setPrevious(first); // Setting second's previous as first
			first = second; // Assigning new first as the second
		}
		
		// Printing the array
		System.out.println(head.printForward());
		
		// Deleting an element
		deleteNode(head.next.next); // Deleting
		System.out.println(head.printForward());

	}

}
