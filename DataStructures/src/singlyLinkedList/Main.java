package singlyLinkedList;

public class Main {

	public static void print(LinkedListNode first) {
		LinkedListNode temp = first;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static LinkedListNode middleLL(LinkedListNode first) {
		LinkedListNode p1 = first; // Increment with two
		LinkedListNode p2 = first; // Inc with one
		while(p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
			if(p2.next != null)
				p2 = p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		
		LinkedListNode first =  new LinkedListNode(10, null, null);
		LinkedListNode second =  new LinkedListNode(30, null, first);
		LinkedListNode third =  new LinkedListNode(5, null, second);
		LinkedListNode fourth =  new LinkedListNode(7, null, third);
		LinkedListNode fifth =  new LinkedListNode(28, null, fourth);
		LinkedListNode sixth =  new LinkedListNode(45, null, fifth);
		LinkedListNode seventh =  new LinkedListNode(90, null, sixth);

		
		print(first);
		LinkedListNode middle = middleLL(first);
		System.out.println("Middle element is : " + middle.data);
		
	}

}
