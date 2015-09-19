package CareerCup.Google;

import java.util.HashMap;
import java.util.HashSet;

public class CheckPalindromes {
	
	public TrieNode root;
	
	public CheckPalindromes() {
		createEmptyDict();
	}
	
	public void createEmptyDict() {
		root = new TrieNode();
	}
	
	public void insertIntoDict(String word) {
		int n = word.length();
		TrieNode crawler = root;
		
		if (root  == null) {
			System.out.println("Sorry there is nothing in the trie.");
			return;
		}
		
		for (int level=0;level<n;level++) {
			
			char ch = word.charAt(level); // getting the character
			if (!crawler.children.containsKey(ch)) {
				TrieNode child = new TrieNode();
				child.letter = ch; // setting the letter
				crawler.children.put(ch, child);
				crawler = crawler.children.get(ch);
			}
			else {
				crawler = crawler.children.get(ch);
			}
		}
		crawler.isWord = true;
	}
	
	public boolean exists(String word) {
		
		int n = word.length();
		TrieNode crawler = root;
		
		if (root  == null) {
			System.out.println("Sorry there is nothing in the trie.");
			return false;
		}
		
		for (int level=0;level<n;level++) {
			
			char ch = word.charAt(level);
			if (!crawler.children.containsKey(ch)) {
				return false;
			}
			else {
				crawler = crawler.children.get(ch);
			}
		}
		
		return crawler.isWord;
	}
	
	
	// concept is to start from one word and reverse trace back to the start and check if the word exists
	// if yes then it is a palindrome
	public HashMap<String, HashSet<String>> getPalindromePairs(String [] words) {
		
		HashSet<String> set = new HashSet<String>();
		HashMap<String, HashSet<String>> palindromes = new HashMap<String, HashSet<String>>();
		for (int i=0;i<words.length;i++) {
			  
			String curr = words[i];
		}
		return palindromes;
	}
	
	
	public static void main(String[] args) {
		
		CheckPalindromes cp = new CheckPalindromes();
		String words[] = {"bat", "tab", "cat", "tac", "ant", "net", "en"};
		
		for (String word : words) {
			cp.insertIntoDict(word);
		}
		
		System.out.println("Dictionary created successfully !!");
			
		HashSet<String> set = new HashSet<String>();
		for (String word : words) {
			set.add(word);
		}
		
	}

}

class TrieNode {
	char letter;
	HashMap<Character, TrieNode> children;
	boolean isWord;
	
	public TrieNode() {
		isWord = false;
		children = new HashMap<Character, TrieNode>();
	}
}
