package Practice;

public class App {
	
	private int count;

	public synchronized void increment(){
		count++;
	}
	
	public void doWork(){
		
		//Creating two new threads
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					increment();
				}
				
			}
		});
			
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		//To make the thread finish...we use join(to wait for the thread to die) 
		//But they mite access same state of the count and hence might not change	
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is :" + count);
	}
	
	public static void main(String[] args) {
		
		App app = new App();
		app.doWork();

	}

}
