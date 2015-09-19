package Practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample implements Runnable{

	private int id;
	
	public ExecutorExample(int id){
		this.id=id;
	}
	
	public void run(){
		System.out.println("Starting id : " + id);
		try {
			Thread.sleep(5000);//This is the work each task is doing ! To sleep !
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed id : " + id);
	}
	
	public static void main(String[] args) {
		
		//Assigning 2 workers
		ExecutorService executor = Executors.newFixedThreadPool(2);

		//Giving 5 tasts
		for(int i=0;i<5;i++){
			//Creating new threads as the work
			executor.submit(new ExecutorExample(i));
		}
		
		executor.shutdown();//Waits to complete threads to wait
		
		System.out.println("All tasks submitted");
		
		
		//Wait for all tasks to complete for 1 day, if it does not till then, it would throw exception
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
	}

}
