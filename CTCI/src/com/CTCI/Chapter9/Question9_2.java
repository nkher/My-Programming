package com.CTCI.Chapter9;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

import org.CTCILibrary.AssortedMethods;

public class Question9_2 {
	
	public static String sortChars(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static void sort(String array[]) {
		Hashtable<String, LinkedList<String>> hashTable =  new Hashtable<String, LinkedList<String>>();
		
		// Making a Linked list for all the anagrams
		for(String s : array) {
			String key = sortChars(s);
			if(!hashTable.contains(key)) {
				hashTable.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hashTable.get(key);
			anagrams.push(s);
		}
		
		// Getting all the anagrams in order from the HashTable
		int index = 0;
		for (String key : hashTable.keySet()) {
			LinkedList<String> anagrams = hashTable.get(key);
			for(String s : anagrams) {
				array[index] = s;
				index++;
			}
		}
	}
	
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		sort(array);
		System.out.println(AssortedMethods.stringArrayToString(array));
	}

}
