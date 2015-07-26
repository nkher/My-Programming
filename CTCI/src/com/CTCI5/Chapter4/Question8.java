package com.CTCI5.Chapter4;

import org.CTCILibrary.AssortedMethods;
import org.CTCILibrary.TreeNode;

public class Question8 {
	
	// T2 subtree of T1
	
	// Method 1 - 
	// Check if t2's preorder and inorder are substring of t1's pre and inorder respectively
	// exception case - check in book
	// O(n + m) memory
	
	// Method 2 - 
	// Worst case time is  - O(nm)
	// it would search for r2 in r1 for atmost k times means time complexity would be O(n + km)
	// Space complexity is O(log (n) + log(m))
	
	public static boolean containsTree(TreeNode r1, TreeNode r2) {
		if (r2 == null) return false;
		else return subTree(r1, r2);
	}
	
	public static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null) return false;
		
		if (r1.data == r2.data)
			return matchTree(r1, r2);
		
		return ( subTree(r1.left, r2.left) || subTree(r1.right, r2.right) );
	}
	
	// checks the 2 trees actually
	public static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r2 == null && r1 == null) return true;
		
		if (r1 == null || r2 == null) return false;
		
		if (r1.data !=  r2.data) return false;
		
		return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] array2 = {2, 4, 5, 8, 9, 10, 11};
		
		TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t2 = AssortedMethods.createTreeFromArray(array2);
		
		if (containsTree(t1, t2))
			System.out.println("t2 is a subtree of t1");
		else
			System.out.println("t2 is not a subtree of t1");
		
		
		int[] array3 = {1, 2, 3};
		TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

		if (containsTree(t3, t4))
			System.out.println("t4 is a subtree of t3");
		else
			System.out.println("t4 is not a subtree of t3");
	}

}
