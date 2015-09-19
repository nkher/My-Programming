package Yelp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak_DP {
	
	public static String wordBreakDP(String word, Set<String> dict) {
		int n = word.length();
		int T[][] = new int[n][n];
		
		for (int i=0;i<T.length;i++) {
			for (int j=0;j<T[i].length;j++) {
				T[i][j] = -1; // -1 means that the word cannot be split
			}
		}
		
		/* Start filling up the matrix */
		for (int l=1; l<=word.length(); l++) {
			
			for (int i=0; i < word.length()-l+1; i++) {
				
				int j = i+l-1;
				String str = word.substring(i, j+1);
				
				/* If the string between i and j is in the dictionary then T[i][j] is true */
				if (dict.contains(str)) {
					T[i][j] = 1;
					continue;
				}
				
				/* Find a k between i+1 to j such that T[i][k-1] and T[k][j] both are true */
				for (int k=i+1; k<=j; k++) {
					if (T[i][k-1] != -1 && T[k][j] != -1) {
						T[i][j] = k;
						break;
					}
				}
			}
		}
		
		/* To check if the last digit index is not -1 (i.e it is a part of a valid word) */
		if (T[0][n-1] == -1) return null;
		
		/* Getting the broken words back in a string buffer */
		StringBuffer sb = new StringBuffer();
		int i=0, j=n-1;
		while (i < j) {
			int k = T[i][j];
			if (i == k) {
				sb.append(word.substring(i, j+1));
				break;
			}
			sb.append(word.substring(i, k) + " ");
			i = k;
		}
		
		return sb.toString();
	}
	
	
	public static void main(String args[]) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        String str = "Ihadliketoplay";
        
        WordBreak_DP wrdbrk = new WordBreak_DP();
        System.out.println(wrdbrk.wordBreakDP(str, dictionary));
	}
}
