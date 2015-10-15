package DynamicPrograming;

public class PalindromePartition {
	
	public int minimumCuts(char string[]) {
		
		int n = string.length;
		int T[][] = new int[n][n];
		boolean P[][] = new boolean[n][n];
		
		// fill the length 1 substrings
		for (int i=0;i<n;i++) {
			P[i][i] = true;
		}
		
		for(int length=2;length<=n;length++) { // checking for string lengths from 2 to length of the passed string
			
			for (int i=0;i<=n-length;i++) {
				
				int j = i + length - 1; // getting the index to the last character of the substring of current length
				
				/* Checking whether the passed substring is a palindrome itself or not */
				if(length == 2) {
					P[i][j] = string[i] == string[j]; // will assign true of both characters are equal
				}
				else {
					// checks the current string's first and last character as well as second and second last character
					P[i][j] = (string[i] == string[j]) && P[i+1][j-1]; 
				}
				/* End of check */
				
				// if it is a palindrome then put a 0 in the answer array
				if (P[i][j]) T[i][j] = 0;
				
				else {
					T[i][j] = Integer.MAX_VALUE;
					int r = 0;
					
					for (int k=i;k<j;k++) {
						r = 1 + T[i][k] + T[k+1][j];
						if (r < T[i][j])
							T[i][j] = r;
					}
				}
			}
		}
		
		return T[0][n-1]; // return the top right value
	}
	
	public static void main(String[] args) {
		 // String str = "ABCCDCCLMLCCD";
		 String str = "abcbm";
		 PalindromePartition pp = new PalindromePartition();
		 int r = pp.minimumCuts(str.toCharArray());
		 System.out.println(r);
	}
}
