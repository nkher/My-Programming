package Yelp;

public class SinglyLinkedList {
	
	LinkedListNode head;
	
	public SinglyLinkedList() {
	}
	
	public void append(int d) {
		if (head == null) {
			head = new LinkedListNode(d, null, null);
			return;
		}
		LinkedListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new LinkedListNode(d, null, temp);
	}
	
	public void append(LinkedListNode node) {
		if (head == null) {
			head = node;
			return;
		}
		LinkedListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		node.setPrev(temp);
		node.setNext(null);
	}
	
	public void printLinkedList() {
		if (head != null) {
			LinkedListNode temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		} 
		else 
			System.out.println("Linked list is empty.");
	}
	
	public void addToHead(int d) {
		if (head == null) {
			head = new LinkedListNode(d);
			return;
		}
		LinkedListNode temp = new LinkedListNode(d);		
		temp.next = head;
		head = temp;
	}
	
	public String toString() {
		if (head.next != null) {
			return head.data + " -> " + head.next.toString();
		}
		return ((Integer)head.data).toString();
	}
	
	public static void main(String args[]) {
		
		System.out.println("Printing linked list 1");
		
		SinglyLinkedList linkedlist = new SinglyLinkedList();
		linkedlist.append(1);
		linkedlist.append(2);
		linkedlist.append(3);
		linkedlist.append(4);
		linkedlist.append(5);
		
		linkedlist.addToHead(0);
		linkedlist.addToHead(-1);
		
		System.out.println(linkedlist.head.printForward());
		
		System.out.println("Printing linked list 2");
		
		SinglyLinkedList linkedlist2 = new SinglyLinkedList();
		LinkedListNode n1 = new LinkedListNode(100);
		LinkedListNode n2 = new LinkedListNode(200);
		LinkedListNode n3 = new LinkedListNode(300);
		LinkedListNode n4 = new LinkedListNode(400);
		LinkedListNode n5 = new LinkedListNode(500);
		
		linkedlist2.append(n1);
		linkedlist2.append(n2);
		linkedlist2.append(n3);
		linkedlist2.append(n4);
		linkedlist2.append(n5);
		
		// linkedlist2.printLinkedList();
	}
}
