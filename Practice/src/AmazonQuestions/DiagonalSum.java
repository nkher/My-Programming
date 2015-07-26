package AmazonQuestions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class DiagonalSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);
        root.left.left.right = new TreeNode(10);
        
        Tree tree = new Tree(root);
        tree.diagonalSum();
	}
}

class TreeNode {
	int data;
	int vd;
	TreeNode left, right;
	
	public TreeNode(int data) {
		this.data = data;
		vd = Integer.MAX_VALUE;
		left = null;
		right = null;
	}
}

class Tree {
	
	TreeNode root;
	
	public Tree(TreeNode root) {
		this.root = root;
	}
	
	public void diagonalSum() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		this.root.vd = 0;
		queue.add(this.root);
		
		while(!queue.isEmpty()) {
			
			// Remove the front tree node from queue.
			TreeNode current = queue.remove();
			
			// Get the vertical distance of the dequeued node.
			int vd = current.vd;
			while(current != null) {
				
				// Sum over this node's right-child, right-of-right-child
	            // and so on
				int prevSum = (map.get(vd) == null) ? 0 : map.get(vd);
				map.put(vd, prevSum + current.data);
				
				// If for any node the left child is not null add
                // it to the queue for future processing.
				if(current.left != null) {
					current.left.vd = vd+1;
					queue.add(current.left);
				}
				
				// Move to the right child
				current = current.right;
			}
		}
		
		// Make an entry set from map
		Set<Entry<Integer, Integer>> set = map.entrySet();
		
		// Make an iterator
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();
		
		// Traverse using the iterator
		while(iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.println(me.getValue() + " ");
		}
	}
}