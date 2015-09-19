package org.bst.tester;

import java.util.ArrayList;

import org.binarysearchtree.BSTNode;
import org.binarysearchtree.BinarySearchTree;

public class FloatTester {

	public static void main(String[] args) {
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
		BinarySearchTree<Float, Customer> bstCustomer = new BinarySearchTree<Float, Customer>();
		bstCustomer.insert(5f, c5);
		bstCustomer.insert(3.0f, c3);
		bstCustomer.insert(7.0f, c7);
		bstCustomer.insert(1.0f, c1);
		bstCustomer.insert(4.0f, c4);
		bstCustomer.insert(6.0f, c6);
		bstCustomer.insert(8.0f, c8);
		bstCustomer.insert(9.0f, c9);
		bstCustomer.insert(2.0f, c2);
		
		// search for a key
		BSTNode<Float, Customer> node = new BSTNode<Float, Customer>();
		node = bstCustomer.searchKey(8f);
		System.out.println("Customer Id : " + node.value().getCustomerId());
		System.out.println("Customer Name : " + node.value().getcustomerName());
		System.out.println("Customer Balance : " + node.value().getcustomerBalance());
		System.out.println("Customer key in BST : " + node.key());
		
		System.out.println("Smallest node in bst is : " + bstCustomer.findMin().key());
		System.out.println("Customer with Smallest node id is : " + bstCustomer.findMin().value().getcustomerName());
		System.out.println("Largest node in bst is : " + bstCustomer.findMax().key());
		System.out.println("Customer with Largest node id is : " + bstCustomer.findMax().value().getcustomerName());

		System.out.println("In order traversal");
		
		bstCustomer.printKeysInOrder(bstCustomer.root());
		
//		System.out.println();
//		
//		ArrayList<Float> keys = new ArrayList<Float>();
//		try {
//			keys = bstCustomer.getKeysInOrder(bstCustomer.getRoot(), keys);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		for(Float f : keys)
//			System.out.println("key -> " + f);
		
		System.out.println();
		ArrayList<BSTNode<Float, Customer>> nodes = new ArrayList<BSTNode<Float, Customer>>();
		try {
			nodes = bstCustomer.getNodesInOrder(bstCustomer.root(), nodes);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(BSTNode<Float, Customer> node1 : nodes) {
			System.out.println("key -> " + node1.key() + " value " + node1.value().getcustomerBalance());
		}
		
		System.out.println("Size is : " + bstCustomer.size());
		
		System.out.println("Depth of tree : " + bstCustomer.depth(bstCustomer.root()));
		bstCustomer.insert(10.0f, c2);
		System.out.println("Depth of tree : " + bstCustomer.depth(bstCustomer.root()));
		bstCustomer.insert(11.0f, c2);
		System.out.println("Depth of tree : " + bstCustomer.depth(bstCustomer.root()));
	}
}
