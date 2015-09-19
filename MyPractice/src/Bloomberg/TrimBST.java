package Bloomberg;

import org.CTCILibrary.TreeNode;

public class TrimBST {
	
	// Time complexity = O(N)
	// We are basically performing a post order traversal
	public static TreeNode trimBST(TreeNode root, int min, int max) {
		
		if (root == null) return null;
		
		root.left = trimBST(root.left, min, max);
		root.right = trimBST(root.right, min, max);
		
		if (root.data >= min && root.data <= max) {
			return root;
		}
		if (root.data < min) {
			return root.right;
		}
		if (root.data > max) {
			return root.left;
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
		root.insertInOrder(3);
		root.insertInOrder(10);
		root.insertInOrder(1);
		root.insertInOrder(6);
		root.insertInOrder(4);
		root.insertInOrder(7);
		root.insertInOrder(14);
		root.insertInOrder(13);
		
		root.print();
		
		root = trimBST(root, 1, 10);
		
		root.print();
	}

}
