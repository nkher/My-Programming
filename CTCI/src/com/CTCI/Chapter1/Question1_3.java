package com.CTCI.Chapter1;

// Removing duplicates from a string
public class Question1_3 {
	
	// TC --> O(N^2)
	// SC --> less than O(N), only few variables
	public static void removeDuplicates(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		int tail = 1;
		for (int i=1;i<len;++i) {
			int j;
			for (j=0;j<tail;++j) {
				if (str[i] == str[j]) break;
			}
			// Concept is till the time there is no duplicate i and tail have the same value as they keep incrementing
			// When a match tail lags and i increases and slowly each element or character get pushed onto its current but one index.
			// If two duplicates are found then current but one index.
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}
	
	// TC --> O(N)
	// SC --> O(N)
	public static void removeDuplicatesEff(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		boolean hit[] =  new boolean[256];
		for (int i=0;i<hit.length;i++) {
			hit[i] = false;
		}
		hit[str[0]] = true; // Initializing the first one to true
		int tail = 1;
		for (int i=1; i<str.length;i++) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
	}
	
	public static void main(String[] args) {
		char test1[] = {'a','b','a','c','d'};
		char test[] = {'n','a','m','m','e','s','h'};
		removeDuplicates(test);
		System.out.println(test);
		
		removeDuplicatesEff(test1);
		System.out.println(test1);
	}

}
