package com.CTCI.Chapter2;

import org.CTCILibrary.LinkedListNode;

// To find the beginning of a circular linked list
public class Question2_5 {
	
	public static LinkedListNode findBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		// Find the meeting point
		while (fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) 
				break;
		}
		
		// Error check - to check if no meeting point
		if (fast == null || fast.next == null) 
			return null;
		
		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
	public static void main(String[] args) {
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
				
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		//System.out.println(nodes[list_length-1].next.data);

		
		LinkedListNode loop = findBeginning(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}

	}

}
