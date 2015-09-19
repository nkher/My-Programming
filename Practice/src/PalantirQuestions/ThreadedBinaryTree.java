package PalantirQuestions;

public class ThreadedBinaryTree {

	ThreadedTreeNode root;
	
	/* Function to traverse binary tree without recursion and 
	   without stack */
	public void traversal(ThreadedTreeNode root) {
		ThreadedTreeNode current, previous;
		
		if (root == null) return;
		
		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.println(current.data);
				current = current.right; // we go to the right as the right would be the inorder successor
			}
			else {
				/* Find the in order predecessor of current */ 
				previous = current.left;
				while (previous.right != null && previous.right != current) // we check for current as the right pointers store the in order successor
					previous = previous.right;
				
				/* Make current as right child of its in order predecessor */
				if (previous.right == null) {
					previous.right = current;
					current = current.left;
				}
				/* Revert the changes made in if part to restore the original 
		        tree i.e., fix the right child of predecessor */
				else {
					previous.right = null;
					System.out.println(current.data);
					current = current.right;
				}
			} /* end of current.left == null */
		}
	}
	
	
	public static void main(String[] args) {
//		ThreadedTreeNode root = new ThreadedTreeNode(1);
//		root.left = new ThreadedTreeNode(2);
//		root.right = new ThreadedTreeNode(3);
//		root.left.left = new ThreadedTreeNode(4);
//		root.left.right = new ThreadedTreeNode(5);
		
		ThreadedTreeNode root = new ThreadedTreeNode(1);
		root.left = new ThreadedTreeNode(2);
		root.right = new ThreadedTreeNode(7);
		root.left.left = new ThreadedTreeNode(3);
		root.left.right = new ThreadedTreeNode(4);
		root.left.right.left = new ThreadedTreeNode(5);
		root.left.right.right = new ThreadedTreeNode(6);
		root.right.right = new ThreadedTreeNode(8);
		root.right.right.left = new ThreadedTreeNode(9);
		
		ThreadedBinaryTree tbt = new ThreadedBinaryTree();
		tbt.traversal(root);
	}
}

class ThreadedTreeNode {
	int data;
	ThreadedTreeNode left;
	ThreadedTreeNode right;
	
	public ThreadedTreeNode(int data) {
		left = right = null;
		this.data = data;
	}
	
	public ThreadedTreeNode(int data, ThreadedTreeNode left, ThreadedTreeNode right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
}
