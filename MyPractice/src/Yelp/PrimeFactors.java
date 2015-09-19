package Yelp;

import java.util.HashSet;
import java.util.Set;

public class PrimeFactors {
	
	public static Set<Integer> primeFactors(long number) {
		Set<Integer> primeFactors = new HashSet<Integer>();
		long inputCopy = number;
		
		for (int i=2;i<=inputCopy;i++) {
			if (inputCopy % i == 0) {
				// System.out.println("i is : " + i + " number is : " + inputCopy);
				primeFactors.add(i);
				inputCopy /= i;
				i--;
			}
		}
		
		return primeFactors;
	}
	
	public static void main(String[] args) {
		
		System.out.println(primeFactors(100));
		System.out.println();
		System.out.println(primeFactors(35));
		System.out.println();
		System.out.println(primeFactors(135));
		System.out.println();
		System.out.println(primeFactors(100100));
		System.out.println();
		System.out.println(primeFactors(232321));
		System.out.println();
		//System.out.println(primeFactors(67232321));
	}

}
