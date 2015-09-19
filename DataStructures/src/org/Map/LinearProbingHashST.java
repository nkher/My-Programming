package org.Map;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LinearProbingHashST<Key, Value> {
	
	private static final int INIT_CAPACITY = 4;
	private int N; // key value pairs
	private int M; // size of table
	private Key[] keys;
	private Value[] values;
	
	public LinearProbingHashST() {
		this(INIT_CAPACITY);
	}
	
	public LinearProbingHashST(int capacity) {
		M = capacity;
		keys  = (Key[]) new Object[M];
		values = (Value[]) new Object[M];
	}
	
	public int size() {
		return M;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	private void resize(int capacity) {
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
		for (int i=0;i<M;i++) {
			if(keys[i] != null) {
				temp.put(keys[i], values[i]);
			}
		}
		keys = temp.keys;
		values = temp.values;
		M = temp.M;
	}
	
	public void put(Key key, Value value) {
		if (value == null) {
			delete(key);
			return;
		}
		// double the table size if 50% full
		if (N > M/2) resize(2*M);
		int i;
		for (i=hash(key); keys[i] != null; i=(i+1)%M) {
			if(keys[i].equals(key)) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		N++;
	}
	
	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i+1) % M) {
			if(keys[i].equals(key))
				return values[i];
		}
		return null;
	}
	
	public void delete(Key key) {
		if(!contains(key)) return;
		int i = hash(key);
		while (!key.equals(keys[i])) {
			i = (i+1) % M;
		}
		// delete the key and its associated value
		keys[i] = null;
		values[i] = null;
		
		// perform rehasing all the keys in the same cluster
		i = (i+1) % M;
		while (keys[i] != null) {
			Key keyToRehash = keys[i];
			Value valueToRehash = values[i];
			keys[i] = null;
			values[i] = null;
			N--;
			put(keyToRehash, valueToRehash);
			i = (i + 1) % M;
		}
		N--;
		
		// halve the size of the array it is is 12.5% full or less
		if (N > 0 && N < M/8)
			resize(M/2);
		
		assert check();
	}
	
	public Iterable<Key> keySet() {
		Queue<Key> queue = new LinkedList<Key>();
		for (int i=0;i<M;i++) {
			if(keys[i] != null) {
				queue.add(keys[i]);
			}
		}
		return queue;
	}
	
	// integrity check - don't check after each put() because
    // integrity not maintained during a delete()
	public boolean check() {
		// check if hashtable is almost full
		if(M < 2*N) {
			System.err.println("Hash table size M = " + M + "; array size N = " + N);
			return false;
		}
		// check that each key in table can be found by get()
		for (int i=0;i<M;i++) {
			if (keys[i] == null) continue;
			else if (get(keys[i]) != values[i]) {
				System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + values[i]);
                return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
		for (int i=0;i <5;i++) {
			System.out.println("Please enter a string");
			String key = input.nextLine();
			st.put(key, i);
		}
		for (String s : st.keySet()) {
			System.out.println(s + " " + st.get(s));
		}
		
		System.out.println(0x7fffffff);
	}

}
