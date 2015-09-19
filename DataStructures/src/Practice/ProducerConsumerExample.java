package Practice;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
	
	private static BlockingQueue<Integer> queue =  new ArrayBlockingQueue<Integer>(10);
	
	//Why Put and Take of the Queue is good
	//No need of Sync keyword as ArrayBlocking queue comes from concurrent classes
	//Take waits even if Queue is empty so therefore no need to take care of that
	//Put waits until there is space in Queue if at all there problem in space!
	
	static boolean run=true;
	
	//To put things on the queue
	public static void producer() throws InterruptedException{
		Random random = new Random();
		while(run){
			queue.put(random.nextInt(100));
		}
	}
	
	//To take things off the queue like a real world scenario
	//That means make it take some processing time and only then 
	//remove it
	private static void consumer() throws InterruptedException{
		Random random = new Random();

		while(run){
			Thread.sleep(100);
			if(random.nextInt(10) == 0){
				Integer value = queue.take();
				System.out.println("Taken Value : " + value);
				System.out.println("Queue size is : " + queue.size());
			}
		}
	}
	
	private static void shutPC(){
		run=false;
	}
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Press enter to stop producer-conusmer");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		}
}


