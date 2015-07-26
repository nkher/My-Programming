package AmazonQuestions;

public class StaticExample {
	
	static int j = 10;
	
	public void function() {
		for(int i=0;i<5;i++) {
			j += i;
			System.out.println("j is : " + j);
		}
	}
	
	public static void main(String[] args) {
		
		StaticExample se = new StaticExample();
		se.function();
		
//		for(int i=0;i<5;i++) {
//			int j = 10;
//			j += i;
//			System.out.println("j is : " + j);
//		}
	}

}
