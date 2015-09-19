public class FizzBuzz {

	public void GenerateFizzBuzzResult(int range){
		
		for(int i=0;i<range;i++){
			if(i%3==0 && i%5==0)
				System.out.println("FizzBuzz");
			else if(i%3==0)
				System.out.println("Buzz");
			else if(i%5==0)
				System.out.println("Fizz");
			else 
				System.out.println(i);
		}
	}
	
	public static void main(String args[]){
		
		FizzBuzz fb = new FizzBuzz();
		fb.GenerateFizzBuzzResult(15);
	}
}
