import java.util.*;

//Our linked list class will extend the Node class
public class LinkedList extends Node{

	Node first = null;
	
	//To add a value into the linked list at the end
	void insert (int v)
	{
		//First creating a new node and initializing its data members
		Node n = new Node();
		n.data = v;
		n.next = null;
		
		//Checking if first is empty. If not then assign n to the first position
		if(first == null)
			first = n;
		else{
			Node temp = first;
			while(temp.next != null ){
			temp = temp.next;			
			}
			temp.next = n;
		}
	}
	
	
	//To display the elements in the Linked list
	void display()
	{
		Node temp = first;
		System.out.println("Your elements in the node are: ");
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public void invert(){
		//Node temp = first;
		Node prev = null;
		while(first.next != null){
			prev = first;
			first = first.next;	
			first.next = prev;
		}
	}
	
	//To remove and element in the linked list
	void remove(int v) throws Exception{
		
		if(first == null){
			throw new Exception("Linked list is empty !");
		}
		//If the element is the first one then shift the position of the first node 
		if(first.data == v)
			first = first.next;
		else
		{
			Node temp = first;
			Node prev = null;
			while (temp != null)
			{
				prev = temp;	
				temp = temp.next;
				if (temp.data == v)
					break;
			}
			if(temp == null)
				System.out.println("Value not found !");
			else
				prev.next = temp.next;
		}
	}
	
	

	
	public static void main(String[] args) throws Exception {
		
		//Creating an object of the type Linked List
		LinkedList obj =  new LinkedList();
		
		//To insert the elements
		obj.insert(10);
		obj.insert(20);
		obj.insert(30);
		obj.insert(40);
		//obj.insert(40);
		//obj.insert(40);
		//obj.insert(40);
		
		
		//To display the elements
		obj.display();
		
		//To remove an element
		//obj.remove(20);
		
		//Display again
		//obj.display();
		
		
		//Inverting
		obj.invert();
		obj.display();
	}

}
