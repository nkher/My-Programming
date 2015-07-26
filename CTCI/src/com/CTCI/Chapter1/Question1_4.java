package com.CTCI.Chapter1;

// Program to check if two numbers are anagrams or not
public class Question1_4 {
	
	// Solution 1 by Sorting both the strings
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean permutation(String s, String t) {
		return sort(s).equals(sort(t));
	}
	
	// Solution2 by checking if two strings have identical counts for each unique character
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int letters[] = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // Getitng the number of unique characters in s
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		
		for (int i=0;i<t.length();i++) {
			int c = t.charAt(i);
			if(letters[c] == 0) { // Found a char in t more number of times than s or may be once in t and 
								  // zero times in s
				return false;
			}
			--letters[c]; // If not zero then decrementing the count
			if (letters[c] == 0) {
				++num_completed_t;
				if(num_completed_t == num_unique_chars) { // Checking for final condition where we ensure 
														  // if all chars have been visited
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}, {"iceman", "ceamin"}};
		for (String pair[] : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ", " + anagram);
			System.out.println(anagram(word1, word2));

		}
	}

}
