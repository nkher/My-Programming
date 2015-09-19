package Yelp;

public class SumLargeStrings {
	
	/* Method 1 - Simple */
	public static int sumStringsSimple(String n1, String n2) {
		return Integer.parseInt(n1) + Integer.parseInt(n2);
 	}
	
	/* Method 2 - Complex */
	public static int sumStringComplex(String n1, String n2) {
		return getNumberFromString(n1) + getNumberFromString(n2);
 	}
	
	public static int getNumberFromString(String num) {
		int number = (int) num.charAt(0) - '0';
		for (int i=1;i<num.length();i++) {
			number = (number * 10 ) + (num.charAt(i)-'0');
		}
		return number;
	}
	
	/* Method 3  - Adding very large strings by using BigInteger java class */
	
	/* Method 4 - Adding without using BigInteger class */
	public static String sumLargeStrings(String n1, String n2) {
		
		char[] num1 = n1.toCharArray();
		char[] num2 = n2.toCharArray();
		int lennum1 = num1.length;
		int lennum2 = num2.length;
		int resultLength;
		
		if  (lennum1 >= lennum2) resultLength = lennum1+1;
		else resultLength = lennum2+1;
			
		char[] result = new char[resultLength];
		
		int i = lennum1-1, j = lennum2-1, intermediateSum, carry = 0;
		
		/* Starting the actual implementation */
		while (i >= 0 && j >= 0) { 
			// System.out.println(i + " " + j);
			intermediateSum = charToInt(num2[j]) + charToInt(num1[i]) + carry;
			
			/* Get the carry if exists */
			if (intermediateSum > 10) {
				carry = intermediateSum/10;
			}
			else {
				carry = 0;
			}
			
			/* Store the sum in the correct place */
			result[resultLength-1] =  (char) (intermediateSum%10 + '0'); 
						
			/* Decrement the counters */
			i--;
			j--;
			resultLength--;
		}
				
		/* Get the remaining digits from the bigger number */
		while (i >= 0) {
			intermediateSum = charToInt(num1[i]) + carry;
			if (intermediateSum > 10) {
				carry = intermediateSum/10;
			}else {
				carry = 0;
			}
			result[resultLength-1] =  (char) (intermediateSum%10 + '0');  
			i--;
			resultLength--;
		}
		
		while (j >= 0) {
			intermediateSum = charToInt(num2[j]) + carry;	
			if (intermediateSum > 10) {
				carry = intermediateSum/10;
			}else {
				carry = 0;
			}
			result[resultLength-1] =  (char) (intermediateSum%10 + '0');  
			i--;
			resultLength--;
		}
		
		return new String(result).substring(1);
	}
	
	public static int charToInt(char c) {
		return (c - '0');
	}
	
	public static void main (String args[]) {
		// System.out.println(sumStringsSimple("123", "4"));
		
		// System.out.println(sumStringComplex("123", "456"));
		
		System.out.println(sumLargeStrings("111111111111777990000987", "22222"));
	}
}
