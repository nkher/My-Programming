package org.PatternSearching;
import java.util.Scanner;

public class OptimizedNaiveSearch {

	public void optimizedNaiveSearch(String text, String pattern){
		
		text = text.toLowerCase();
		pattern = pattern.toLowerCase();
		int textLength = text.length();
		int patternLength = pattern.length();
		char[] text1 = text.toCharArray();
		char[] pattern1 = pattern.toCharArray();
		
		int i=0;
		
		while(i < textLength - patternLength){	
			int j;
			for (j=0;j<patternLength;j++){
				if(text1[i+j] != pattern1[j])
					break;
			}
			if(j == patternLength){
				System.out.println("Pattern found at index : " + i);
				if (text1[i+1] == pattern1[0]) { // suppose we have a match for the next window, we dont want to miss it
					i++;
				}
				else {
					i = i + patternLength;
				}
			}
			else if(j == 0){
				i++; //Sliding the pattern by 1 if no match found 
			}
			else{
				i = i + j; //Slide the pattern by j
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Text");
		String text = input.nextLine();
		
		System.out.println("Please enter the Pattern");
		String pattern = input.nextLine();
		
		OptimizedNaiveSearch object = new OptimizedNaiveSearch();
		object.optimizedNaiveSearch(text, pattern);
	}

}
