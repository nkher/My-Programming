package CareerCup.Google;

import java.util.ArrayList;

public class StringPermutations {
	
	public static ArrayList<String> permuteString(String s) {
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		if (s.length() < 2) {
			permutations.add(s);
			return permutations;
		}
		
		char first = s.charAt(0);
		String rem = s.substring(1);
		ArrayList<String> words = permuteString(rem);
		for (String word : words) {
			for (int pos=0;pos<=word.length();pos++) {
				permutations.add(insertCharAt(word, first, pos));
			}
		}
		
		return permutations;
	}
	
	public static String insertCharAt(String word, char ch, int pos) {
		String start = word.substring(0, pos);
		String end = word.substring(pos);
		return start + ch + end;
	}
		
	public static void main(String[] args) {
		
		System.out.println(permuteString("abc").toString());
	}

}
