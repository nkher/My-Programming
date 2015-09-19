package Queue;

public class Queue{
	
	public int capacity;
	public int size = 0;
	public Node front;
	public Node rear;
	
	public Queue(int capacity) {
		this.capacity = capacity;
	}
	
	public void join(Node above, Node below) {
		if(above != null) above.below = below;
		if(below != null) below.above = above;
	}
	
	public boolean push(int value) {
		if (size >= capacity) return false;
		size++;
		Node n = new Node(value);
		if (size == 1) front = n;
		join(n, rear);
		rear = n;
		return true;
		
	}
 	
	public boolean pop() {
		if (size == 0) return false;
		size--;
		Node t = front;
		front = front.above;
		System.out.println("Element " + t.value + " popped.");
		return true;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void print() {
		Node t = front;
		while(t != null) {
			System.out.print(t.value + " --> ");
			t = t.above;
		}
	}
}
