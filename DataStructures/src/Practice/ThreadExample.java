package Practice;

public class ThreadExample extends Thread{
	
	public void run(){
		System.out.println(Thread.currentThread().getId() + "is being processed.");
		try {
			Thread.sleep((int)(Math.random()*10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 public static void main(String[] args) {
		
		ThreadExample[] te = {new ThreadExample(), new ThreadExample()};
		te[0].start();
		te[1].start();
		
		String str = new String();
		System.out.println();
	}

}
