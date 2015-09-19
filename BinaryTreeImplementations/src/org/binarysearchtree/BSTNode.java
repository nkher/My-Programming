package org.binarysearchtree;

/** 
 * This class represents a node of the binary search tree
 * which (BST Node) is in the form of a key, value pair. The order
 * of insertion in this tree is determined by the key which
 * is a primitive java data type. 
 * Note: Allowed data types for key would be : int, float, double, String.
 * 		 The value could be a custom Java object.
 * @author Namesh Kher */
public class BSTNode<K extends Comparable<K>, V>{
	
	/** Class instance variables */
	private K key; // field determining the order of insertion
	private V value;
	private BSTNode<K, V> left;
	private BSTNode<K, V> right;
	private BSTNode<K, V> parent;
	
	/** Default empty constructor */
	public BSTNode() {}
	
	/** Constructor that initializes a BSTNode with its left and right nodes, key and value 
	 * @param - K key 
	 * @param - V value 
	 * @param - left (left child) 
	 * @param - right (right child) 
	 * @return - Returns a BSTNode */
	public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	/** Constructor that initializes a BSTNode with its key and value only 
	 * @param - K key 
	 * @param - V value 
	 * @return - Returns a BSTNode */
	public BSTNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	/**  
	 * getter method used to get the node's key
	 * @param - none 
	 * @return - key of type K */
	public K key() {
		return key;
	}
	
	/**  
	 * getter method used to get the node's left child
	 * @param - none 
	 * @return - BSTNode */
	public BSTNode<K, V> left() {
		return left;
	}
	
	/**  
	 * getter method used to get the node's right child
	 * @param - none 
	 * @return - BSTNode */
	public BSTNode<K, V> right() {
		return right;
	}

	/**  
	 * getter method used to get the node's parent
	 * @param - none 
	 * @return - BSTNode */
	public BSTNode<K, V> parent() {
		return parent;
	}
	
	/**  
	 * getter method used to set the node's key
	 * @param - none 
	 * @return - value of type V */
	public V value() {
		return value;
	}
	
	/**  
	 * setter method used to set the node's key
	 * @param - key of K type 
	 * @return - none */
	public void setKey(K key) {
		this.key = key;
	}
	
	/**  
	 * setter method used to set the node's value
	 * @param - value of V type 
	 * @return - none */
	public void setValue(V value) {
		this.value = value;
	}
 	
	/**  
	 * Function to set the left child of the node
	 * @param - key of type K
	 * @param - value of type V 
	 * @return - none */
	public void setLeft(K key, V value) {
		/* check if the new node is smaller - only then insert */
		if(this.key.compareTo(key) > 0) {
			BSTNode<K, V> newNode = new BSTNode<K, V>(key, value);
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
		/* check if the new node is smaller - only then insert */
		if(key.compareTo(this.key) > 0) {
			BSTNode<K, V> newNode = new BSTNode<K, V>(key, value);
			this.right = newNode;
			newNode.parent = this;
		}
	}
	
	/**  
	 * Function to remove this node from the tree
	 * @param - none
	 * @return - none */
	public void remove() {
		if(left == null && right == null) { // node has no children
			if(parent != null) {
				if(parent.right == this) 
					parent.right = null;
				else
					parent.left = null;
				return;
			}
		}
		else if (left == null && right != null) { // node has only right child
			if(parent != null) {
				if(parent.right == this) 
					parent.right = this.right;
				else
					parent.left = this.right;
			}
		}
		else if (left != null && right == null) { // node has only left child
			if(parent != null) {
				if(parent.right == this)
					parent.right = left.minNode();
				else 
					parent.left = left.minNode();
			}
		}
		else if (left != null && right != null) { // node has both the children
			this.key = right.minNode().key(); // change the key
			this.value = right.minNode().value(); // change the value
			if(right.minNode() == this.right)
				right = null;
			else
				right.minNode().parent.left = null;
		}
		return;
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
	public BSTNode<K, V> minNode() { 
		if(left == null) 
			return this;
		else 
			return left.minNode();
	}
	
	/**  
	 * Function to get the largest BSTNode considering this node as the root
	 * @param - none
	 * @return - reference to the BSTNode  */
	public BSTNode<K, V> maxNode() { 
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
}

//BSTNode<K, V> rightMin = right.minNode();
//if(right.minNode() == this.right) {
//	right = null;
//}
//if(parent != null) {
//	if(parent.right == this) {
//		parent.right = rightMin;
//		parent.right.right = this.right;
//		parent.right.left = this.left;
//	}
//	else {
//		parent.left = rightMin;
//		parent.left.right = this.right;
//		parent.left.left = this.left;
//	}
//}
//else { // if it is the root
//	this.key = rightMin.key(); // change the key
//	this.value = rightMin.value(); // change the value
//}
//BSTNode<K, V> minParent = rightMin.parent;
//System.out.println("min parent : " + minParent.key);
//minParent.left = null;