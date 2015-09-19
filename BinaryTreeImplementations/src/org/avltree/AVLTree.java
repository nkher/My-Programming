package org.avltree;

public class AVLTree<K extends Comparable<K>, V> {
	
	private AVLNode<K, V> root; // marks the entrance to the tree which is the root
	private int size; 
	private int height;
	
	public AVLTree() {
		setRoot(null);
	}
	
	public AVLTree(K key, V value) {
		setRoot(new AVLNode<K, V>(key, value));
	}
	
	public AVLTree(K key, V value, AVLNode<K, V> left, AVLNode<K, V> right) {
		setRoot(new AVLNode<K, V>(key, value, left, right));
	}
	
	public int size() {
		return size;
	}
	
	public void setRoot(AVLNode<K, V> root) {
		this.root = root;
	}
}
