package Practice;

public class DaemonThread extends Thread{
	
	public void run(){
		
		System.out.println("Name is : " + Thread.currentThread().getName());
		System.out.println("Daemon : " + Thread.currentThread().isDaemon());
	}

	public static void main(String[] args) {
		
		Thread t1 =  new Thread();
		Thread t2 =  new Thread();
		t1.setDaemon(true);
		
		t1.start();
		t2.start();
	}

}
