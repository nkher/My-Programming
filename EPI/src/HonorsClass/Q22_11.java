package HonorsClass;

import Library.PostingsListNode;

public class Q22_11 {
	
	// Program to copy a postings list
	public static PostingsListNode copyPostingsList(PostingsListNode head) {
		
		PostingsListNode iter = head, newHead;
		
		// Stage 1 - create a separate copy and make its next as the original next of the original list
		// Also change the next nodes of the original list to point to the new copies
		while (iter != null) {
			PostingsListNode newNode = new PostingsListNode(iter.data, iter.next, null);
			PostingsListNode temp = iter.next;
			iter.next = newNode;
			iter = temp;
		}
				
		// Stage two : Set the jump pointers of the copy list
		iter = head;
		while (iter != null) {
			
			if (iter.jump != null) {
				iter.next.jump = iter.jump.next;
			}
			iter = iter.next.next; // this will go to the next node in the original list
		}
		
		// Stage 3 : Rearrange the pointers to fix both the lists (next nodes for the original list and copy list)
		iter = head;
		newHead = iter.next;		
		while (iter != null) {
			PostingsListNode temp = iter.next;
			iter.next = temp.next; // fixing the original list next pointer
			
			if (iter.next != null)
				temp.next = iter.next.next; // fixing the copy list next pointer
			else 
				temp.next = null;
			iter = iter.next;
		}
		
		return newHead;
	}
	
	public static void traverse(PostingsListNode node) {
		while (node != null) {
			int jumpdata = node.jump == null ? -1 : node.jump.data;
			System.out.println("Data : " + node.data + ", Jump Node data : is " + jumpdata);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		
		PostingsListNode head = new PostingsListNode(10, null, null);
		PostingsListNode n1 = new PostingsListNode(20, null, null);
		PostingsListNode n2 = new PostingsListNode(30, null, null);
		
		// Setting the 
		head.next = n1;
		n1.next = n2;
		
		// Setting the jump
		head.jump = n2;
		n1.jump = head;
		n2.jump = n1;
		
		traverse(head);			
		
		PostingsListNode newHead = copyPostingsList(head);
		
		System.out.println();
		
		traverse(newHead);
	}

}
