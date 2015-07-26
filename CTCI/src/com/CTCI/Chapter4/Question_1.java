package com.CTCI.Chapter4;

import org.CTCILibrary.TreeNode;

public class Question_1 {
	
	// This is an O(N log N) solution as minDepth and maxDepth are called again and again
	public static int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left),minDepth(root.right));
	}
	
	public static int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	public static boolean isBalanced(TreeNode root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}
	
	// Method 2 using extra O(N) space and O(N) time
	// returns -1 if not balance other wise will return the height of the balanced tree
	public static int checkHeight(TreeNode root) {
		if (root == null) return 0;
		
		// left height
		int leftH = checkHeight(root.left);
		if (leftH == -1)
			return -1; // not balanced
		
		// right height
		int rightH = checkHeight(root.right);
		if (rightH == -1)
			return -1; // not balanced
		
		// check difference between the heights
		if (Math.abs(leftH - rightH) > 1)
			return -1;
		else
			return Math.max(leftH, rightH) + 1;
		
	}
	 
	public static void main(String[] args) {
		
		// Create a balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		
		System.out.println("Is Balanced ? " + checkHeight(root));
		root.insertInOrder(4); // To make it unbalanced
		//root.insertInOrder(3); // To make it unbalanced

		System.out.println("Is Balanced ? " + checkHeight(root));
	}

}
