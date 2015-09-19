package org.Trie;

import java.util.LinkedList;
import java.util.Queue;

public class TrieST<Value> {
	
	private static final int R = 256; // ascii
	
	private TrieNode root; // root of the trie
	private int N; // number of keys
	
	// R-way trie node
	private static class TrieNode {
		private Object val;
		private TrieNode[] next = new TrieNode[R];
	}
	
	public TrieST() {}
	
	/*
	 * Returns the value associated to the given key
	 */
	public Value get(String key) {
		TrieNode x = get(root, key, 0);
		if (x == null) return null;
		return (Value) x.val;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	private TrieNode get(TrieNode x, String key, int d) {
		if (x == null) return null;
		if (d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	public void put(String key, Value val) {
		if (val == null) delete(key);
		else root  = put(root, key, val, 0);
	}
	
	private TrieNode put(TrieNode x, String key, Value val, int d) {
		if (x == null) x = new TrieNode();
		if (d == key.length()) {
			if (x.val == null) N++;
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() { return size() == 0; }
	
	public void delete(String key) {
		root = delete(root, key, 0);
	}
	
	private TrieNode delete(TrieNode x, String key, int d) {
		if (x == null) return null;
		if (d == key.length()) {
			if (x.val != null) {
				N--;
				x.val = null;
			}
		}
		else {
			char c  = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d+1);
		}
		
		// remove sub trie rooted at x  if it is completely empty
		if (x.val != null) return x;
		for (int c=0;c<R;c++) {
			if(x.next[c] != null) {
				return x;
			}
		}
		return x;
	}
	
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}
	
	/**
     * Returns all of the keys in the set that start with <tt>prefix</tt>.
     * @param prefix the prefix
     * @return all of the keys in the set that start with <tt>prefix</tt>,
     *     as an iterable
     */
	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> results = new LinkedList<String>();
		TrieNode x = get(root, prefix, 0);
		collect(x, new StringBuilder(prefix), results);
		return results;
	}
	
	private void collect(TrieNode x, StringBuilder prefix, Queue<String> results) {
		if(x == null) return;
		if(x.val == null) results.add(prefix.toString());
		for (char c=0;c<R;c++) {
			prefix.append(c);
			collect(x.next[c], prefix, results);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}
	
	public static void main(String args[]) {
		TrieST<Integer> st = new TrieST<Integer>(); 
		st.put("Namesh", 0);
		
		System.out.println(st.keysWithPrefix("Na"));
	}
}

