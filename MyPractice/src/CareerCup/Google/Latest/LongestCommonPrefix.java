package CareerCup.Google.Latest;

import java.util.HashMap;

public class LongestCommonPrefix {
	
	private TrieNode root;
	private String list[];
	
	public TrieNode root() {
		return root;
	}
	
	public LongestCommonPrefix() {
		root = new TrieNode();
		root.setLetter('$');
	}
	
	public void createDictionary(String list[]) {
		this.list = list;
		for (String word : list) {
			insert(word);
		}
	}
	
	public void insert(String word) {
			
		TrieNode crawler = root;
		
		for (int level=0; level<word.length(); level++) {
			
			char curr = word.charAt(level);
			if (crawler.children().containsKey(curr)) { // contains
				TrieNode node = crawler.children().get(curr);
				node.incrementCount();
				crawler.children().put(curr, node);
			}
			else {	
				TrieNode node = new TrieNode(curr);
				crawler.children().put(curr, node);
			}
			
			crawler = crawler.children().get(curr);
		}
	}
	
	public String longestCommonPrefix() {
		StringBuilder sb = new StringBuilder();
		int listLength = list.length;
		
		// take the smallest string from the list
		String check = "";
		int maxLength = Integer.MAX_VALUE;
		for (String s : list) {
			if (maxLength > s.length()) {
				check = s;
				maxLength = s.length();
			}
		}
		
		TrieNode crawler = root;
				
		for (int level=0; level<check.length(); level++) {
			
			char curr = check.charAt(level);
			System.out.println(curr);
			if (crawler.children().containsKey(curr)) { // contains				
				if (crawler.children().get(curr).count() == listLength-1) {					
					sb.append(curr);
				}
				else {
					break;
				}
				crawler = crawler.children().get(curr);
			}
			else {
				break;
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		
		String list[] = {"abcdef", "abcdxxx", "abcdabcdef", "abcyy"};
		
		// Creating the dictionary
		LongestCommonPrefix dict = new LongestCommonPrefix();
		dict.createDictionary(list);
		System.out.println("Dictionary created successfully !");
		
		System.out.println("Longest common prefix is : " + dict.longestCommonPrefix());
	}

}

class TrieNode {
	
	private char letter;
	private int count;
	
	private HashMap<Character, TrieNode> children;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
	
	public TrieNode(char c) {
		this.letter = c;
		children = new HashMap<Character, TrieNode>();
		count = 0;
	}
	
	public int count() {
		return count;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public char letter() {
		return letter;
	}
	
	public HashMap<Character, TrieNode> children() {
		return children;
	}
	
	public void incrementCount() {
		this.count++;
	}

}
