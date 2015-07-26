package com.CTCI5.Chapter17;

import org.CTCILibrary.AssortedMethods;

public class Question7 {
	
	public static String digits[] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	public static String teens[] = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String tens[] = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static String bigs[] = {"", "Thousand", "Million", "Billion"};
	
	public static String numberToString(int number) {
		if (number == 0) return "Zero";
		
		if (number < 0) return "Negative " + numberToString(-1 * number);
		int count  = 0;
		String str = "";
		while (number > 0) {
			if (number % 1000 != 0) {
				str = numberToString100(number % 1000) + bigs[count] + " " + str;
			}
			number = number / 1000;
			count++;
		}
		return str;
	}
	
	public static String numberToString100(int number) {
		String str = "";
		
		/* Convert 100s place */
		if (number >= 100) {
			str += digits[number/100 -1] + " Hundered ";
			number %= 100;
		}
		
		/* Convert tens place */
		if (number >= 11 && number <= 19) {
			str += teens[number-11] + " ";
			return str;
		}
		else if (number == 10 || number >= 20) {
			str += tens[number/10 - 1] + " ";
			number %= 10;
		}
		
		/* Convert ones place */
		if (number >= 1 && number <= 9) {
			str += digits[number-1];
		}
		
		return str;
	}
	
	public static void main(String args[]) {
		
		/* numbers between 100000 and 1000000 */
		for (int i = 0; i < 8; i++) {
			int value = (int) Math.pow(10, i);
			String s = numberToString(-1 * value);
			System.out.println(value + ": " + s);
		}
		
		/* numbers between 100 and 1000 */
		for (int i = 0; i < 10; i++) {
			int value = AssortedMethods.randomIntInRange(100, 1000);
			String s = numberToString(value);
			System.out.println(value + ": " + s);
		}
		
		/* numbers between 1000 and 100000 */
		for (int i = 0; i < 10; i++) {
			int value = AssortedMethods.randomIntInRange(1000, 100000);
			String s = numberToString(value);
			System.out.println(value + ": " + s);
		}
	}	
}
