package AmazonQuestions;

import Library.TreeNode;

public class BTreeDiameter {
	
	public static int diameter(TreeNode root, int height) {
		// setting heights and initial diameters of trees
		int lh = 0, rh = 0;
		int ldia = 0, rdia = 0;
		if (root == null) {
			height = 0;
			return 0; // return diameter as zero
		}
		
		/* Get the heights of left and right subtrees in lh and rh
	    And store the returned values in ldia and rdia */
		ldia = diameter(root.left, lh);
		rdia = diameter(root.right, rh);
		
		/* Height of current node is max of heights of left and
	     right subtrees plus 1 */
		height = Math.max(lh, rh) + 1;
		
		return Math.max(lh + rh + 1, Math.max(ldia, rdia));
	}
	
	public static int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static int getDiameter(TreeNode node) {
		if(node == null) return 0;
		// get height of both right and left sub trees
		int lht = height(node.left);
		int rht = height(node.right);
		
		// get the diameter of both the left and right sub trees
		int ldia = getDiameter(node.left);
		int rdia = getDiameter(node.right);
		
		/* Return max of following three
		   1) Diameter of left subtree
		   2) Diameter of right subtree
		   3) Height of left subtree + height of right subtree + 1 */
		return Math.max(lht + rht + 1, Math.max(ldia, rdia));
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(25);
		root.right = new TreeNode(75);
		root.left.left = new TreeNode(12);
		root.left.right = new TreeNode(26);
		root.left.right.right = new TreeNode(27);
		root.left.right.right = new TreeNode(28);
		root.left.right.right = new TreeNode(29);
		root.left.right.right = new TreeNode(30);
		root.right.left = new TreeNode(70);
		root.right.right = new TreeNode(90);
		
		root.print();
		
		int diameter = getDiameter(root);
		System.out.println("Diameter of tree is " + diameter);
	}

}
