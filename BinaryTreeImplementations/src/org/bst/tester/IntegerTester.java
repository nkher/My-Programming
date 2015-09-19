package org.bst.tester;

import java.util.ArrayList;

import org.binarysearchtree.BSTNode;
import org.binarysearchtree.BinarySearchTree;

public class IntegerTester {

	public static void main(String[] args) throws InterruptedException {
		
		BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
		
		bst.insert(10, "Ten");
		bst.insert(5, "Five");
		bst.insert(15, "Fifteen");
		bst.insert(6, "Six");
		bst.insert(4, "Four");
		bst.insert(11, "Eleven");
		bst.insert(16, "Sixteen");
		
		//bst.keysInorder(bst.getRoot());
//		BSTNode<Integer, String> bstNode = bst.searchKey(6);
//		if(bstNode != null) 
//			System.out.println("Node Key -> " + bstNode.getKey() + " | Node Value -> " + bstNode.getValue());
//		else 
//			System.out.println("Not found");
		
		// Create customer objects
		Customer c1 = new Customer("Namesh", 1, 1000.00);
		Customer c2 = new Customer("Vikesh", 2, 2000.00);
		Customer c3 = new Customer("Utsav", 3, 3000.00);
		Customer c4 = new Customer("Sarika", 4, 4000.00);
		Customer c5 = new Customer("Eshan", 5, 5000.00);
		Customer c6 = new Customer("Amit", 6, 6000.00);
		Customer c7 = new Customer("Anshima", 7, 7000.00);
		Customer c8 = new Customer("Atima", 8, 8000.00);
		Customer c9 = new Customer("Shivani", 9, 9000.00);
		
		// create the customer binary search tree
		BinarySearchTree<Integer, Customer> bstCustomer = new BinarySearchTree<Integer, Customer>();
		bstCustomer.insert(c5.getCustomerId(), c5);
		bstCustomer.insert(c3.getCustomerId(), c3);
		bstCustomer.insert(c7.getCustomerId(), c7);
		bstCustomer.insert(c1.getCustomerId(), c1);
		bstCustomer.insert(c4.getCustomerId(), c4);
		bstCustomer.insert(c6.getCustomerId(), c6);
		bstCustomer.insert(c8.getCustomerId(), c8);
		bstCustomer.insert(c9.getCustomerId(), c9);
		bstCustomer.insert(c2.getCustomerId(), c2);
		
		
		// Testing the spiral tree keys method
		ArrayList<Integer> spiralKeyList = new ArrayList<Integer>();
		spiralKeyList = bstCustomer.spiralKeyList(spiralKeyList);
		System.out.print("[ ");
		for(Integer i : spiralKeyList) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
		// in order
		System.out.print("In order traversal : ");
		bst.printKeysInOrder(bstCustomer.root());
		System.out.println("Size : " + bstCustomer.size());
		System.out.println();
				
		// removing 5
		bstCustomer.remove(5);
		System.out.println("Removing 5");
		System.out.print("In order traversal : ");
		bst.printKeysInOrder(bstCustomer.root());
		System.out.println("Size : " + bstCustomer.size());
		spiralKeyList = new ArrayList<Integer>();
		spiralKeyList = bstCustomer.spiralKeyList(spiralKeyList);		
		System.out.print("[ ");
		for(Integer i : spiralKeyList) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
			
		// removing 8
		System.out.println();
		bstCustomer.remove(8);
		System.out.println("Removing 8");
		System.out.print("In order traversal : ");
		bst.printKeysInOrder(bstCustomer.root());
		System.out.println("Size : " + bstCustomer.size());
		spiralKeyList = new ArrayList<Integer>();
		spiralKeyList = bstCustomer.spiralKeyList(spiralKeyList);		
		System.out.print("[ ");
		for(Integer i : spiralKeyList) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
		

		// removing 3
		System.out.println();
		bstCustomer.remove(3);
		System.out.println("Removing 3");
		System.out.print("In order traversal : ");
		bst.printKeysInOrder(bstCustomer.root());
		System.out.println("Size : " + bstCustomer.size());		
		spiralKeyList = new ArrayList<Integer>();
		spiralKeyList = bstCustomer.spiralKeyList(spiralKeyList);
		// printing the list
		System.out.print("[ ");
		for(Integer i : spiralKeyList) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
		
	}
}
