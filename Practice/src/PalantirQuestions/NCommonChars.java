package PalantirQuestions;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class NCommonChars {
	
	
	@SuppressWarnings("unchecked")
	public static HashMap<Character, Integer> sortByValues(HashMap<Character, Integer> hashmap) {
		@SuppressWarnings("rawtypes")
		LinkedList list = new LinkedList(hashmap.entrySet());
		
		// Custom comparator
		Collections.sort(list, new CustomComparator());
		
		HashMap<Character, Integer> sortedHashMap = new LinkedHashMap<Character, Integer>();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry<Character, Integer> entry = ( Map.Entry<Character, Integer> ) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
	
	public static void getNMostCommonChars(String s, int N) {
		char c[] = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : c) {
			if (!map.containsKey(ch))
				map.put(ch, 1);
			else
				map.put(ch, map.get(ch)+1);
		}
		
		map = sortByValues(map);
		int count = 0;
		for (Character ch : map.keySet()) {
			count++;
			System.out.println("Key : " + ch + " Value : " + map.get(ch));
			if (count == N) break;
		}
	}
	
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		getNMostCommonChars(s, 3);
	}
}

class CustomComparator implements Comparator<Map.Entry<Character, Integer>> {
	@Override
	public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
		return o2.getValue().compareTo(o1.getValue());
	}
}
