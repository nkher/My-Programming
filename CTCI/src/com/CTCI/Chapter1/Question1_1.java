package com.CTCI.Chapter1;

// Program to check if a string has unique characters

public class Question1_1 {

	// only true for lower case strings 
	// TC --> O(N)
	public static boolean isUniqueChars(String str) {
		if (str.length() > 256)
			return false;
		int checker = 0;
		for (int i=0;i<str.length();i++) {
			int val = str.charAt(i) - 'a';
			if ( (checker & (1 << val)) > 0 ) {
				return false;
			}
			checker |= (1<<val);
		}
		return true;
	}
	
	// for all type of characters (assuming that the char set is ASCII, 
	// if not ASCII then we can increase the storage space)
	// TC --> O(N)
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256)
			return false;
		boolean char_set[] =  new boolean[256];
		for (int i=0;i<str.length();i++) {
			int val = str.charAt(i);
			if (char_set[val]) 
				return false;
			else 
				char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
//		String words[] = {"abcde", "hello", "apple", "kite", "padle"};
//		for (String word : words) {
//			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
//		} 
		System.out.println(isUniqueChars("nammesh"));

	}

}
