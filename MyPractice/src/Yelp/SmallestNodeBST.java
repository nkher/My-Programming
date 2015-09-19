package Yelp;

import org.CTCILibrary.TreeNode;

public class SmallestNodeBST {

	TreeNode root;
	int size;
	
	public SmallestNodeBST() {}
	
	public void insert(int data) {
		System.out.println("Inserting : " + data);
		if (root == null) {
			root = new TreeNode(data);
		} else {
			root.insertInOrder(data);
		}
		size++;
	}
	
	public TreeNode smallest() {
		TreeNode temp = root;
		if (root != null)  {
			while (temp.left != null) 
				temp = temp.left;
			return temp;
		}
		return null;
	}
	
	public void print() {
		root.print();
	}
	
	public static void main(String args[]) {
		
		SmallestNodeBST bst = new SmallestNodeBST();
		
		bst.insert(50);
		bst.insert(60);
		bst.insert(40);
		bst.insert(55);
		bst.insert(65);
		bst.insert(20);
		bst.insert(47);
		
		// Printing the tree
		bst.print();
		
		System.out.println("Smallest element is: " + bst.smallest().data);
	}
}
