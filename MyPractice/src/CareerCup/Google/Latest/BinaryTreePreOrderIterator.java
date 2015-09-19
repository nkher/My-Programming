package CareerCup.Google.Latest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import org.CTCILibrary.TreeNode;

public class BinaryTreePreOrderIterator implements Iterator<TreeNode> {

	Stack<TreeNode> stack = new Stack<TreeNode>();
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	
	public BinaryTreePreOrderIterator(TreeNode root) {
		pushAllLeftsWithRight(root);
	}
	
	public void pushAllLeftsWithRight(TreeNode node) {
		while (node != null) {
			if (node.right != null) {
				stack.push(node);
			}
			queue.add(node);
			node = node.left;
		}
	}
	
	public boolean hasNext() {
		return (!stack.isEmpty());
	}

	public TreeNode next() {
		if (!hasNext()) {
			throw new NoSuchElementException("All nodes have been visited !");
		}
		
		TreeNode next;
		
		if (queue.isEmpty()) {
			next = stack.pop();
			pushAllLeftsWithRight(next.right);
		}
		
		next = queue.remove();
		
		return next;
	}
	
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		BinaryTreePreOrderIterator iter = new BinaryTreePreOrderIterator(root);
		while (iter.hasNext()) {
			list.add(iter.next().data);
		}
		return list;
	}
	
	public static void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
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
		
		preorder(root);
		
		System.out.println("\n\nUsing iterator : ");
		
		System.out.println(preorderTraversal(root).toString());

	}

}
