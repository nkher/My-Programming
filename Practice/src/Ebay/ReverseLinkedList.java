package Ebay;

public class ReverseLinkedList {
	
	LinkedListNode head;
	
	// Recursive method
	public void reverseLinkedList(LinkedListNode p) {
		if(p.next  == null) { // means last item
			head = p;
			return;
		}
		reverseLinkedList(p.next);
		// This starts from the second last element
		LinkedListNode temp = p.next; //  Saving the last element
		temp.next = p; // Pointing the last's next to the second last
		p.next = null; // Pointing the second last elements next to null
	}
	
	public static void main(String[] args) {
		
		ReverseLinkedList ll = new ReverseLinkedList();
		ll.head = new LinkedListNode(10, null, null);
		LinkedListNode second =  new LinkedListNode(20, null, ll.head);
		LinkedListNode third =  new LinkedListNode(30, null, second);
		LinkedListNode fourth =  new LinkedListNode(40, null, third);
		ll.head.next = second;
		second.next = third;
		third.next = fourth;
		
		System.out.println(ll.head.printForward());
		ll.reverseLinkedList(ll.head);
		System.out.println(ll.head.printForward());
	}

}
