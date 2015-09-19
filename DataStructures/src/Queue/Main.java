package Queue;

public class Main {

	public static void main(String[] args) {
		Queue queue = new Queue(10);
		for (int i=1;i<=10;i++) {
			queue.push(i*10);
		}
		
		System.out.println("Before popping");
		// Printing the queue
		queue.print();
		
		// Popping from the queue
		queue.pop();
		
		System.out.println("After popping");
		// Printing the queue
		queue.print();
		
		// Popping from the queue
		queue.pop();
		queue.pop();
		
		queue.print();
	}
}
