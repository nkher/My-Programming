package org.Map;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SeparateChainingHashST<Key, Value> {
	
	private static final int INIT_CAPACITY = 4;
	private int N; // number of key value pairs
	private int M; // hash table size
	private SequentialSearchST<Key, Value>[] st; // array of linked list tables
	
	public SeparateChainingHashST() {
		this(INIT_CAPACITY);
	}
	
	public SeparateChainingHashST(int M) {
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i=0;i<M;i++) {
			st[i] = new SequentialSearchST<Key, Value>();
		}
	}
	
	// resize the hash table to have the given number of chains b rehashing all of the keys
	private void resize(int chains) {
		SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
		for (int i=0;i<M;i++) {
			for (Key key : st[i].keys()) {
				temp.put(key, st[i].get(key));
			}
		}
		this.M = temp.M;
		this.N = temp.N;
		this.st = temp.st;
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public Value get(Key key) {
		int index = hash(key);
		return st[index].get(key);
	}
	
	public void put(Key key, Value value) {
		if(value == null) {
			delete(key);
			return;
		}
		// double the table size if average length of list >= 10
		if (N >= 10 * M) resize(2 * M);
		int i = hash(key);
		if(!st[i].contains(key)) N++;
		st[i].put(key, value);
	}
	
	public void delete(Key key) {
		int index = hash(key);
		if (st[index].contains(key)) N--;
		st[index].delete(key);
		
		// halve the table size if average length of list <= 2
		if (M > INIT_CAPACITY && N < 2*M) resize(M/2);
	}
	
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<Key>();
		for (int i=0;i<M;i++) {
			for (Key key : st[i].keys()) {
				queue.add(key);
			}
		}
		return queue;
	}
 	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
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
