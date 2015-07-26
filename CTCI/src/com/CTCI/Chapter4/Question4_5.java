package com.CTCI.Chapter4;

import org.CTCILibrary.BTreePrinter;
import org.CTCILibrary.TreeNode;

public class Question4_5 {
	
	public static TreeNode inorderSucc(TreeNode n) {
		if (n == null) return null;
		if(n != null) {
			TreeNode p;
			// Check right child
			if(n.right != null || n.parent == null)
				p = leftMostChild(n.right);
			else {
				// Go up until were on left on instead of right
				while((p = n.parent) != null) {
					if(p.left == n)
						break;
					n = p;
				}
			}
			return p;
		}
		return null;
	}
	
	public static TreeNode leftMostChild(TreeNode n) {
		if(n == null)
			return null;
		while(n.left != null)
			n = n.left;
		return n;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		root.print();
		
		BTreePrinter.printNode(root);
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

}
