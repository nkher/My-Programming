package com.CTCI5.Chapter2;

import java.util.Stack;

import org.CTCILibrary.LinkedListNode;

public class Question2_7 {
	
	public static boolean isPalindrome(LinkedListNode node) {
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// If linked list has odd number of elements then push one ahead
		if (fast != null)
			slow = slow.next;
		
		while (slow != null) {
			int top = stack.pop().intValue();
			System.out.println(slow.data + " " + top);
			if (top != slow.data)
				return false;
			slow = slow.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int length = 9;
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
		//nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
		
		LinkedListNode n1 = new LinkedListNode(0, null, null);
		LinkedListNode n2 = new LinkedListNode(1, null, n1);
		LinkedListNode n3 = new LinkedListNode(2, null, n2);
		LinkedListNode n4 = new LinkedListNode(1, null, n3);
		LinkedListNode n5 = new LinkedListNode(0, null, n4);
		n1.setNext(n2);
		
		System.out.println(n1.printForward());
		System.out.println(isPalindrome(n1));
	}

}
