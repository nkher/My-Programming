package Practice;

import java.util.Scanner;

public class Processor extends Thread{

	
	private volatile boolean running = false;
	
	public void run(){
	   
		while(running){
		System.out.println("Press return to stop thread!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//We are calling shutDown from main applications thread and 
	//not from the thread we spawned
	//Therefor it will only modify running not even checking prior what is the value of running
	public void shutDown(){
		running = true;
	}
	
	public static void main(String[] args) {
		
		//Here there are two threads, one in the application and other we have spawned
		
		Processor p = new Processor();
		p.start();
		
		System.out.println("Press return to stop.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		p.shutDown();//Calling shutDown in the main thread

	}

}
