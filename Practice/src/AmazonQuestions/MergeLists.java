package AmazonQuestions;

import Library.LinkedListNode;

public class MergeLists {
	
	public static LinkedListNode mergeLinkedLists(LinkedListNode list1, LinkedListNode list2) {
		LinkedListNode mergerdList = new LinkedListNode();
		mergerdList = list1;
		list1 = list1.next;
		LinkedListNode current = mergerdList;
		boolean listone = false;
		while (list1 != null && list2 != null) {
			if(listone) {
				current.next = list1;
				list1 = list1.next;
			}
			else {
				current.next = list2;
				list2 = list2.next;
			}
			current = current.next;
			listone = !listone; // fliping the checker
		}
		if(list1 != null) {
			while(list1 != null) {
				current.next = list1;
				current = current.next;
				list1 = list1.next;
			}
		}
		if(list2 != null) {
			while(list2 != null) {
				current.next = list2;
				current = current.next;
				list2 = list2.next;
			}
		}
		return mergerdList;
	}

	public static void main(String[] args) {
		
		// Linked List 1
		LinkedListNode head1 = new LinkedListNode(1, null, null);
		LinkedListNode temp = head1;
		for (int i=2;i<=10;i++) {
			LinkedListNode node = new LinkedListNode(i, null, temp);
			temp = node;
		}
		
		System.out.println("List 1: \n" + head1.printForward());
		
		// Linked List 2 
		LinkedListNode head2 = new LinkedListNode(11, null, null);
		int data = head2.data;
		LinkedListNode temp2 = head2;
		for (int i=1;i<=20;i++) {
			LinkedListNode node = new LinkedListNode(i+data, null, temp2);
			temp2 = node;
		}
		
		System.out.println("List 2: \n" + head2.printForward());
		
		// Calling the merge function
		LinkedListNode mergerdList = mergeLinkedLists(head1, head2);
		
		System.out.println("Merged List: \n" + mergerdList.printForward());
	}
}
