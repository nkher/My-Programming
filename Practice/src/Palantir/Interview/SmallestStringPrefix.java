package Palantir.Interview;

public class SmallestStringPrefix {
	
	DictionaryNode root;
	
	public SmallestStringPrefix() {
		root = new DictionaryNode();
	}
	
	public void insert(String word) {
		insert(word, root, 0);
	}
	
	private void insert(String word, DictionaryNode node, int position) {
		if (position == word.length()) {
			System.out.println(word + " inserted successfully.");
			return;
		}
		int index = charToInt(word.charAt(position));
		/* insert the current character */
		if (node.children[index] == null) {
			DictionaryNode child = new DictionaryNode();
			child.letter = word.charAt(position);
			child.count = 1;
			node.children[index] = child;
		}
		else {
			node.children[index].count++;
		}
		/* Recurse */
		insert(word, node.children[index], position+1);
	}
	
	public String lookupMinPrefix(String word) {
		StringBuffer sb = new StringBuffer();
		String s = lookupMinPrefix(word, root, 0, new StringBuffer());
		System.out.println("Returned " + sb);
		return s;
	}
	
	private String lookupMinPrefix(String word, DictionaryNode node, int position, StringBuffer sb) {
		if (position == word.length()) {
			return new String(sb);
		}
				
		int index = charToInt(word.charAt(position));
				
		/* Return if minimum prefix is reached */
		if (node.count == 1) {
			return new String(sb);
		}
		
		if (node.children[index] == null) {
			System.out.println(word + " not present try another word or else add it !");
		} else {
			/* Append */
			sb.append(node.children[index].letter);
			/* Recurse */
			lookupMinPrefix(word, node.children[index], position+1, sb);
		}
		return new String(sb);
	}
	
	public int charToInt(char c) {
		return ((int)c - (int)'a');
	}
	
	public static void main(String args[]) {
		SmallestStringPrefix ssp = new SmallestStringPrefix();
		String wordlist[] = {"abc", "aab", "xyz"};
		
		// Inserting
		for (String word : wordlist)
			ssp.insert(word);
		
		
		String minPrefix;
		// Look up
		for (String word : wordlist) {
			minPrefix = ssp.lookupMinPrefix(word);
			System.out.println("Min Prefix for  " + word + " is " + minPrefix);
		}
	}
}

class DictionaryNode {
	char letter;
	DictionaryNode children[];
	int count;
	
	public DictionaryNode() {
		children = new DictionaryNode[26];
		count = 0;
	}
}
