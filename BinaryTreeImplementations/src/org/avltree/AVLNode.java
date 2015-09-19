package org.avltree;

/** 
 * This class represents a node of the AVL type binary tree
 * which is in the form of a key, value pair. AVL tree is a self balancing 
 * binary tree which is used for searching purposes. This class or object is used 
 * in the implementation for AVL trees which can be found in the class AVLTree. The order
 * of insertion in this tree is determined by the key which
 * is a primitive java data type. 
 * Note: Allowed data types for key would be : int, float, double, String.
 * 		 The value could be a custom Java object.
 * @author Namesh Kher */
public class AVLNode<K extends Comparable<K>, V> {
	
	/** Class instance variables */
	private K key; // field determining the order of insertion
	private V value;
	private AVLNode<K, V> left;
	private AVLNode<K, V> right;
	private AVLNode<K, V> parent;
	private int height;
	
	/** Default empty constructor */
	public AVLNode() {}
	
	/** Constructor that initializes a BSTNode with its left and right nodes, key and value 
	 * @param - K key 
	 * @param - V value 
	 * @param - left (left child) 
	 * @param - right (right child) 
	 * @return - Returns a BSTNode */
	public AVLNode(K key, V value, AVLNode<K, V> left, AVLNode<K, V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
		this.height = 1;
	}
	
	/** Constructor that initializes a BSTNode with its key and value only 
	 * @param - K key 
	 * @param - V value 
	 * @return - Returns a BSTNode */
	public AVLNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.height = 1;
	}
	
	/**  
	 * Getter method used to get the node's key
	 * @param - none 
	 * @return - key of type K */
	public K key() {
		return key;
	}
	
	/**  
	 * Getter method used to get the node's left child
	 * @param - none 
	 * @return - BSTNode */
	public AVLNode<K, V> left() {
		return left;
	}
	
	/**  
	 * Getter method used to get the node's right child
	 * @param - none 
	 * @return - AVLNode */
	public AVLNode<K, V> right() {
		return right;
	}

	/**  
	 * Getter method used to get the node's parent
	 * @param - none 
	 * @return - BSTNode */
	public AVLNode<K, V> parent() {
		return parent;
	}
	
	/**  
	 * Getter method used to get the node's key
	 * @param - none 
	 * @return - value of type V */
	public V value() {
		return value;
	}
	
	/**  
	 * Getter method used to get the node's height
	 * @param - none 
	 * @return - value of type V */
	public int height() {
		return height;
	}
	
	/**  
	 * Setter method used to set the node's key
	 * @param - key of K type 
	 * @return - none */
	public void setKey(K key) {
		this.key = key;
	}
	
	/**  
	 * Setter method used to set the node's value
	 * @param - value of V type 
	 * @return - none */
	public void setValue(V value) {
		this.value = value;
	}
	
	/**  
	 * Setter method used to get the node's height
	 * @param - none 
	 * @return - value of type V */
	public void height(int ht) {
		height = ht;
	}
	
	/**  
	 * Function to set the left child of the node
	 * @param - key of type K
	 * @param - value of type V 
	 * @return - none */
	public void setLeft(K key, V value) {
		/* check if the new node is smaller - only then insert */
		if(this.key.compareTo(key) > 0) {
			AVLNode<K, V> newNode = new AVLNode<K, V>(key, value);
			this.left = newNode;
			newNode.parent = this;
		}
	}
	
	/**  
	 * Function to set the right child of the node
	 * @param - key of type K
	 * @param - value of type V 
	 * @return - none */
	public void setRight(K key, V value) {
		if(this.key.compareTo(key) < 0) {
			AVLNode<K, V> newNode = new AVLNode<K, V>(key, value);
			this.right = newNode;
			newNode.parent = this;
		}
	}
	
	/**  
	 * Function to get the smallest key considering this node as the root
	 * @param - none
	 * @return - key of type K */
	public K minKey() {
		if(left == null) 
			return key;
		else
			return left.key;
	}
	
	/**  
	 * Function to get the largest key considering this node as the root
	 * @param - none
	 * @return - key of type K */
	public K maxKey() { 
		if(right == null) 
			return key;
		else 
			return right.maxKey();
	}
	
	/**  
	 * Function to get the smallest value considering this node as the root
	 * @param - none
	 * @return - value of type V 
	 * {Note: If you have a custom type Java data structure for the value then you get the reference to it} */
	public V minValue() { 
		if(left == null) 
			return value;
		else 
			return left.minValue();
	}
	
	/**  
	 * Function to get the largest value considering this node as the root
	 * @param - none
	 * @return - value of type V 
	 * {Note: If you have a custom type Java data structure for the value then you get the reference to it} */
	public V maxValue() { 
		if(right == null) 
			return value;
		else 
			return right.minValue();
	}
	
	/**  
	 * Function to get the smallest BSTNode considering this node as the root
	 * @param - none
	 * @return - reference to the BSTNode  */
	public AVLNode<K, V> minNode() { 
		if(left == null) 
			return this;
		else 
			return left.minNode();
	}
	
	/**  
	 * Function to get the largest BSTNode considering this node as the root
	 * @param - none
	 * @return - reference to the BSTNode  */
	public AVLNode<K, V> maxNode() { 
		if(right == null) 
			return this;
		else 
			return right.maxNode();
	}
	
	/**  
	 * Function to check if this node is the lead node
	 * @param - none
	 * @return - boolean type {0 if false and 1 if true}  */
	public boolean isLeaf() {
		if(left == null && right == null)
			return true;
		return false;
	}
	
	/**  
	 * Function to check if this node has a left child
	 * @param - none
	 * @return - boolean type {0 if false and 1 if true}  */
	public boolean hasLeft() {
		if(left != null)
			return true;
		return false;
	}
	
	/**  
	 * Function to check if this node has a right child
	 * @param - none
	 * @return - boolean type {0 if false and 1 if true}  */
	public boolean hasRight() {
		if(right != null)
			return true;
		return false;
	}
	
	/**  
	 * Function to increment the height of the node. This
	 * is used when ever a new node is inserted into the tree
	 * @param - none
	 * @return - none  */
	public void incrementHeight() {
		this.height++;
	}
}
