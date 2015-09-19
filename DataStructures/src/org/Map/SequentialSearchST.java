package org.Map;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SequentialSearchST<Key, Value> {
	private int N; // number of key values
	private Node first; //  linked list
	
	private class Node {
		private Key key;
		private Value value;
		private Node next;
		
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.next = next;
			this.value = value;
		}
	}
	
	public SequentialSearchST() {}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public Value get(Key key) {
		Node temp = first;
		while(first != null) {
			if(key.equals(temp.key)) return temp.value;
			temp = temp.next;
		}
		return null;
	}
	
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		for (Node x = first; x != null; x = x.next) {
			if(key.equals(x.key)) {
				x.value = val;
				return;
			}
		}
		first = new Node(key, val, first);
		N++;
	}
	
	public void delete(Key key) {
		first = delete(first, key);
	}
	
	private Node delete(Node x, Key key) {
		if(x == null) return null;
		if(key.equals(x.key)) {
			N--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<Key>();
		for (Node x = first; x != null; x =  x.next) {
			queue.add(x.key);
		}
		return queue;
	}
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for (int i=0;i <5;i++) {
			System.out.println("Please enter a string");
			String key = input.nextLine();
			st.put(key, i);
		}
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
	}
}
