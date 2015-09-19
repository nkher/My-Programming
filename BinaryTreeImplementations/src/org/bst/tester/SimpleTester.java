package org.bst.tester;

import org.binarysearchtree.BSTNode;
import org.binarysearchtree.BinarySearchTree;

public class SimpleTester {

	public static void main(String[] args) {
		// create the customer binary search tree
		BinarySearchTree<String, Integer> bstCustomer = new BinarySearchTree<String, Integer>();
		bstCustomer.insert("five", 5);
		bstCustomer.insert("three", 3);
		bstCustomer.insert("seven", 7);
		bstCustomer.insert("one", 1);
		bstCustomer.insert("four", 4);
		bstCustomer.insert("six", 6);
		bstCustomer.insert("eight", 8);
		bstCustomer.insert("nine", 9);
		bstCustomer.insert("two", 2);
		
		// search for a key
		 BSTNode<String, Integer> node = new BSTNode<String, Integer>();
		 node = bstCustomer.searchKey("nine");
		System.out.println("Node Value : " + node.value());
		System.out.println("Node key : " + node.key());
	}

}
