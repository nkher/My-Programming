package AmazonQuestions;

public class SinglyLinkedList {

	Node first = null;
		
	public Node createNode(){
		Node newNode =  new Node();
		return newNode;
	}
	
	public void insertAtEnd(int v){
		
		// Creating a new node to insert 
		Node newNode = createNode();
		newNode.data = v; 
		
		if(first == null)
			first = newNode;
		
		else{ // Creating a temporary node and assigning it to first
			Node tempNode = first;
			while(tempNode.next != null){
				tempNode = tempNode.next;
			}
			tempNode.next = newNode;
		}
	}
	
	public void insertAtHead(int v){
		
		// Creating a new node to insert 
		Node newNode = createNode();
		newNode.data = v; 
		
		if(first == null)
			first = newNode;
		
		else{ // Creating a temporary node and assigning it to first
			Node tempNode = first;
			first = newNode;
			newNode.next = tempNode;
		}
	}
	
	
	// Deletes the first element that matches v from the list
	public void delete(int v){
		
		if(first != null){
			
			if(first.data == v){ // If first node is the node to be deleted
				first = first.next;
				return;
			}
			else{
				Node tempNode = first;
				Node prev = null; //Used to get the back node
				while(tempNode != null){
					prev = tempNode;
					tempNode = tempNode.next;
					if(tempNode.data == v)
						break;
				}
				if(tempNode == null)
					System.out.println("Your item is not found in the list !!");
				prev.next = tempNode.next; // Here the actual code to delete is taking place
			}
		}
		else
			System.out.println("Linked List is Empty");
	}
	
	// Deletes the all elements that match v from the list
	public void deleteAll(int v){
			
		if(first != null){
			
			if(first.data == v){ // If first node is the node to be deleted
				first = first.next;
			}
			
			Node tempNode = first;
			Node prev = null; // Used to get the back node
			
			while(tempNode != null){
				if(tempNode.data == v){
					prev.next = tempNode.next; // Here the actual code to delete is taking place
					tempNode = tempNode.next;
					continue;
				}
				prev = tempNode;
				tempNode = tempNode.next;
			}
			if(tempNode == null)
				System.out.println("Your item is not found in the list !!");
		}
		else
			System.out.println("Linked List is Empty");
	}
	
	public void displayList(){
		Node tempNode = first;	
		while(tempNode != null){
			System.out.println(tempNode.data);
			tempNode = tempNode.next;
		}
	}
	
	
	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		// Inserting at the end of the Linked List
		list.insertAtEnd(40);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.insertAtEnd(40);
		
		// Printing the list
		//list.displayList();
		
		// Inserting at the head of the linked list
		list.insertAtHead(2);
		list.insertAtHead(1000);
		list.insertAtHead(1000000);
		
		// Printing the list
		list.displayList();
		
		System.out.println("----------------------------");
		
		// Deleting from the list
		System.out.println("Deleting item 40 -- first item which is 40");
		list.delete(40);
		
		// Printing the list
		list.displayList();
		
		System.out.println("----------------------------");
		
		list.insertAtEnd(30);
		list.insertAtEnd(40);
		
		list.displayList();
		
		System.out.println("----------------------------");
		
		// Deleting all the 40s
		System.out.println("Deleting all the 30s from the list");
		list.deleteAll(30);
		
		list.displayList();
		
		
	}
}

class Node{
	
	Node next;
	int data;
}
