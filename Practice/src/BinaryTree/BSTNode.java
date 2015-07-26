package BinaryTree;


/* This class represents a node of the binary tree */
public class BSTNode<K extends Comparable<K>, V>{
	
	/* fields */
	private K key; // field determining the order of insertion
	private V value;
	private BSTNode<K, V> left;
	private BSTNode<K, V> right;
	private BSTNode<K, V> parent;
	
	/* default empty constructor */
	public BSTNode() {}
	
	/* constructor with left and right nodes */
	public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	/* cons without left and right nodes */
	public BSTNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	/* getters */
	public K key() {
		return key;
	}
	
	public BSTNode<K, V> left() {
		return left;
	}
	
	public BSTNode<K, V> right() {
		return right;
	}

	public BSTNode<K, V> parent() {
		return parent;
	}
	
	public V value() {
		return value;
	}
	/* end getters */
	
	/* setters */
	public void setKey(K key) {
		this.key = key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	/* end setters */
 	
	/* function to set the left node */
	public void setLeft(K key, V value) {
		/* check if the new node is smaller - only then insert */
		if(this.key.compareTo(key) > 0) {
			BSTNode<K, V> newNode = new BSTNode<K, V>(key, value);
			this.left = newNode;
			newNode.parent = this;
		}
	}
	
	/* function to set the right node */
	public void setRight(K key, V value) {
		/* check if the new node is smaller - only then insert */
		if(key.compareTo(this.key) > 0) {
			BSTNode<K, V> newNode = new BSTNode<K, V>(key, value);
			this.right = newNode;
			newNode.parent = this;
		}
	}
	
	/* Function to remove the current node from the tree */
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
//			BSTNode<K, V> rightMin = right.minNode();
//			if(right.minNode() == this.right) {
//				right = null;
//			}
//			if(parent != null) {
//				if(parent.right == this) {
//					parent.right = rightMin;
//					parent.right.right = this.right;
//					parent.right.left = this.left;
//				}
//				else {
//					parent.left = rightMin;
//					parent.left.right = this.right;
//					parent.left.left = this.left;
//				}
//			}
//			else { // if it is the root
//				this.key = rightMin.key(); // change the key
//				this.value = rightMin.value(); // change the value
//			}
//			BSTNode<K, V> minParent = rightMin.parent;
//			System.out.println("min parent : " + minParent.key);
//			minParent.left = null;
		}
		return;
	}
	
	/* To get the minimum key from the BST */
	public K minKey() {
		if(left == null) 
			return key;
		else
			return left.key;
	}
	
	/* To get the maximum value from the BST */
	public K maxKey() { 
		if(right == null) 
			return key;
		else 
			return right.maxKey();
	}
	
	/* To get the minimum value from the BST */
	public V minValue() { 
		if(left == null) 
			return value;
		else 
			return left.minValue();
	}
	
	/* To get the maximum value from the BST */
	public V maxValue() { 
		if(right == null) 
			return value;
		else 
			return right.minValue();
	}
	
	/* To get the minimum node from the BST */
	public BSTNode<K, V> minNode() { 
		if(left == null) 
			return this;
		else 
			return left.minNode();
	}
	
	/* To get the maximum node from the BST */
	public BSTNode<K, V> maxNode() { 
		if(right == null) 
			return this;
		else 
			return right.maxNode();
	}
	
	/* To check if the node is a leaf */
	public boolean isLeaf() {
		if(left == null && right == null)
			return true;
		return false;
	}
	
	/* To check if the node has a left child */
	public boolean hasLeft() {
		if(left != null)
			return true;
		return false;
	}
	
	/* To check if the node has a right child */
	public boolean hasRight() {
		if(right != null)
			return true;
		return false;
	}
}
