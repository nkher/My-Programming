package AmazonQuestions;

import Library.BTreePrinter;
import Library.LinkedListNode;
import Library.TreeNode;

public class BinaryTreeToDLL {

	public static LinkedListNode binTreeToDLL(TreeNode treenode) {
		// Base case
		if (treenode == null) return null;
		// Convert to DLL using binTreeToDLLUtil
		LinkedListNode listnode = binTreeToDLLUtil(treenode);
		// bintree2listUtil() returns root node of the converted
	    // DLL.  We need pointer to the leftmost node which is
	    // head of the constructed DLL, so move to the leftmost node
		while(listnode.prev != null)
			listnode = listnode.prev;
		
		return listnode;
	}
	
	public static LinkedListNode binTreeToDLLUtil(TreeNode treenode) {
		
		LinkedListNode root = new LinkedListNode(treenode.data, null, null);;
		
		// base case
		if(root == null) return root;
		
		// Convert the left sub tree to convert it
		if (treenode.left != null) {
			LinkedListNode left = binTreeToDLLUtil(treenode.left);	
			 // Find in order predecessor. After this loop, left
	        // will point to the in order predecessor
			for (; left.next != null; left = left.next);
			// Make root as next of the predecessor AND
			left.next = root;
			// Make predecessor as previous of root
			root.prev = left;
		}
		// Convert the right sub tree
		if (treenode.right != null) {
			LinkedListNode right = binTreeToDLLUtil(treenode.right);
			 // Find in order predecessor. After this loop, right
	        // will point to the in order predecessor
			for (; right.prev != null; right = right.prev);
			// Make root as next of the predecessor AND
			right.prev = root;
			// Make predecessor as previous of root
			root.next = right;
		}
		return root;
	}
	
	public static LinkedListNode binTreeToDLLPreOrder(TreeNode treenode) {
		// Base case
		if (treenode == null) return null;
		// Convert to DLL using binTreeToDLLUtil
		while (treenode.left != null) {
			treenode = treenode.left;
		}
		LinkedListNode listnode = binTreeToDLLUtilPreOrder(treenode);
		// bintree2listUtil() returns root node of the converted
	    // DLL.  We need pointer to the leftmost node which is
	    // head of the constructed DLL, so move to the leftmost node
		while(listnode.prev != null)
			listnode = listnode.prev;
		
		return listnode;
	}
	
	public static LinkedListNode binTreeToDLLUtilPreOrder(TreeNode treenode) {
		
		LinkedListNode leftmost = new LinkedListNode(treenode.data, null, null);;
		
		// base case
		if(leftmost == null) return leftmost;
		
		// Convert the left sub tree to convert it
		if (treenode.parent != null) {
			LinkedListNode left = binTreeToDLLUtilPreOrder(treenode.parent);	
			 // Find in order predecessor. After this loop, left
	        // will point to the in order predecessor
			for (; left.next != null; left = left.next);
			// Make root as next of the predecessor AND
			left.next = leftmost;
			// Make predecessor as previous of root
			leftmost.prev = left;
		}
		// Convert the right sub tree
		if (treenode.right != null) {
			LinkedListNode right = binTreeToDLLUtilPreOrder(treenode.right);
			 // Find in order predecessor. After this loop, right
	        // will point to the in order predecessor
			for (; right.prev != null; right = right.prev);
			// Make root as next of the predecessor AND
			right.prev = leftmost;
			// Make predecessor as previous of root
			leftmost.next = right;
		}
		return leftmost;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.right.left.left = new TreeNode(6);
		
		BTreePrinter.printNode(root);
		
		LinkedListNode head = BinaryTreeToDLL.binTreeToDLL(root);
		System.out.println(head.printForward());
		
		head = BinaryTreeToDLL.binTreeToDLLPreOrder(root);
		System.out.println(head.printForward());
	}

}
