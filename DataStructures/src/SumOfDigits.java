
public class SumOfDigits {

	public static void main(String[] args) {
		
		int number=845271;
		int result=0;
		while(number>0){
			result=result+(number)%10;
			number=number/10;
		}
		System.out.println("Sum of the digits is " + result);
	}

}
