package Practice;

import java.util.LinkedList;
import java.util.Random;

interface hl{
	final int a=0;
}
public class LowLevelProducerConsumer {

	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT=10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException{
		
		int value=0;
		while(true){
			synchronized (lock) {
				//Wait if the list is Full
				//We use while as when the Lock is released we want to check again
				//for the list size
				while(list.size() == LIMIT){
					lock.wait();
				}
				
				list.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consumer() throws InterruptedException{
		
		Random random = new Random();
		
		while(true){
			synchronized (lock) {
				
				while(list.size() == 0){
					lock.wait();
				}
				System.out.print("List size is :" +list.size());
				int value = list.removeFirst();
				System.out.println("; value is :" + value);
				lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}
	}
	
	public static void main(String[] args) {
		
		final LowLevelProducerConsumer llpc = new LowLevelProducerConsumer();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					llpc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2	 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					llpc.consumer();
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
	}

}
