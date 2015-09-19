package Practice;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

public class Worker {

	private Random random =  new Random();
	 
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	
	public ArrayList<Integer> list1 =  new ArrayList<Integer>();
	public ArrayList<Integer> list2 =  new ArrayList<Integer>();
	
	//If method is sync then it takes more time as 
	// it will instrinsically lock the whole Worker object 
	//There for use Sync blocks as they are not writing to the same data
	
	//Note : If you use same lock object it will again take 4 seconds !
	
	public void stageOne(){
		synchronized(lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	
	public synchronized void stageTwo(){
		synchronized(lock2){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
	
	public void process(){
		for (int i=0;i<1000;i++){
			stageOne();
			stageTwo();
		}
	} 
	
	public void main(){
		System.out.println("Starting ......");
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				process();
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
		
		long end = System.currentTimeMillis();
		
		System.out.println("Execution Time : " + (end-start));

		System.out.println("List 1 size : " + list1.size());
		System.out.println("List 2 size : " + list2.size());
	}
}
