
public class CheckPrime {

	public boolean CheckingPrime1(double number){
		final long startTime = System.currentTimeMillis();
		for(int i=2;i<number;i++){
			if(number%i == 0){
				final long endTime1 = System.currentTimeMillis();
				System.out.println("Total Execution Time for Checking Prime 2 : " + (endTime1 - startTime) + " millis");
				return false;
				}
			}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total Execution Time for Checking Prime 1 : " + (endTime - startTime) + " millis");
			return true;
			
	}
	
	public boolean CheckingPrime2(double number){
		final long startTime = System.currentTimeMillis();
		for(int i=2;i<Math.sqrt(number);i++){
			if(number%i == 0){
				final long endTime1 = System.currentTimeMillis();
				System.out.println("Total Execution Time for Checking Prime 2 : " + (endTime1 - startTime) + " millis");
				return false;
				}
			}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total Execution Time for Checking Prime 2 : " + (endTime - startTime) + " millis");
		return true;
	}
	
	public static void main(String[] args) {
		boolean isPrime;
		CheckPrime object = new CheckPrime();
		
		//Calling the first method
		isPrime = object.CheckingPrime1(3571);
		if(isPrime == true){
			System.out.println("Is a prime number");
		}
		else{
			System.out.println("Not a prime number");
		}
		
		//Calling second method
		isPrime = object.CheckingPrime2(3571);
		if(isPrime == true){
			System.out.println("Is a prime number");
		}
		else{
			System.out.println("Not a prime number");
		}
		
	}

}
