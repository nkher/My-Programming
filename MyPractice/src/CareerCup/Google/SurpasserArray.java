package CareerCup.Google;

import java.util.Arrays;

public class SurpasserArray {
	
	Node root;
	
	public SurpasserArray() {
	}
	
	public SurpasserArray(int data) {
		root = new Node(data);
	}
	
	public void surpasserArray(int a[]) {
		
		// Insert into tree and update the right counts appropriately
		for (int i=0;i<a.length;i++) {
			insertIntoTree(a[i]);
		}
		
		inorder(root);
		
		System.out.println();
		
		printRightCounts(root);
	}
	
	public void printRightCounts(Node n) {
		if (n != null) {
			printRightCounts(n.left);
			System.out.print(n.rightCount + "  ");
			printRightCounts(n.right);
		}
	}
	
	// This will insert into the binary tree and also update the right counts appropriately.
	public void insertIntoTree(int d) {
		
		Node newNode = new Node(d);
		if (root == null) {
			root = newNode;
			return;
		}
		else {
			Node parent;
			Node focusNode = root;
			
			while (true) {
				
				parent = focusNode;
				if (d <= focusNode.data) {
					focusNode = focusNode.left;
					if (focusNode == null) {
						focusNode = newNode;
						parent.left = focusNode;
						return;
					}
				}
				else {
					// updating the right count for this node and its left sub tree
					focusNode = focusNode.right;
					if (focusNode == null) {
						parent.rightCount++;
						updateleftsubtree(parent.left);
						focusNode = newNode;
						parent.right = focusNode;
						return;
					}
				}
			}
		}
	}
	
	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + ", ");
			inorder(root.right);
		}
	}
	
	public void updateleftsubtree(Node node) {
		if (node != null) {
			updateleftsubtree(node.left);
			node.rightCount = node.rightCount + 1;
			updateleftsubtree(node.right);
		}
	}
 	
	
	public static void main(String[] args) {
		
		SurpasserArray sa = new SurpasserArray();
		
		int a[] = {2, 7, 5, 5, 2, 7, 0, 8, 1};
		
		System.out.println(Arrays.toString(a));		
		sa.surpasserArray(a);

				
		// sa.inorder(sa.root);
	}

}

class Node {
	
	Node left, right;
	int data;
	int rightCount = 0;
	
	public Node() {};
	
	public Node(int d) {
		data = d;
	}
}