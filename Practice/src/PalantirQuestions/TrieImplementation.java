package PalantirQuestions;

public class TrieImplementation {
	
	TrieNode root;
	int count;
	
	public TrieImplementation() {
		root = new TrieNode();
		root.children = initializeNodeChildren(root.children);
		count = 0;
	}
	
	public TrieNode getNewNode() {
		TrieNode node = new TrieNode();
		node.children = initializeNodeChildren(node.children);
		return node;
	}
	
	public TrieNode[] initializeNodeChildren(TrieNode[] children) {
		for (int i=0;i<children.length;i++) {
			children[i] = null;
		}
		return children;
	}
	
	// assumes that you are passing lower case words
	public void insert(char[] key) {
		int level, length = key.length, index;
		count++;
		TrieNode pCrawl = this.root;
		for (level=0;level < length;level++) {
			index = CHAR_TO_INDEX(key[level]);
			if(pCrawl.children[index] == null)
				pCrawl.children[index] = getNewNode();
			pCrawl = pCrawl.children[index];
		}	
		// mark the last node as the leaf
		pCrawl.value = this.count;
	}
	
	// assumes that you are passing lower case words
	public boolean search(char[] key) {
		int level, length = key.length, index;
		TrieNode pCrawl = this.root;
		for (level=0;level<length;level++) {
			index = CHAR_TO_INDEX(key[level]);
			if (pCrawl.children[index] == null)
				return false;
			pCrawl = pCrawl.children[index];
		}
		if (pCrawl.value > 0)
			return true;
		return false;
	}
	
	public int CHAR_TO_INDEX(char c) {
		return ((int)c - (int)'a');
	}
	
	public static void main(String[] args) {
		TrieImplementation ti = new TrieImplementation();
		String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		
		for (String s : keys) {
			ti.insert(s.toCharArray());
		}
		
		String a = "there";
		String b = "ab";
		System.out.println(ti.search(a.toCharArray()) + " ");
		System.out.println(ti.search(b.toCharArray()));
	 
	}
}

class TrieNode {
	int value;
	TrieNode children[];
	
	public TrieNode() {
		children = new TrieNode[26];
	}
}
