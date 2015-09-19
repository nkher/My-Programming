package org.SuffixArray;

import java.lang.reflect.Array;
import java.util.Scanner;

class Suffix{
	int index;
	String suffix;
}

public class SuffixArray{
	
	public Suffix[] buildSuffixArray(String text, int n){

		text = text.toLowerCase();
		
		//A structure to store the suffixes
		Suffix[] suffixes = new Suffix[n];
		
		//Storing the Suffixes in the Suffixes Array
		for(int i=0;i<n;i++){
			Suffix suffixObject = new Suffix();
			suffixObject.index = i;
			suffixObject.suffix = text.substring(i,text.length());
			suffixes[i] = suffixObject;
		}	
		
		//Sorting the Strings
		sort(suffixes, suffixes.length);
		
		return suffixes;
	}
	
	//Bubble Sort
	public Suffix[] sort(Suffix[] suffixes, int n){
		
		Suffix tempSuffix = new Suffix();
		
		for(int j=0; j<=n-1; j++){
			for(int m=0; m<n-j-1; m++){
				if(suffixes[m].suffix.compareTo(suffixes[m+1].suffix) > 0){
					tempSuffix = suffixes[m];
					suffixes[m] = suffixes[m+1];
					suffixes[m+1] = tempSuffix;			
				}	
			}
		}
		return suffixes;
	}
	
	//Performing a Binary Search on the constructed Array
	//Text is the given string and Pattern is the string to be searched
	public int search(String pattern, String text, Suffix[] suffixes, int n){
		
		int mid=-1;
		
		//Conducting a binary search on the suffix array
		int start=0;
		int end=n-1;
		while(start<=end){
			mid = (start + end)/2;
			if(suffixes[mid].suffix.equals(pattern))
				return suffixes[mid].index;
			else if(suffixes[mid].suffix.compareTo(pattern) > 0)
				end=mid-1;//start=mid+1;
			else
				start=mid+1;//end=mid-1;
		}		
		return suffixes[mid].index;
	}
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		SuffixArray suffArr = new SuffixArray();
		
		System.out.println("Please Enter a String to get all the Suffixes");
		String text = input.nextLine();
		int n = text.length();
		
		//Building the Suffixes
		Suffix suffixes[] = new Suffix[n];
		suffixes = suffArr.buildSuffixArray(text, n);
		
		for(int i=0;i<suffixes.length;i++){
			System.out.println("Index " +suffixes[i].index + " Value : " + suffixes[i].suffix);
		}
		
		System.out.println("Enter the Item To be searched");
		String pattern = input.nextLine();
		
		int index = suffArr.search(pattern, text, suffixes, n);
		if(index != -1)
			System.out.println("Found at index : " + index);
		else
			System.out.println("Not Found");
	}	
}




 