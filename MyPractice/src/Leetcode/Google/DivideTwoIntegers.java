package Leetcode.Google;

public class DivideTwoIntegers {
	
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) return Integer.MAX_VALUE;
		if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
		
		long pDividend = Math.abs((long)dividend);
		long pDivisor = Math.abs((long)divisor);
		
		int result = 0;
		while (pDividend >= pDivisor) {
			// calculate the number of left shifts
			int numshifts = 0;
			while (pDividend >= (pDivisor << numshifts)) {
				numshifts++;
			}
			
			System.out.println("Number of left shifts : " + numshifts);
			// dividend minus the largest shifted divisor
			result += 1 << (numshifts-1);
			pDividend -= (pDivisor << (numshifts-1)); // get the difference for the next iteration
		}
		
		if  ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
			return result;
		}
		else {
			return result  * (-1);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(divide(8, 2));
	}

}
