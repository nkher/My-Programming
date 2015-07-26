package com.CTCI5.Chapter9;

import java.util.ArrayList;

public class Question5 {

	// n! is the time complexity
	public static ArrayList<String> getPermutations(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (s.length() < 2) {
			permutations.add(s);
			return permutations;
		}
		
		char first = s.charAt(0);
		String remainder = s.substring(1);
		ArrayList<String> words = getPermutations(remainder);
		for (String word : words) {
			for (int j=0;j<=word.length();j++) {
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int position) {
		String start = word.substring(0, position);
		String end = word.substring(position);
		return start + c + end;
	}
	
	public static void main(String[] args) {
		String s = "abc";
		ArrayList<String> perms = getPermutations(s);
		System.out.println(perms.toString());
	}
}
