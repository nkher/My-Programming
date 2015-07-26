package com.CTCI.Chapter4;

import org.CTCILibrary.TreeNode;

public class Question4_8 {
	
	public static void findSum(TreeNode root, int sum) {
		int depth = depth(root);
		int[] path = new int[depth]; // Allowing the path array to have a maximum size equivalent to the depth of the tree
		findSum(root, sum, path, 0);
	}
	
	public static void findSum(TreeNode node, int sum, int path[], int level) {
		if(node == null) return;
		
		// Insert the current node into the path
		path[level] = node.data;
		int t = 0;
		// This for loop will run backwards for each level
		// Means if it starts at level two then it would run from 2 to zero
		// This will ensure that each possible combination of sum is being tested
		for (int i=level; i>=0; i--) {
			t += path[i];
			if(t == sum) {
				printPath(path, i, level);
			}
		}
		
		// Now recursing on the left and right sub trees
		findSum(node.left, sum, path, level+1); // Make the level as the next level
		findSum(node.right, sum, path, level+1);
		/* Remove current node from path. Not strictly necessary, since we would
		 * ignore this value, but it's good practice.
		 */
		path[level] = Integer.MIN_VALUE;
	}
	
	public static int depth(TreeNode root) {
		if (root == null) return 0;
		else {
			return 1 + Math.max(depth(root.left), depth(root.right));
		}
	}
	
	public static void printPath(int path[], int start, int end) {
		System.out.print("[ ");
		for (int i=start;i<=end;i++)
			System.out.print(path[i]  + " ");
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		root.print();
		findSum(root, 8);
	}

}
