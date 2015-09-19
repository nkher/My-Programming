package CareerCup.Google.Latest;

public class SmallerThanNDivBy3And5 {
	
	/***
	 * Example: 
		N = 9 => 3 + 5 + 6 = 14 
		N = 10 => 3 + 5 + 6 + 9 = 23
	 */
	
	public static int smallerThanNDivisible(int n) {
		n--;
		int divBy3 = n/3;
		divBy3 = (divBy3 * (divBy3 + 1)/2) * 3;
		System.out.println(divBy3);
		
		int divBy5 = n/5;
		divBy5 = (divBy5 * (divBy5 + 1)/2) * 5;
		System.out.println(divBy5);
		
		int divBy15 = n/15;
		divBy15 = (divBy15 * (divBy15 + 1)/2) * 15;
		System.out.println(divBy15);
		
		return divBy3 + divBy5 - divBy15;
	}
	
	public static void main(String[] args) {
		System.out.println(smallerThanNDivisible(10));
	}

}
