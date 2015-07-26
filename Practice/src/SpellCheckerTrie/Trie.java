package SpellCheckerTrie;

public class Trie {
	
	private DictionaryNode root;
	
	public Trie() {
		root = new DictionaryNode();
	}
	
	public void insert(String toAdd) {
	}
	
	public void insert(DictionaryNode loc, String toAdd, int letterPos) {
		if (toAdd != null && toAdd.length() > 0) {
			if (letterPos == toAdd.length())
				loc.setWord(toAdd);
			else {
				
			}
		}
	}
}
