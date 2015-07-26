package com.CTCI5.Chapter2;

import org.CTCILibrary.LinkedListNode;

public class Question2_4 {

		// Method 1
		public static LinkedListNode partition(LinkedListNode node, int x) {
			LinkedListNode beforeStart = null;
			LinkedListNode beforeEnd = null;
			LinkedListNode afterStart = null;
			LinkedListNode afterEnd = null;
			
			if (node == null) return null;
			
			while (node != null) {
				LinkedListNode next = node.next; // save the next in a variable for iteration purpose
				node.next = null;
				if (node.data < x) {
					if (beforeStart == null) {
						beforeStart = node;
						beforeEnd = beforeStart;
					}
					else {
						beforeEnd.next = node;
						beforeEnd = node;
					}
				}
				else {
					if (afterStart == null) {
						afterStart = node;
						afterEnd = afterStart;
					}
					else {
						afterEnd.next = node;
						afterEnd = node;
					}
				}
				node = next;
			}
			
			// Merge both the lists don't forget
			if (beforeStart == null)
				return afterStart;
			
			beforeEnd.next = afterStart;
			return beforeStart;
	}
		
		// Method 2 - using less pointers
	public static LinkedListNode partition2(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				/* Insert node at head */
				node.next = head;
				head = node;
			}
			else {
				/* Insert node at tail */
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		
		int[] vals = {1, 3, 7, 5, 2, 9, 4};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		LinkedListNode h = partition(head, 5);
		
		System.out.println(h.printForward());
		
		System.out.println("Method 2");
		
		int length = 20;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		
		LinkedListNode head2 = nodes[0];
		System.out.println(head2.printForward());
		
		LinkedListNode h1 = partition(head, 8);
		System.out.println(h1.printForward());
	}

}
