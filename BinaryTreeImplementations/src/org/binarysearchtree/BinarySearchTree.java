package org.binarysearchtree;

import java.util.ArrayList;

/**  
 * A Key, Value pair implementation for the 
 * Binary Search Tree Data Structure. 
 * @author Namesh Kher */
public class BinarySearchTree<K extends Comparable<K>, V> {
	
	private BSTNode<K, V> root;
	private int size;
	
	/* default cons */
	public BinarySearchTree() {
		setRoot(null);
	}
	
	/* cons - setting the root */
	public BinarySearchTree(K key, V value) {
		setRoot(new BSTNode<K, V>(key, value));
	}
	
	/* cons - setting the root with left and right */
	public BinarySearchTree(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
		setRoot(new BSTNode<K, V>(key, value, left, right));
	}
	
	/* getter */
	public BSTNode<K, V> root() {
		return root;
	}
	
	public int size() {
		return size;
	}

	/* setter */
	public void setRoot(BSTNode<K, V> root) {
		this.root = root;
	}
	
	// functions to be included -- insert, delete, search, in-order, pre-order, post-order 
	
	/* Function to insert into a BST */
	public void insert(K key, V value) {
		size++;
		BSTNode<K, V> newNode = new BSTNode<K, V>(key, value);
		if (root == null) {
			root = newNode;
			return;
		}
		BSTNode<K, V> focusNode = root;
		BSTNode<K, V> parent;
		
		while(true) {
			parent = focusNode;
			if(parent.key().compareTo(key) > 0) { // If parent is greater
				focusNode = focusNode.left();
				if(focusNode == null) {
					parent.setLeft(key, value);
					return;
				}
			}
			else {
				focusNode = focusNode.right(); // if the parent is smaller
				if(focusNode == null) {
					parent.setRight(key, value);
					return;
				}
			}
		}
	}
	
	/* Function to search in a BST */
	public BSTNode<K, V> searchKey(K key) {
		return searchKey(root, key);
	}
	
	/* Function to search for a key in the BST */
	private BSTNode<K, V> searchKey(BSTNode<K, V> root, K key) {
		try {
			if(root == null) {
				throw new NullPointerException();
			}
			else {
				if(root.key().equals(key)) {
					return root;
				}
				else if(root.key().compareTo(key) < 0) 
					return searchKey(root.right(), key);
				else 
					return searchKey(root.left(), key);
			}
		}
		catch (NullPointerException npe) {
			System.out.println("The provided key does not exist in the bst.");
		}
		return null;
	}

	/* Function to print tree in in-order traversal */
	public void printKeysInOrder(BSTNode<K, ?> root) {
		if(root != null) {
			printKeysInOrder(root.left());
			System.out.print(root.key() + " ");
			printKeysInOrder(root.right());
		}
	}
	
	/* Function to print tree in pre-order traversal */
	public void printKeysPreOrder(BSTNode<K, ?> root) {
		if(root != null) {
			System.out.println(root.key() + " ");
			printKeysPreOrder(root.left());
			printKeysPreOrder(root.right());
		}
	}
	
	/* Function to get the keys of the tree in in-order traversal */
	public ArrayList<K> getKeysInOrder(BSTNode<K, ?> root, ArrayList<K> keysList) throws InterruptedException {
		if(root != null) {
			getKeysInOrder(root.left(), keysList);
			keysList.add(root.key());
			getKeysInOrder(root.right(), keysList);
		}
		return keysList;
	}
	
	/* Function to get the keys of the tree in pre-order traversal */
	public ArrayList<K> getKeysPreOrder(BSTNode<K, ?> root, ArrayList<K> keysList) throws InterruptedException {
		if(root != null) {
			keysList.add(root.key());
			getKeysPreOrder(root.left(), keysList);
			getKeysPreOrder(root.right(), keysList);
		}
		return keysList;
	}
	
	
	/* Function to get the keys of the tree in post-order traversal */
	public ArrayList<K> getKeysPostOrder(BSTNode<K, ?> root, ArrayList<K> keysList) throws InterruptedException {
		if(root != null) {
			getKeysPostOrder(root.left(), keysList);
			getKeysPostOrder(root.right(), keysList);
			keysList.add(root.key());
		}
		return keysList;
	}
	
	
	/* Function to get the nodes of the tree in in-order traversal */
	public ArrayList<BSTNode<K, V>> getNodesInOrder(BSTNode<K, V> root, ArrayList<BSTNode<K, V>> nodesList) throws InterruptedException {
		if(root != null) {
			getNodesInOrder(root.left(), nodesList);
			nodesList.add(root);
			getNodesInOrder(root.right(), nodesList);
		}
		return nodesList;
	}
	
	/* Function to get the nodes of the tree in pre-order traversal */
	public ArrayList<BSTNode<K, V>> getNodesPreOrder(BSTNode<K, V> root, ArrayList<BSTNode<K, V>> nodesList) throws InterruptedException {
		if(root != null) {
			nodesList.add(root);
			getNodesPreOrder(root.left(), nodesList);
			getNodesPreOrder(root.right(), nodesList);
		}
		return nodesList;
	}
	
	/* Function to get the nodes of the tree in post-order traversal */
	public ArrayList<BSTNode<K, V>> getNodesPostOrder(BSTNode<K, V> root, ArrayList<BSTNode<K, V>> nodesList) throws InterruptedException {
		if(root != null) {
			getNodesPostOrder(root.left(), nodesList);
			getNodesPostOrder(root.right(), nodesList);
			nodesList.add(root);
		}
		return nodesList;
	}
	
	
	/* Function to delete a node from a tree */
	public boolean remove(K key) {
		if(root == null)
			return false;
		else {
			BSTNode<K, V> toBeRemoved = searchKey(key);
			if(toBeRemoved != null) {
				toBeRemoved.remove();
				size--;
				return true;
			}
			return false;
		}
	}
	
	/* Function to get minimum value node from a tree */
	public BSTNode<K, V> findMin() {
		return root.minNode();
	}
	
	/* Function to get maximum value node from a tree */
	public BSTNode<K, V> findMax() {
		return root.maxNode();
	}
	
	/* Function to get maximum height or depth a tree */	
	public int depth(BSTNode<K, V> root) {
		if(root == null) 
			return 0;
		int leftDepth = depth(root.left());
		int rightDepth = depth(root.right());
		if(leftDepth > rightDepth) 
			return leftDepth + 1;
		else
			return rightDepth + 1;
	}
	
	/* Function exposed to get the keys of BST in Spiral Order */
	public ArrayList<K> spiralKeyList(ArrayList<K> keylist) {
		int depth = depth(root);
		if(root == null) return null;
		boolean leftToRight = true;
		for(int i=1;i<=depth;i++) {
			keylist = addLevelNodesToList(keylist, root, i, leftToRight);
			leftToRight = !leftToRight;
		}
		return keylist;
	}
	
	/* Helper function that is used to add the node keys of a level in the BST to the Array List */
	private ArrayList<K> addLevelNodesToList(ArrayList<K> keylist, BSTNode<K, V> node, int level, boolean leftToRight) {
		if(node == null) return keylist;
		if(level == 1 && node != null) keylist.add((K) node.key());
		else if (level > 1){
			if(leftToRight) {
				addLevelNodesToList(keylist, node.left(), level-1, leftToRight);
				addLevelNodesToList(keylist, node.right(), level-1, leftToRight);
			}
			else {
				addLevelNodesToList(keylist, node.right(), level-1, leftToRight);
				addLevelNodesToList(keylist, node.left(), level-1, leftToRight);
			}
		}
		return keylist;
	}
}
