package com.CTCI5.Chapter17;

import java.util.HashMap;

public class Question9 {
	
	public static HashMap<String, Integer> setupDictionary(String[] book) {
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		
		for (String word : book) {
			word = word.toLowerCase();
			word = word.trim();
			if(dictionary.containsKey(word)) {
				dictionary.put(word, dictionary.get(word) + 1);
			}
			else
				dictionary.put(word, 1);
		}
		return dictionary;
	}
	
	public static int getFrequency(HashMap<String, Integer> dictionary, String word) {
		if (dictionary == null || word == null) return -1;
		
		word = word.toLowerCase();
		if(dictionary.containsKey(word))
			return dictionary.get(word);
		
		return 0;
	}
	
	public static void main(String[] args) {
		String[] words = {"the", "Lara", "and", "outcropping", "Career", "it", "it", "it", "career"};
		HashMap<String, Integer> dictionary = setupDictionary(words);
		
		String searchKey = "career";
		System.out.println(searchKey + " : " + getFrequency(dictionary, searchKey));
		
		searchKey = "it";
		System.out.println(searchKey + " : " + getFrequency(dictionary, searchKey));
	}
}
