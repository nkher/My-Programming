package PatternSearching;

import java.util.Arrays;

public class KMPSearch {

	// O(n) worst case
	public void kmpSearch(char[] text, char[] pattern){
		
		int textLength = text.length;
		int patternLength = pattern.length;
		
		int[] lps = new int[patternLength];
		int j = 0;
		
		computeLPSArray(pattern, patternLength, lps);
		System.out.println("Lps is " + Arrays.toString(lps));
		int i = 0;
		while(i<textLength) {
			if(pattern[j] == text[i]) {
				i++;
				j++;
			}
			if(j == patternLength)
			{
				System.out.println("Pattern found at index: " + (i-j));
				j = lps[j-1];
				System.out.println(j);
			}
			
			//Mismatch after j matches
			else if( (i < textLength) && pattern[j] != text[i])
			{
				if(j != 0)
					j = lps[j-1];
				else
					i=i+1;
			}
		}
	}
	
	public void printArray(int a[]) {
		for (int i=0;i<a.length;i++)
			System.out.print(a[i] + " ");
	}
	
	public void computeLPSArray(char pattern[], int patternLength, int lps[]){
		
		int len = 0;
		int i = 0;
		
		//Starting element of lps is always 0
		lps[0] = 0;
		i = 1;
		
		while(i<patternLength){
			if(pattern[i] == pattern[len]){
				len++;
				lps[i] = len;
				i++;
			}
			else{ //if (pattern[i] != pattern[len])
				if(len != 0){
					len = lps[len-1];
					//len = 0;
					//Do not increment i here 
				}
				else{ //if (len == 0)
					lps[i] = 0;// put a zero when they dont match and len == 0
					i++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
			
		KMPSearch kmp = new KMPSearch();
//		String pattern = "ABABCABAB"; // 001201234
//		String text = "ABABDABACDABABCABABABABCABAB";
		String pattern = "abab"; // 001201234
 		String text = "cababbdabaad";
		char[] pattern1 = pattern.toCharArray();
		char[] text1 = text.toCharArray();
		
		kmp.kmpSearch(text1, pattern1);
		
		System.out.println(Arrays.toString(pattern1));
		System.out.println(Arrays.toString(text1));
		
		/*for(int i=0;i<lps.length;i++){
			System.out.print(lps[i] + " ");
		}*/	
	}
}
