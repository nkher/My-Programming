package Recursion;

import org.CTCILibrary.TreeNode;

public class DiameterBinaryTree {
	
	public static int height(TreeNode node) {
		if (node == null) return 0;
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	public static int diameter(TreeNode root) {
		
		if (root == null) return 0;
		
		int lht = height(root.left);
		int rht = height(root.right);
		
		int ldia = diameter(root.left);
		int rdia = diameter(root.right);
		
		return Math.max((lht + rht + 1), Math.max(ldia, rdia));
	}
	
	public static Integer height = new Integer(0);
	public static Integer left = new Integer(0);
	public static Integer right = new Integer(0);
	
	public static int diameterEfficient(TreeNode root) {
		return diameterEfficientHelper(root, height);
	}
	
	public static int diameterEfficientHelper(TreeNode root, Integer height) {
		
		int lht = 0, rht = 0;
		
		int ldia = 0, rdia = 0;
		
		if (root == null) {
			height = 0;
			return 0;
		}
		
		ldia = diameterEfficientHelper(root.left, left);
		rdia = diameterEfficientHelper(root.right, right);
		
		height = Math.max(left, right) + 1;
				
		return Math.max(lht + rht + 1, Math.max(ldia, rdia));
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.insertInOrder(25);
		root.insertInOrder(75);
		root.insertInOrder(0);
		root.insertInOrder(100);
		root.insertInOrder(37);
		root.insertInOrder(60);
		root.insertInOrder(62);
		
		root.print();
		
		System.out.println("Dia by normal : " + diameter(root));
		
		System.out.println("Dia by eff : " + diameterEfficient(root));
	}
}
