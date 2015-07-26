package AmazonQuestions;

import Library.LinkedListNode;

public class AddLinkedLists {
	
	
	// Without Recursion
	public static int getNumberFromLL(LinkedListNode head) {
		if(head == null) return 0;
		int number = 0;
		while (head.next != null) {
			number = (number + head.data) * 10;
			head = head.next;
		}
		
		// Adding the last element in the list to the Linked List
		number = number + head.data;
		return number;
	}
	
	// With Recursion
	public static int getNumberFromLLRec(LinkedListNode head, int number) {
		if(head == null) return 0;
		if (head.next != null) {
			number = (number + head.data) * 10;
			return getNumberFromLLRec(head.next, number);
		}
		
		// Adding the last element in the list to the Linked List
		number = number + head.data;
		return number; 
	}
	
	public static void main(String args[]) {
		// Linked List 1
		LinkedListNode head1 = new LinkedListNode(1, null, null);
		LinkedListNode temp = head1;
		for (int i=2;i<=4;i++) {
			LinkedListNode node = new LinkedListNode(i, null, temp);
			temp = node;
		}
		
		// Linked List 2 
		LinkedListNode head2 = new LinkedListNode(3, null, null);
		int data = head2.data;
		LinkedListNode temp2 = head2;
		for (int i=1;i<=2;i++) {
			LinkedListNode node = new LinkedListNode((i*2+data)%10, null, temp2);
			temp2 = node;
		}
		
		System.out.println("List 1: \n" + head1.printForward());
		System.out.println("List 2: \n" + head2.printForward());

		int n1 = getNumberFromLL(head1);
		int n2 = getNumberFromLL(head2);
		System.out.println("Sum using iteration : " + (n1 + n2));
		
		int n3 = getNumberFromLLRec(head1, 0);
		int n4 = getNumberFromLLRec(head2, 0);
		System.out.println("Sum using recursion : " + (n3 + n4));
	}
}
