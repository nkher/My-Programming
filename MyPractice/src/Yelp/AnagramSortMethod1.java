package Yelp;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramSortMethod1 {

	public static void main(String[] args) {
		String array[] = {"apple", "banana", "carrot",  "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		System.out.println(stringArrayToString(array));
		Arrays.sort(array, new AnagramComparator());
		System.out.println(stringArrayToString(array));
	}
	
	public static String stringArrayToString(String[] array) {
		StringBuilder sb = new StringBuilder();
		for (String v : array) {
			sb.append(v + ", ");
		}
		return sb.toString();
	}
}

class AnagramComparator implements Comparator<String> {
	
	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
}
 