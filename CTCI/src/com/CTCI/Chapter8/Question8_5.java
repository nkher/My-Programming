package com.CTCI.Chapter8;

import java.util.ArrayList;

public class Question8_5 {
	
	public static void printParen(ArrayList<String> permutations, int left, int right, char str[], int count) {
		if (right < left || left < 0) return;
		
		if (left == 0 && right == 0) {
			String s = String.copyValueOf(str);
			permutations.add(s);
		}
		else {
			if (left > 0) {
				str[count] = '(';
				printParen(permutations, left-1, right, str, count+1);
			}
			if(right > left) {
				str[count] = ')';
				printParen(permutations, left, right-1, str, count+1);
			}
		}
	}
	
	public static ArrayList<String> generateParen(int count) {
		ArrayList<String> permutations = new ArrayList<String>();
		char str[] = new char[count * 2];
		printParen(permutations, count, count, str, 0);
		return permutations;
	}
	
	public static void main(String[] args) {
		ArrayList<String> permutations = new ArrayList<String>();
		permutations = Question8_5.generateParen(3);
		for(String per : permutations)
			System.out.println(per);
	}

}
