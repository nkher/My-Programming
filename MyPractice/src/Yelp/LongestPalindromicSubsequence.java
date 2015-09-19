package Yelp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	
	/* We start by checking one char at a time and then 2 and so on ....
	 * and store it in the double array 
	 * O(N^2)
	 */
	
	public static int lps(String s, int L[][]) {
		int len = s.length();
		int i, j, substr_len;
		
		L = new int[len][len];
		
		/* Store all the palindrome of length 1 */
		for (i=0;i<len;i++)
			L[i][i] = 1;
		
		/* For all substring lengths */
		for (substr_len=2; substr_len<=len; substr_len++) {
			
			for (i=0; i< (len-substr_len+1); i++) {		
				
				j = i + substr_len - 1; /* End character for that substring length */
				
				/* Specific case when substring length is = to 2 */
				if (s.charAt(i) == s.charAt(j) && substr_len == 2) {
					L[i][j] = 2;
				}
				/* Case where substring length is > than 2 and last and first character is equal */
				else if (s.charAt(i) == s.charAt(j)) {
					L[i][j] = L[i+1][j-1] + 2; // 2 comes from the first and last character + the lon pal sub sequence of substring s.substring(i+1,j-1)
					
				} 
				else { /* case where greater than 2 and not equal */
					L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
				}
			}
		}
		
		System.out.println(getLongestPalindromicString(s, L));
		//printArr(L);
		return L[0][len-1];
	}
	
	public static void printArr(int L[][]) {
		for (int i=0;i<L.length;i++) {
			for (int j=0;j<L[i].length;j++) {
				System.out.print(L[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	// This is not functioning properly
	public static String getLongestPalindromicString(String s, int L[][]) {
		int index = 0, len = s.length();
		
		/* Stores the max length of the palindrome */
		int pal_len = L[0][len-1];
		int i = 0, j = pal_len; //  initialize i to start and j to last
		
		/* To store the new palindrome */
		char[] x = new char[pal_len];
		int last = pal_len-1;
					
		while (i <= j) {
			if (L[i][j-1] == L[i+1][j]) { 
				
				x[index] = s.charAt(i);
				x[last-index] = s.charAt(j); 
				//System.out.println("i is : " + i + ", j is : " + j);
				i++;
				j--;
				index++;
				
				System.out.println("Now : " + Arrays.toString(x));
			}
			else if (L[i][j-1] < L[i+1][j]){
				i++; // go down
			}
			else {
				j--; // go left
			}
		}		
		return new String(x);	
	}
	
	public static int calculate(char []str){
        int T[][] = new int[str.length+1][str.length+1];
        for(int i=0; i < str.length; i++){
            T[1][i] = 1;
        }
        for(int c = 2; c <= str.length; c++){
            for(int i = 1; i <= str.length-c+1; i++){
                if(str[i-1] == str[i-1 + c-1] && c == 2){
                    T[c][i] = 2;
                }else if(str[i-1] == str[i+c-2]){
                    T[c][i] = T[c-2][i+1] + 2;
                }else{
                    T[c][i] = Math.max(T[c-1][i+1], T[c-1][i]);
                }
            }
        }
        return T[str.length][1];
    }

	public static void main(String args[]) {
		
		
		int L[][] = null;
		System.out.println("Length of largest palindromic subsequence in 'agbdba' is : " + lps("agbdba", L));

		//System.out.println("Length of largest palindromic subsequence in 'asndfifstdfifdnf' is : " + lps("asndfifstdfifdnf", L));
		
		System.out.println("Length of largest palindromic subsequence in 'newidewdtidewn' is : " + lps("newidewdtidewn", L));
		
		//System.out.println("Length of largest palindromic subsequence in 'asndfifstdfifdnf' is : " + calculate("asndfifstdfifdnf".toCharArray()));
	}
	    
}	
