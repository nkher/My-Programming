package com.CTCI.Chapter2;

import org.CTCILibrary.AssortedMethods;
import org.CTCILibrary.LinkedListNode;

// To get the nth but last element in a linked list
public class Question2_2 {

	public static LinkedListNode nthToLast(LinkedListNode head, int n) {
		
		if (head==null || n<1)
			return null;
		
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		// Move p2 n nodes into the list.  Keep p1 in the same position.
		for (int j=0;j<n-1;j++) {
			if(p2 == null)
				return null; //Error: Linked list is too small
			p2 = p2.next;
		}
		
		if (p2 == null) { // Another error check
			return null;
		}
		
		// Move them at the same pace.  When p2 hits the end, 
		// p1 will be at the right element.
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}
	
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 3;
		LinkedListNode n = nthToLast(head, nth);
		if (n != null) {
			System.out.println(nth + "th to last node is " + n.data);
		} else {
			System.out.println("Null.  n is out of bounds.");
		}
	}

}
