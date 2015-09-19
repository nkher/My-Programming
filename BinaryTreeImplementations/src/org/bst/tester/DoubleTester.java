package org.bst.tester;

import org.binarysearchtree.BSTNode;
import org.binarysearchtree.BinarySearchTree;

public class DoubleTester {
	
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
		BinarySearchTree<Double, Customer> bstCustomer = new BinarySearchTree<Double, Customer>();
		bstCustomer.insert(5d, c5);
		bstCustomer.insert(3d, c3);
		bstCustomer.insert(7.0, c7);
		bstCustomer.insert(1.0, c1);
		bstCustomer.insert(4.0, c4);
		bstCustomer.insert(6.0, c6);
		bstCustomer.insert(8.0, c8);
		bstCustomer.insert(9.0, c9);
		bstCustomer.insert(2.0, c2);
		
		// search for a key
		BSTNode<Double, Customer> node = new BSTNode<Double, Customer>();
		node = bstCustomer.searchKey(5.0);
		System.out.println("Customer Id : " + node.value().getCustomerId());
		System.out.println("Customer Name : " + node.value().getcustomerName());
		System.out.println("Customer Balance : " + node.value().getcustomerBalance());
		System.out.println("Customer key in BST : " + node.key());
	}
}
