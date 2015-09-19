package GeeksForGeeks;

import org.CTCILibrary.LinkedListNode;

public class MergeSortLinkedList {
	
	/* */
	public static LinkedListNode mergeSort(LinkedListNode head) {
		
		if (head == null || head.next == null) return null;
		
		// Keep splitting the linkedlists into two halves
		SplittedHeads sHeads = splitList(head);
		
		//System.out.println("H1 : " + sHeads.h1.printForward());
		//System.out.println("H2 : " + sHeads.h2.printForward());
		
		mergeSort(sHeads.h1);
		mergeSort(sHeads.h2);
		
		head = sortedMerge(sHeads.h1, sHeads.h2);
		
		return head;
	}
	
	public static LinkedListNode sortedMerge(LinkedListNode a, LinkedListNode b) {
		
		LinkedListNode result = null;
		
		// Best cases
		if (a == null) return b;
		else if (b == null) return a;
		
		/* Pick either a or b, and recurse */
		if (a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		}
		else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		
		return result;
	}
	
	public static LinkedListNode getTail(LinkedListNode head) {
		if (head == null) return null;
		LinkedListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		return tail;
	}
	
	public static int lengthList(LinkedListNode head) {
		if (head == null) return 0;
		int len = 1;
		while (head.next != null) {
			head = head.next;
			len++;
		}
		return len;
	}
	
	public static SplittedHeads splitList(LinkedListNode head) {
		
		LinkedListNode h1, h2 = null;
		if (head == null || head.next == null) {
			return new SplittedHeads(head, head.next);
		}
		
		int len = lengthList(head);
		int mid = len/2;
		
		if (mid == 0) return new SplittedHeads(head, head.next);
		
		h1 = head;
		LinkedListNode tmp = h1;
		while (mid > 0) {
			tmp = tmp.next;
			mid--;
		}
		
		h2 = tmp.next;
		tmp.next = null;
		
		//System.out.println(h1.data + " " + tmp.data + " " + h2.data);
				
		return new SplittedHeads(h1, h2);
	}
	
	public static void main(String[] args) {
		
		
		LinkedListNode n6 = new LinkedListNode(87, null, null);
		LinkedListNode n5 = new LinkedListNode(45, n6, null);
		LinkedListNode n4 = new LinkedListNode(1, n5, null);
		LinkedListNode n3 = new LinkedListNode(13, n4, null);
		LinkedListNode n2 = new LinkedListNode(5, n3, null);
		LinkedListNode n1 = new LinkedListNode(8, n2, null);
		LinkedListNode h1 = new LinkedListNode(10, n1, null);
		
		System.out.println(h1.printForward());
		
		h1 = mergeSort(h1);
		
		System.out.println(h1.printForward());
	}

}

class SplittedHeads {
	
	public LinkedListNode h1, h2;
	
	public SplittedHeads() {}
	
	public SplittedHeads(LinkedListNode h1, LinkedListNode h2) {
		this.h1 = h1;
		this.h2 = h2;
	}
}
