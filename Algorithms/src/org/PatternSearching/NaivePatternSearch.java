package org.PatternSearching;
import java.util.Scanner;

/* 
 * Number of comparisons in worst case is O(m*(n-m+1)). 
 * Although strings which have repeated characters are not likely to appear in English text, 
 * they may well occur in other applications (for example, in binary texts). The KMP matching algorithm improves the worst case to O(n).
 * */

public class NaivePatternSearch {

	public void naivePatternSearch(String text, String pattern){
		
		text = text.toLowerCase();
		pattern = pattern.toLowerCase();
		char[] completeText = text.toCharArray();
		char[] pattern1 = pattern.toCharArray();
		int textLength = text.length();
		int patternLength = pattern.length();
		
		//This will start from 0th index of the text and will loop through till a length where 
		//Length is equal to (Length of text - Length of pattern)
		//This will minimize number of searches as if we don't find the element at the first index
		//of the pattern at the last index of the length then the complete length of the pattern 
		//would become greater than the remaining length of the pattern
		for (int i=0;i<=textLength-patternLength;i++){
			
			int j;
			//Now here will we loop through the length of the pattern to be searched and 
			//We are comparing each element in the pattern with each element in the text starting with 
			//The first one in an iterative fashion.
			for (j=0;j<patternLength;j++){
				if(pattern1[j] != completeText[i+j])
					break;
			}
			if(j == patternLength){
				System.out.println("Pattern is found at index : " + i);
			}
		}
	}
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		NaivePatternSearch npv =  new NaivePatternSearch();
		
		System.out.println("Please enter the Text.");
		String text = input.nextLine();
		
		System.out.println("Please enter the Pattern");
		String pattern = input.nextLine();
		npv.naivePatternSearch(text, pattern);
	}

}
