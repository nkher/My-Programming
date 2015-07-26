package BloombergQuestions;

import java.util.Scanner;

public class Josephus {

	private CircularLinkedList cl;
	private int numberOfPersons;
	private int countToDeath;
	public void setInts() {
		System.out.println("Enter the number of people");
		Scanner input = new Scanner(System.in);
		numberOfPersons = input.nextInt();
		System.out.println("Enter the count to death");
		countToDeath = input.nextInt();
	}
	
	public void buildCircularLinkedList() {
		cl = new CircularLinkedList();
		for (int i=1;i<=numberOfPersons;i++) {
			cl.append(i);
		}
		cl.display();
	}
	
	public void startTheGame() {
		cl.josephus(countToDeath, numberOfPersons);
		System.out.println("Lucky fellow was : ");
		cl.display();
	}
	
	public static void main(String[] args) {
		Josephus js = new Josephus();
		js.setInts();
		js.buildCircularLinkedList();
		js.startTheGame();
	}
}

class CircularLinkedList {
	private Node start;
	private int count;
	public void append(int val) {
		count++;
		Node newNode = new Node(val);
		if(start == null) {
			start = newNode;
		}
		else { // assigning the new node before the start ndoe
			Node temp = start;
			while (temp.next != start) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		newNode.next = start;
	}
	
	public void addToBeginning(int val) {
		count++;
		Node newNode = new Node(val);
		if(start == null) {
			start = newNode;
		}
		else { // make newnode the start and push the start ahead
			Node temp = start;
			while (temp.next != start) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = start;
		}
		start = newNode;
	}
	
	public void addAtPosition(int val, int pos) {
		count++;
		Node newNode = new Node(val);
		Node temp = start;
		for (int i=0;i<=pos;i++) {
			if(temp.next == start) {
				break;
			}
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public void display() {
		if(start == null) {
			System.out.println("List is empty !!");
		}
		Node temp =  start;
		while (temp.next != start) {
			System.out.println(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println(temp);
	}
	
	public void deleteAt(int pos) {
		if(pos == 0) {
			
		}
		Node current = start;
		Node previous = start;
		for (int i=0;i<pos;i++) {
			if(current.next == start) {
				break;
			}
			previous = current;
			current = current.next;
		}
		System.out.println("Deleting node : " + current.data);
		previous.next = current.next;
		count--;
	}
	
	public int deleteNode(Node node) {
		Node current = start;
		Node previous = start;
		int toDelete = node.data;
		while(current.data != toDelete) {
			if(current.next ==  start)
				break;
			previous = current;
			current = current.next;
		}
		previous.next = current.next;
		count--;
		return toDelete;
	}
	
	public void deleteFirst() {
		Node temp = start;
		while (temp.next != start) {
			temp = temp.next;
		}
		temp.next = start.next;
		start = start.next;
		count--;
	}
	
	public int getCount() {
		return count;
	}
	
	public void josephus(int countToDeath, int people) {
		Node current = start;
		int caller = 0;
		while (true) {
			caller = current.data;
			System.out.println(caller + " says -> ");
			for (int i=0;i<countToDeath-1;i++) {
				current = current.next;
			}
			start = current.next; // setting the start to the person after count to death
			if (getCount() > 1) {
                // comparing caller with person going to be dead
				if(caller == current.data) {
					System.out.println(" Killing my self " + deleteNode(current));
				}
				else {
					System.out.println("I do not want to say but you must die Mr. no:"
                            +deleteNode(current));
				}
			}else {
				System.out.println("saved my self");
				break;
			}
			current = start;
		}
	}
}

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
