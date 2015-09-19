package Practice;

public class Thread2 implements Runnable{
	
	public Thread2() {
		System.out.println("In thread 2 cons");
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId() + "is being processed.");
		try {
			Thread.sleep((int)(Math.random()*10000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Thread2 t2 = new Thread2();
		Thread t = new Thread(t2);
		t.start();
	}

	

}
