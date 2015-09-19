package Yelp;

public class LongestPalindromeSubstring_Naive {
	
	/* Method 1 (Brute Force Solution) - Examine every substring O(N^3)*/
	public static String longestPalinSub_Naive(String s) {
		int maxPalindromeLen = 0;
		String longestPalindrome = null;
		int len = s.length();
		
		// Check all possible sub strings
		for (int i=2;i<len;i++) {
			for (int j=i+1;j<len;j++) {
				int length = j-i; // Store the length 
				String current = s.substring(i, j+1);
				if (isPalindrome(current)) {
					if (length > maxPalindromeLen) {
						longestPalindrome = current;
						maxPalindromeLen = length;
					}
				}
			}
		}
		
		return longestPalindrome;
	}
	
	public static boolean isPalindrome(String s) {
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
			String s = "wdqwdnitinwqdwqd";
			System.out.println(longestPalinSub_Naive(s));
	}

}
