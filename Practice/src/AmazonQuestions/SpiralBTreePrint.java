package AmazonQuestions;

import Library.TreeNode;

public class SpiralBTreePrint {
	
	public static int getSize(TreeNode  root) {
		if(root == null) return 0;
		else {
			return (getSize(root.left) + 1 + getSize(root.right));
		}
	}
	
	public static int getHeight(TreeNode root) {
		if(root == null) return 0;
		else {
			int leftDepth = getHeight(root.left);
			int rightDepth = getHeight(root.right);
			
			if(leftDepth > rightDepth) {
				return leftDepth + 1;
			}
			else 
				return rightDepth + 1;
		}
	}
	
	public static void printSpiral(TreeNode root) {
		int height = getHeight(root);
		if(root == null) return;
		boolean orderFlicker = true; // True means left to right and vice versa
		for(int i=1; i<=height; i++) {
			printGivenLevel(root, i, orderFlicker);
			orderFlicker = !orderFlicker; // Flipping the order for the next iteration 
		}
	}
	
	private static void printGivenLevel(TreeNode node,  int level, boolean orderFlicker) {
		if (node == null) return;
		if(level == 1)
			System.out.print(node.data + " ");
		else if(level > 1) {
			if(orderFlicker) { // print left to right
				printGivenLevel(node.left, level-1, orderFlicker);
				printGivenLevel(node.right, level-1, orderFlicker);
			}
			else  { // print right to left
				printGivenLevel(node.right, level-1, orderFlicker);
				printGivenLevel(node.left, level-1, orderFlicker);
			}
		}
	}
	
	public static void printLevel(TreeNode root) {
		int height = getHeight(root);
		if(root == null) return;
		boolean orderFlicker = true; // True means left to right and vice versa
		for(int i=1; i<=height; i++) {
			printGivenLevelOrder(root, i);
			orderFlicker = !orderFlicker; // Flipping the order for the next iteration 
		}
	}
	
	private static void printGivenLevelOrder(TreeNode node,  int level) {
		if (node == null) return;
		if(level == 1)
			System.out.print(node.data + " ");
		else if(level > 1) {
				printGivenLevelOrder(node.left, level-1);
				printGivenLevelOrder(node.right, level-1);
		}
	}
	
	
	public static void main(String[] args) {
			
		// Creating a tree from the tree node class
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		root.print();
		
		System.out.println("Spiral Order traversal of binary tree is: ");
		SpiralBTreePrint.printSpiral(root);
		
		System.out.println();
		
		System.out.println("Level Order traversal of binary tree is: ");
		SpiralBTreePrint.printLevel(root);
	}

}
