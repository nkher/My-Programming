package PalantirQuestions;

import java.util.ArrayList;
import java.util.Stack;

import BinaryTree.BSTNode;
import BinaryTree.BinarySearchTree;

public class TreeTraversalNoRecursion {

	public static int getSize(BSTNode root) {
		if (root == null) return 0;
		else
			return (getSize(root.right()) + 1 + getSize(root.left()));
	}
	
	public static void traverse_inorder(BSTNode root) {
		Stack<BSTNode> stack = new Stack<BSTNode>();
		BSTNode current = root;
		boolean check = true;
		while (check) {
			if (current != null) {
				stack.push(current);
				current = current.left(); // move to the left node
			}
			
			// check if the stack is empty
			// if yes then  backtrack from the empty subtree
			// and visit the node at the top of stack
			// pop it , print it and move o its right
			else {
				if (!stack.isEmpty()) {
					current = stack.pop();
					System.out.print(current.value() + " ");
					current = current.right();
				}
				else {
					check = false;
				}
			}
		}		
	}
	
	// R L V
	public static void traverse_preorder(BSTNode root) {
		Stack<BSTNode> stack = new Stack<BSTNode>();
		BSTNode current = root;
		boolean check = true;
		while (check) {
			if (current != null) {
				if (current.right() != null) {
					stack.push(current);
				}
				System.out.print(current.value() + " ");
				current = current.left();
			}
			else {
				if (!stack.isEmpty()) {
					current = stack.pop();
					current = current.right();	
				}
				else {
					check = false;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		bst.insert(10, 10);
		bst.insert(5, 5);
		bst.insert(15, 15);
		bst.insert(2, 2);
		bst.insert(8, 8);
		bst.insert(12, 12);
		bst.insert(18, 18);
		bst.insert(20, 20);
		bst.insert(11, 11);
		
		
		TreeTraversalNoRecursion.traverse_inorder(bst.root());
		System.out.println();
		TreeTraversalNoRecursion.traverse_preorder(bst.root());
		
		System.out.println();
		ArrayList<Integer> keyList = new ArrayList<Integer>();
		bst.getKeysPostOrder(bst.root(), keyList);
		System.out.println(keyList.toString());
		
	}
}
