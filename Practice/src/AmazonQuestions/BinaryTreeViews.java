package AmazonQuestions;

import Library.BTreePrinter;
import Library.TreeNode;

public class BinaryTreeViews {
	
	// recursive function to print left view of binary tree
	private static void printLeftViewUtility(TreeNode root, int level, int maxLevelVisited) {
		if (root == null) return; // base case
		if (maxLevelVisited < level) { // check if it is the first node in its level 
			System.out.print(root.data + " ");
			maxLevelVisited = level;
		}
		
		// Since we want to print left view start from left child and increase the level at each iteration
		printLeftViewUtility(root.left, level+1, maxLevelVisited);
		printLeftViewUtility(root.right, level+1, maxLevelVisited);
	}
	
	public static void printLeftView(TreeNode root) {
		int maxLevelVisited = 0;
		printLeftViewUtility(root, 1, maxLevelVisited);
	}
	
	/* The problem of the two methods below is that it only checks one side of the tree */
	public static void leftView(TreeNode root) {
		if (root == null) return;
		System.out.print(root.data + " ");
		if(root.left != null) {
			leftView(root.left);
		}
		else 
			leftView(root.right);
	}
	
	public static void rightView(TreeNode root) {
		if (root == null) return;
		printRightViewUtility(root, 0);
	}
	
	public static void printRightViewUtility(TreeNode node, int level) {
		if (node == null) return;
		if (level == 0)
			System.out.println(node.data);
		else {
			if (node.right != null)
				printRightViewUtility(node.right, level+1);
			else if (node.left != null)
				printRightViewUtility(node.left, level+1);
		}
	}
	
	/* The problem of the two methods above is that it only checks one side of the tree */
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(8);
		
		// Print the B Tree
		BTreePrinter.printNode(root);
		
		System.out.println("Left view of above b-tree is ");		
		BinaryTreeViews.printLeftView(root);
		
		System.out.println();
		
		System.out.println("Right view of above b-tree is ");		
		BinaryTreeViews.rightView(root);
	}

}
