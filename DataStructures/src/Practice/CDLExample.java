package Practice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processors implements Runnable{

	private CountDownLatch latch;
	
	public Processors(CountDownLatch latch){
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//When a threads finished then start counting down the latch
		//Value which you passed in the main in the constructor it will
		//Start counting down from there
		latch.countDown();
	}
	
	
}

public class CDLExample{

	public static void main(String[] args) {
		
		//Allowes one or more threads to wait until number reaches zero.
		CountDownLatch latch = new CountDownLatch(3);
		
		//Creating a thread pool of three threads
		ExecutorService executor =  Executors.newFixedThreadPool(3);
		
		//Each thread is going to get a processor
		for (int i=0;i<3;i++){
			executor.submit(new Processors(latch));
		}
		
		//Doing this in the main thread
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdown();
		
		System.out.println("Completed");
	}

}
