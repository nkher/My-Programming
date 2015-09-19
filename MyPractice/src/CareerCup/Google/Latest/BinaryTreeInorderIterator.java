package CareerCup.Google.Latest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.CTCILibrary.TreeNode;

public class BinaryTreeInorderIterator implements Iterator<TreeNode> {

	Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public BinaryTreeInorderIterator(TreeNode root) {
		pushAllLeftChildren(root);
	}
	
	private void pushAllLeftChildren(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public TreeNode next() {
		if (!hasNext()) {
			throw new NoSuchElementException("All nodes have been visited !");
		}
		
		TreeNode next = stack.pop();
		// this is an important step. Push the left nodes of the right child of the next into the stack (Similar to what we did in inorder without recursion)
		pushAllLeftChildren(next.right);
		
		return next;
	}
	
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		BinaryTreeInorderIterator iterator = new BinaryTreeInorderIterator(root);
		ArrayList<Integer> results = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			results.add(iterator.next().data);
		}
		return results;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.insertInOrder(40);
		root.insertInOrder(30);
		root.insertInOrder(45);
		root.insertInOrder(20);
		root.insertInOrder(70);
		root.insertInOrder(80);
		root.insertInOrder(65);
		
		root.print();
		
		ArrayList<Integer> list = inorderTraversal(root);
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}



}
