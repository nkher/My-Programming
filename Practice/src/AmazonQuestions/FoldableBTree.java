package AmazonQuestions;

import Library.TreeNode;

// T.C is O(N)
public class FoldableBTree {
	
	public static boolean checkFoldableBTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		// starting from children of the root and extending below
		return isFoldableBTree(root.left, root.right);
	}
	
	private static boolean isFoldableBTree(TreeNode child1, TreeNode child2) {
		
		// If both left and right are NULL then return true
		if (child1 == null && child2 == null)  {
			return true;
		}
		// Check if any one is null
		if (child1 == null ||  child2 == null) {
			return false;
		}
		// Checking if their children are mirror of their counter parts
		return isFoldableBTree(child1.left, child2.right) && isFoldableBTree(child1.right, child2.left);
	}
	
	public static void main(String[] args) {
		// Creating a tree from the tree node class
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		
		// Now we have created the tree of the form 

		  /* The constructed binary tree is
		         1
		       /   \
		      2     3
		      \    /
		       4  5
		  */
		
		// Printing the tree 
		root.print();
		
		// Checking out program
		if(FoldableBTree.checkFoldableBTree(root)) {
			System.out.println("The above tree can be folded");
		}
		else {
			System.out.println("The above tree cannot be folded");
		}
		
		// Creating another tree
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.left = new TreeNode(5);
		root2.right.right = new TreeNode(6);
		
		root2.print();
		
		if(FoldableBTree.checkFoldableBTree(root2)) {
			System.out.println("The tree can be folded");
		}
		else {
			System.out.println("The above tree cannot be folded");
		}
		
		// Third tree
		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2);
		root3.right = new TreeNode(3);
		root3.left.left = new TreeNode(4);
		root3.right.right = new TreeNode(5);
		root3.right.right.left = new TreeNode(6);
		root3.left.left.right = new TreeNode(7);
		root3.right.right.left.left = new TreeNode(6);
		
		root3.print();
		
		if(FoldableBTree.checkFoldableBTree(root3)) {
			System.out.println("The tree can be folded");
		}
		else {
			System.out.println("The above tree cannot be folded");
		}
	}

}
