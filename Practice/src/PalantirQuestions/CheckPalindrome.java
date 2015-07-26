package PalantirQuestions;

import java.util.HashMap;

public class CheckPalindrome {

	public static boolean checkPalindrome(String s) {
		if (s.length() < 3) return true;
		int max_allowed_unique = 0;
		if (s.length()%2 == 0) max_allowed_unique = s.length() / 2;
		else max_allowed_unique = (s.length() / 2) + 1;
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
		for (int j=0;j<s.length();j++) {
			if (!countMap.containsKey(s.charAt(j))) 
				countMap.put(s.charAt(j), 1);
			else 
				countMap.put(s.charAt(j), countMap.get(s.charAt(j)) + 1);
		}
		int num_unique_chars = countMap.size();
		if (num_unique_chars > max_allowed_unique)
			return false;
		int odd_counts=0;
		for (Character c : countMap.keySet()) {
			int count = countMap.get(c);
			// if (count == 1) one_counts++;
			if ((count&1) != 0) odd_counts++;
		}
		//if (one_counts > 1) return false;
		if (s.length()%2 == 0 && odd_counts > 1) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "abbaeefee";		
		if (CheckPalindrome.checkPalindrome(s)) {
			System.out.println("Yes a palindrome can be formed");
		}
		else {
			System.out.println("Palindrome cannot be formed");
		}
	}

}
