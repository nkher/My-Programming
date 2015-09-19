package Leetcode.Google;

import org.CTCILibrary.TreeNode;

import Library.IntWrapper;

public class RootToLeafNumbers {
	
	public static IntWrapper i = new IntWrapper(0);

	public static int sumNumbers(TreeNode root) {
		i.set(0);
		return sumNumbersHelper(root, i, 0);
	}
	
	public static int sumNumbersHelper(TreeNode node, IntWrapper sum, int rootToLeafVal) {
		
		if (node == null) return 0;
		
		rootToLeafVal = (rootToLeafVal * 10) + node.data;
		if (node.left == null && node.right == null) { // means this is a leaf
			sum.set(sum.get() + rootToLeafVal);
		}
		
		sumNumbersHelper(node.left, sum, rootToLeafVal);
		sumNumbersHelper(node.right, sum, rootToLeafVal);
		
		return sum.get();
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		System.out.println(sumNumbers(root));
		
		TreeNode r2 = new TreeNode(0);
		r2.right = new TreeNode(1);
		
		System.out.println(sumNumbers(r2));
	}

}


