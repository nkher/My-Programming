package Yelp;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class AnagramSortMethod2 {

	public static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static void sort(String[] array) {
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		
		/* Grouping words by anagram */
		for (String s : array) {
			String key = sortChars(s);
			if (!hash.containsKey(key)) {
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
			hash.put(key, anagrams);
		}
		
		/* Convert hash table to array */
		int index = 0;
		for (String key : hash.keySet()) {
			LinkedList<String> list = hash.get(key);
			for (String t : list) {
				array[index++] = t;
			}
		}
	}
	
	public static String stringArrayToString(String a[]) {
		StringBuilder sb = new StringBuilder();
		for (String s : a) {
			sb.append(s + ", ");
		}
		return new String(sb);
	}
	
	public static void main(String[] args) {
		String array[] = {"apple", "banana", "carrot",  "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		sort(array);
		System.out.println(stringArrayToString(array));
	}

}
