import java.util.*;

public class DoublyLinkedList extends DoublyNode{
	
	DoublyNode first=null;
	
	//Operations on Doubly Linked List
	//Creating a new node
	public DoublyNode getNewNode(int v){
		//Creating a new node
		DoublyNode newNode = new DoublyNode();
		newNode.data=v;
		newNode.next=null;
		newNode.prev=null;
		return newNode;
	}
	
	public void invert(){
		DoublyNode temp = first;
		while(temp != null){
			temp.prev = temp;
			temp = temp.next;			
		}
	}
	
	//This is to insert at the head
	public void InsertAtHead(int v){
		DoublyNode newNode = getNewNode(v);
		if(first==null){
			first=newNode;
		}
		//If it is not the first node 
		first.prev=newNode;// Setting the current Head's previous to newNode(to be inserted at head) previous
		newNode.next=first;
		first=newNode;
	}
	
	//To display the elements in the Linked list
	void ForwardPrint()
	{
		DoublyNode temp = first;
		System.out.println("Your elements in the node are: ");
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	//To display the elements in the Linked list
	void ReversePrint()
	{
		DoublyNode temp = first;
		System.out.println("Reverse Print: ");
		//This is to get the address of the last pointer
		while(temp != null){
			temp = temp.next;
		}
		//Now start traversing backward
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.prev;
		}
	}
		
	public static void main(String args[]){
		
		DoublyLinkedList dll = new DoublyLinkedList();
		//Inserting elements at the head
		dll.InsertAtHead(10);
		dll.InsertAtHead(20);
		dll.InsertAtHead(30);
		dll.InsertAtHead(40);
		dll.InsertAtHead(50);
		
		//Displaying the elements
		dll.ForwardPrint();
		
		//dll.ReversePrint();
		
		//dll.invert();
		//dll.ForwardPrint();
	}
}
