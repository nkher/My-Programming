package com.CTCI.Chapter4;

import org.CTCILibrary.TreeNode;


public class Question4_6 {
	
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (covers(root.left, p) && covers(root.left, q)) {
			return commonAncestor(root.left, p, q);
		}
		if (covers(root.right, p) && covers(root.right, q)) {
			return commonAncestor(root.right, p, q);
		}
		return root;
	}
	
	// function to check if p is a child of the root
	private boolean covers(TreeNode root, TreeNode p) {
		if(root == null) return false;
		if(root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	
	// Main function that will do the work
	public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		if (is_p_on_left != is_q_on_left) {
			return root;
		}
		// nodes not on different side
		// get the left child or the right child depending on which one is true
		TreeNode child_side = is_p_on_left ? root.left : root.right;
		return commonAncestorHelper(child_side, p, q);
	}
	
	public TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		// error checking if one node is not in the tree
		if(!covers(root, p) || !covers(root, q)) {
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}

	public static void main(String[] args) {
		
		Question4_6 object = new Question4_6();
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(20);
		TreeNode node7 = new TreeNode(6);
		TreeNode node8 = new TreeNode(8);
		
		
		root.setLeftChild(node1);
		root.setRightChild(node4);
		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		node4.setLeftChild(node5);
		node4.setRightChild(node6);
		node3.setLeftChild(node7);
		node3.setRightChild(node8);
		
		root.print();
		
		TreeNode n1 = root.find(6);
		TreeNode n2 = root.find(8);
		TreeNode ancestor = object.commonAncestor(root, n1, n2);
		System.out.println("Ancestor is : " + ancestor.data);

		ancestor = object.commonAncestor2(root, n1, n2);
		System.out.println("Ancestor is : " + ancestor.data);
	}
}
