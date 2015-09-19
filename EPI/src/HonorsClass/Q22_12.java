package HonorsClass;

import org.CTCILibrary.LinkedListNode;

public class Q22_12 {
	
	public static double medianSortedCircularList(LinkedListNode arbitaryNode) {
		
		int n = 0;
		
		// make the largest node as the first smallest node
		LinkedListNode firstSmallest = arbitaryNode, iter = arbitaryNode;
		do {
			n++;
			if (firstSmallest.data <= iter.data) {
				firstSmallest = iter;
			}
			iter = iter.next;
		} while (iter != arbitaryNode);
		
		firstSmallest = firstSmallest.next; // now the first smallest is the smallest node
			
		for (int i=0; i<(n-1)/2; i++) {
			firstSmallest = firstSmallest.next;
		}
		
		if (n%2 == 1) {
			return firstSmallest.data;
		}
		else {
			return ( (firstSmallest.data + firstSmallest.next.data) * 0.5 );
		}
	}

	public static void main(String[] args) {
		
		LinkedListNode head = new LinkedListNode(2, null, null);
		LinkedListNode n1 = new LinkedListNode(2, null, null);
		LinkedListNode n2 = new LinkedListNode(3, null, null);
		LinkedListNode n3 = new LinkedListNode(6, null, null);
		LinkedListNode n4 = new LinkedListNode(17, null, null);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = head;
		
		System.out.println(medianSortedCircularList(n4));
	}

}
