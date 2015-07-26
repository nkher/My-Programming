package PalantirQuestions;

public class SpellChecker {

	private Node root;
	
	public void insertWord(String word, int position, Node node) {
		if (word.length() == position) {
			root.word = word;
			return;
		}
		if (root.pointers[word.charAt(position)] == null) {
			Node newNode = new Node();
			newNode.info = word.charAt(position);
			root.pointers[word.charAt(position)] = newNode;
			insertWord(word, position+1, root.pointers[word.charAt(position)]);
		}
		else 
			insertWord(word, position+1, root.pointers[word.charAt(position)]);
	}
	
	public void find(String key, int position, Node node) {
		if (key != root.word && root.pointers[key.charAt(position)] != null)
			find(key, position+1, root.pointers[key.charAt(position)]);
		else if (key == root.word) {
			System.out.println("The spelling of the word " + root.word + " is correct.");
		}
	}
	
	public void suggest(String key, int position, Node node) {
		if (key != root.word && root.pointers[key.charAt(position)] != null)
			suggest(key, position+1, root.pointers[key.charAt(position)]);
		else
			printAll(node);
	}
	
	public void printAll(Node node) {
		for (int i=0;i<256;i++) {
			if (root.pointers[i] != null)
				printAll(node.pointers[i]);
		}
		if (root.word != "") 
			System.out.println(root.word);
	}
	
	public static void main(String[] args) {
		
	}

}

class Node {
	char info;
	String word;
	Node[] pointers = new Node[256];
	
	public Node() {
		for (int i=0;i<256;i++) {
			pointers[i] = null;
		}
		info = '\0';
		word = "";
	}
}
