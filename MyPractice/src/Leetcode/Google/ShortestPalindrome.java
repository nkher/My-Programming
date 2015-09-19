package Leetcode.Google;

public class ShortestPalindrome {
	
	public static String shortestPalindrome(String s) {
		
		char[] str = s.toCharArray();
		int end = s.length()-1;
		
		int i = end;
		while (i > 0) {
			if (isPalindrome(str, 0, i)) {
				break;
			}
			i--;
		}
		
		StringBuilder sb = new StringBuilder(s);;
		
		//System.out.println(sb.toString());
		
		for (int k=i+1; k<=end; k++) {
			sb.insert(0, s.charAt(k));
		}
				
		return sb.toString();
	}
	
	public static boolean isPalindrome(char[] str, int start, int end) {
		while (start < end) {
			if (str[start] != str[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(shortestPalindrome("abcd"));
		
		System.out.println(shortestPalindrome("aacecaaa"));
	}

}
