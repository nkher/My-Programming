package SpellCheckerTrie;

import java.util.LinkedList;

public class DictionaryNode {
	
	private char data; // character on this node
	private LinkedList<DictionaryNode> children;
	private DictionaryNode parent;
	private String word;
	
	public DictionaryNode() {
		this.children = new LinkedList<DictionaryNode>();
		this.parent = null;
	}
	
	public DictionaryNode(char data, DictionaryNode parent) {
		this.children = new LinkedList<DictionaryNode>();
		this.parent = parent;
		this.data = data;
	}
	
	/*
	 * Checks to see if any this Node's children match the passed character */
	public DictionaryNode findChildNode(char data) {
		if (this.children != null) {
			for (int i=0;i<children.size();i++) {
				DictionaryNode child = this.children.get(i);
				if (child.data == data)
					return child;
			}
		}
		return null;
	}
	
	/**
	 * A simple way of seeing a list of characters that this node calls children
	 * @return the String to print
	 */
	public String toString() {
		String toReturn;
		if (this.children.size() > 0) {
			toReturn = "Node " + this.data + " has children.";
			for (int i=0;i<children.size();i++) {
				char child = this.children.get(i).data;
				toReturn += " " + child;
			}
			if (this.word != null) toReturn += " and gives word : " + this.word;
			toReturn += " \n";
			for (int i=0;i<this.children.size();i++) {
				toReturn += this.children.get(i).toString();
			}
		}
		else {
			toReturn = "Node " + this.data + " has no children.";
			if (this.word != null) toReturn += " and gives word : " + this.word;
			toReturn += " \n";
		}
		return toReturn;
	}
	
	public String parents() {
		String toReturn = "";
		DictionaryNode looking = this;
		while (looking != null) {
			toReturn = looking.data + " " + toReturn;
			looking = looking.parent;
		}
		return toReturn;
	}
	
	public char getData() {
		return data;
	}
	
	public LinkedList<DictionaryNode> getChildren() {
		return children;
	}
	
	public String getWord() { 
		return word; 
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void setData(char data) {
		this.data = data;
	}


}
