package org.bst.tester;

import org.binarysearchtree.BSTNode;
import org.binarysearchtree.BinarySearchTree;

public class StringTester {

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
		BinarySearchTree<String, Customer> bstCustomer = new BinarySearchTree<String, Customer>();
		bstCustomer.insert("five", c5);
		bstCustomer.insert("three", c3);
		bstCustomer.insert("seven", c7);
		bstCustomer.insert("one", c1);
		bstCustomer.insert("four", c4);
		bstCustomer.insert("six", c6);
		bstCustomer.insert("eight", c8);
		bstCustomer.insert("nine", c9);
		bstCustomer.insert("two", c2);
		
		// search for a key
		BSTNode<String, Customer> node = new BSTNode<String, Customer>();
		node = bstCustomer.searchKey("eight");
		System.out.println("Customer Id : " + node.value().getCustomerId());
		System.out.println("Customer Name : " + node.value().getcustomerName());
		System.out.println("Customer Balance : " + node.value().getcustomerBalance());
		System.out.println("Customer key in BST : " + node.key());
	}

}
