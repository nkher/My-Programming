package com.CTCI5.Chapter4;

import org.CTCILibrary.TreeNode;

public class Question5 {
	
	// Check Valid BST
	// Method 1 - Do in order traversal and store it in an array
	// Check the array
	public static int index = 0;
	public static void copyBST(TreeNode root, int a[]) {
		if (root == null) return;
		copyBST(root.left, a);
		// copy the node into bst
		a[index] = root.data;
		index++;
		copyBST(root.right, a);
	}
	
	public static boolean checkArray(int a[]) {
		for (int i=0;i<a.length-1;i++) {
			if (a[i] > a[i+1])
				return false;
		}
		return true;
	}
	
	// Method 2
	public static Integer last_printed = null;
	public static boolean checkValidBST(TreeNode root) {
		if (root == null) return true;
		
		// recurse left
		if (!checkValidBST(root.left)) return false;
		
		// check current
		if (last_printed != null && last_printed >= root.data)
			return false;
		
		//assign the last printed the value
		last_printed = root.data;
		
		// recurse right
		if (!checkValidBST(root.right)) return false;	
		
		return true;
	}
	
	
	// Method three -- Time complexity O(N), Space Complexity O(log N)
	public static boolean isBST(TreeNode root) {
		return isBST(root, null, null);
	}
	
	private static boolean isBST(TreeNode node, Integer min, Integer max) {
		if (node == null) return true;
		
		if ( (min != null && node.data <= min) || (max != null &&  node.data > max) )
			return false;
		
		if (!isBST(node.left, min, node.data) || !isBST(node.right, node.data, max))
			return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(12);
		//root.left.left.left = new TreeNode(100);
		
		// method 1
		// int a[] = new int[7]; // should be equal to the size of the array
		// copyBST(root, a);
		// System.out.println(checkArray(a));
		
		// method 2
		// System.out.println(checkValidBST(root));
		
		// method 3
		System.out.println(isBST(root));
	}
}
