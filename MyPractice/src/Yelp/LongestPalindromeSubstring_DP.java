package Yelp;

public class LongestPalindromeSubstring_DP {
	
	/* O(N^2) solution for the longest palindrome substring problem.
	 * The idea is similar to this post. We maintain a boolean table[n][n] that is filled in bottom up manner. 
	 * The value of table[i][j] is true, if the substring is palindrome, otherwise false. 
	 * To calculate table[i][j], we first check the value of table[i+1][j-1], 
	 * if the value is true and str[i] is same as str[j], then we make table[i][j] true. Otherwise, the value of table[i][j] is made false.
	 */
	
	// Space and Time complexity is O(N^2)
	
	/* Method to print a substring */
	public static void printSubString(String s, int low, int high) {
		for (int i=low;i<=high;i++) {
			System.out.print(s.charAt(i));
		}
		System.out.println();
	}
	
	/* Function to get the longest palindrome substring from a string */
	public static int longestPalindromeSubstring_DP(String s) {
		int len = s.length(), i, j;
		
		// Table[i][j] will be false if substring s[i..j] is not palindrome.
	    // Else table[i][j] will be true
		boolean table[][] = new boolean[len][len];
		
		// Initialize to false
		for (i=0;i<len;i++) {
			for (j=0;j<len;j++)
				table[i][j] = false;
		}
		
		// All substrings of length 1 are palindrome
		int maxLength = 1;
		for (i=0;i<len;++i) {
			table[i][i] = true;
		}
		
		// Check for substring of length 2
		int start = 0;
		for (i=0; i<len-1; ++i) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i+1] = true;
				start = i;
				maxLength = 2;
			}
		}
		
		// Check for substrings of length greater than 2
		// k is the length of the substring
		for (int k=3;k<=len;k++) {
			
			// Fix the starting index
			for (i=0;i< (len-k+1) ;i++) {
				
				// Get the ending index of substring from
	            // starting index i and length k
				j = i + k - 1;
				
				// checking for sub-string from ith index to
	            // jth index iff str[i+1] to str[j-1] is a
	            // palindrome
				if (table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
					table[i][j] = true;
					
					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		
		System.out.println("Longest palindrome substring is: ");
		printSubString(s, start, (start + maxLength - 1));
		
		return maxLength;
	}
	
	
	public static void main(String[] args) {
		String s = "forgeeksskeegfor";
		System.out.println("Length is : " + longestPalindromeSubstring_DP(s));
		
		String r = "kjbdhbdejwje";
		System.out.println("Length is : " + longestPalindromeSubstring_DP(r));
	}

}
