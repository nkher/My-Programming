package BloombergQuestions;

public class LongestPalindrome {
	
	// O(N^2) solution with O(N2 space)
	public static String longestPal(String s) {
		int n = s.length();
		int longestBegin = 0;
		int maxLen = 1;
		boolean table[][] = new boolean[100][100];
		for (int i=0;i<n;i++) {
			table[i][i] = true;
		}
		for (int i=0;i<n-1;i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				table[i][i+1] = true;
				longestBegin = i;
				maxLen = 2;
			}
		}
		for (int len=3;len<=n;len++) {
			for (int i=0;i< (n-len+1) ;i++) {
				int j = i+len-1;
				if((s.charAt(i) == s.charAt(j)) && (table[i+1][j-1])) {
					table[i][j] = true;
					longestBegin = i;
					maxLen = len;
				}
			}
		}
		return s.substring(longestBegin, maxLen);
	}
	
	public void print(char[] a, int low, int high) {
		for(int i=low;i<=high;i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public int longestPal2(String s) {
		int maxLength = 1;
		int start = 0, len = s.length();
		int low, high;
		char a[] = s.toCharArray();
		
		for(int i=1;i<a.length;i++) {
			// Find the longest even length palindrome with center points
	        // as i-1 and i.
			low = i-1;
			high =i;
			while(low >= 0 && high < len && a[low] == a[high]) {
				if(high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
			
			// Find the longest odd length palindrome with center 
	        // point as i
			low = i-1;
			high = i+1;
			while (low>=0 && high < len && a[low] == a[high]) {
				if(high - low+1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		
		}
		// printing the palindrome
		System.out.println("The longest palindrome is : ");
		print(a, start, start+maxLength-1);
		return maxLength;
	}
	
	public void manachersAlgorithm(String s) {
		
	}
	
	
	public static void main(String[] args) {
		LongestPalindrome longestP = new LongestPalindrome();
		String s = "forgeeksskeegfor";
		int len = longestP.longestPal2(s);
		System.out.println(len);
	}

}
