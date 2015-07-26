package com.CTCI5.Chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.CTCI.Chapter8.Question8_5;

public class Question6 {
	
	// Method 1 
	public static Set<String> generateParens(int remaining) {
		Set<String> set = new HashSet<String>();
		if (remaining == 0) {
			set.add("");
		}
		else {
			Set<String> previous = generateParens(remaining - 1);
			for (String s : previous) {
				for (int i=0;i<s.length();i++) {
					if (s.charAt(i) == '(') {
						String st = insertInside(s, i);
						// Add it to the set if it is not present
						set.add(st);
					}
				}
				set.add("()" + s);
			}
		}
		return set;
	}
	
	public static String insertInside(String s, int leftIndex) {
		String left = s.substring(0, leftIndex+1);
		String right = s.substring(leftIndex+1, s.length());
		return left + "()" + right;
	}
	
	// Method 2
	public static ArrayList<String> generateParens2(int count) {
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}
	
	public static void addParen(ArrayList<String> list, int left, int right, char[] str, int count) {
		if (left < 0 || right < left) return; // invalid state
		
		if (left == 0 && right == 0) {
			String s = String.copyValueOf(str);
			list.add(s);
		}
		else {
			// Add left paren
			if (left > 0 ) {
				str[count] = '(';
				addParen(list, left-1, right, str, count+1);
			}
			if (right > left) {
				str[count] = ')';
				addParen(list, left, right-1, str, count+1);
			}
		}
	}
	
	public static void main(String args[]) {
//		Set<String> set = Question6.generateParens(3);
//		for (String s : set)
//			System.out.print(s + " ");
		
		ArrayList<String> permutations = new ArrayList<String>();
		permutations = Question6.generateParens2(3);
		for(String per : permutations)
			System.out.println(per);
	}
}
