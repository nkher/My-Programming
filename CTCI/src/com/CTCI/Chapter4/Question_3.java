package com.CTCI.Chapter4;

import org.CTCILibrary.TreeNode;

public class Question_3 {
	
	public static TreeNode addToTree(int arr[], int start, int end) {
		if(end < start)
			return null;
		int mid = (start+end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = addToTree(arr, start, mid-1);
		n.right = addToTree(arr, mid+1, end);
		return n;
	}
	
	public static TreeNode createMinimalBST(int arr[]) {
		return addToTree(arr, 0, arr.length);
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}

}
