package HonorsClass;

import org.CTCILibrary.LinkedListNode;

public class Q22_26 {
	
	public static LinkedListNode node = new LinkedListNode();
	
	public static LinkedListNode buildBSTFromSortedDoublyList(LinkedListNode head) {
		int n = getListLength(head);
		return buildBSTFromSortedDoublyListHelper(head, 0, 7, node);
	}
	
	// Spend O(n) time in getting the midpoint and create a balanced BST on the first (n/2) nodes
	// Then use (n/2 + 1)st node as the root of the final BST and set its left child to the root of the BST just created
	// The only challenge here is to be careful about handling the links properly
	// Finally create the right BST from the remaining (n - (n/2) -1) nodes on the right side of the root
	// The algorithm spends O(1) time per node leading to O(n) time complexity and SC = O(logN) 
	public static LinkedListNode buildBSTFromSortedDoublyListHelper(LinkedListNode head, int start, int end, LinkedListNode temp) {
		if (start >= end) {
			return null;
		}
		
		int mid = start + ((end - start)/2);	
		LinkedListNode left = buildBSTFromSortedDoublyListHelper(head, start, mid, temp);
		
		LinkedListNode current = temp; // the function call will set the head to the successor of the maximum node in the tree
		head = temp.next;
		current.prev = left;
		current.next = buildBSTFromSortedDoublyListHelper(head, mid+1, end, temp);
		
		return current;
	}
	
	public static int getListLength(LinkedListNode head) {
		int count = 1;
		while (head.next != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	public static void inorder(LinkedListNode node) {
		if (node != null) {
			inorder(node.prev);
			System.out.println(node.data);
			inorder(node.next);
		}
	}
	
	public static void printBackWards(LinkedListNode tail) {
		while (tail != null) {
			System.out.println(tail.data);
			tail = tail.prev;
		}
	}
	
	public static void main(String[] args) {
		
		// 10 25 35 50 65 75 100
		
		LinkedListNode head = new LinkedListNode(10, null, null);
		LinkedListNode node1 = new LinkedListNode(25, null, head);
		LinkedListNode node2 = new LinkedListNode(35, null, node1);
		LinkedListNode node3 = new LinkedListNode(50, null, node2);
		LinkedListNode node4 = new LinkedListNode(65, null, node3);
		LinkedListNode node5 = new LinkedListNode(75, null, node4);
		LinkedListNode node6 = new LinkedListNode(100, null, node5);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		//System.out.println(head.printForward() + " length : " + getListLength(head));
				
		LinkedListNode root = buildBSTFromSortedDoublyList(head);
		
		inorder(root);
		//System.out.println(root.data);
	}

}
