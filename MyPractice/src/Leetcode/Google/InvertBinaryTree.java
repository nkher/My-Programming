package Leetcode.Google;

import org.CTCILibrary.TreeNode;

public class InvertBinaryTree {
	
	public static TreeNode invertBinaryTree(TreeNode root) {
		return invertBinaryTreeHelper(root);
	}
	
	public static TreeNode invertBinaryTreeHelper(TreeNode node) {
		
		if (node == null) return null;
		
		if (node.left  == null && node.right == null) return node;
		
		else { // invert the nodes
			TreeNode temp = node.right;
			node.right = node.left;
			node.left = temp;
		}
		
		invertBinaryTree(node.left); // recurse on the left
		invertBinaryTree(node.right); // recurse on the right
		
		return node;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(4);
		root.right = new TreeNode(7);
		root.left = new TreeNode(2);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		root.print();
		
		TreeNode node = invertBinaryTree(root);
		
		node.print();
	}

}
