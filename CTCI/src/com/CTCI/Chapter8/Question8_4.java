package com.CTCI.Chapter8;

import java.util.ArrayList;

public class Question8_4 {
	
	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (s.length() == 0 || s == null) return null;
		if (s.length() < 2) {
			permutations.add(s);
			return permutations;
		}
		
		char first = s.charAt(0); // Getting the character at the first index
		String remainder = s.substring(1); // Removing the first character
		ArrayList<String> words = getPerms(remainder);
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
		String s = "this is";
		ArrayList<String> permutations = getPerms(s);
		for(String perms : permutations) 
			System.out.print(perms + "  ");
	}

}
