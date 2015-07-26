package AmazonQuestions;

import Library.TreeNode;

public class BoundaryBTree {

	// Function to print the leaves
	// This function prints the leaves of a binary tree in left to right fashion
	// It first checks the left sub tree and then the right
	public static void printLeaves(TreeNode root) {
		if (root != null) {
			printLeaves(root.left); // First check the left part
			
			// Check if it is a leaf node and print it
			if(root.left == null  && root.right == null) 
				System.out.print(root.data + " ");
			
			printLeaves(root.right); // First check the right part
		}
		else
			return;
	}
	
	// A function to print all left boundary nodes, except a leaf node.
	// Print the nodes in TOP DOWN manner
	public static void printLeftBoundaries(TreeNode root) {
		if(root != null) {
			if(root.left != null) {
				// to ensure top down order, print the node
	            // before calling itself for left subtree
				System.out.print(root.data + " ");
				printLeftBoundaries(root.left);
			}
//			else if(root.right != null) {
//				System.out.print(root.data + " ");
//				printLeftBoundary(root.right);
//			}
			// do nothing if it is a leaf node, this way we avoid
	        // duplicates in output
		}
	}
	
	// Printing the right boundaries
	public static void printRightBoundaries(TreeNode root) {
		if(root != null) {
			if (root.right != null) {
				System.out.print(root.data + " ");
				printRightBoundaries(root.right);
			}
		}
	}
	
	public static void main(String[] args) {
			
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(8);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		// Printing the tree
		root.print();
		
		// Printing the leaves
		System.out.println();
		BoundaryBTree.printLeaves(root);
		
		System.out.println();
		
		// Print left boundary
		BoundaryBTree.printLeftBoundaries(root);
		System.out.println();
		
		// Print right boundaries
		BoundaryBTree.printRightBoundaries(root);
	}

}
