package HonorsClass;

import org.CTCILibrary.TreeNode;

public class Q22_31 {
	
	// TC = O(h)
	public static boolean searchMinFirstBST(TreeNode root, int key) {
		
		if (root == null || root.data > key) {
			return false;
		}
		else if (root.data == key) {
			return true;
		}
				
		// Search the right subtree recursively if the smallest key in the right subtree if greater than or equal to k
		if (root.right != null && key >= root.right.data) {
			return searchMinFirstBST(root.right, key);
		}
		
		return searchMinFirstBST(root.left, key);
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(13);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(11);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(19);
		root.right.right.left = new TreeNode(23);
		
		root.print();
		
		System.out.println(searchMinFirstBST(root, 23));
		
	}

}
