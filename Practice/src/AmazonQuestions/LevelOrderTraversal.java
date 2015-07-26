package AmazonQuestions;

import java.util.ArrayList;

import BinaryTree.BSTNode;
import BinaryTree.BinarySearchTree;

public class LevelOrderTraversal {
	
	public void printLevelOrderTraversal(BSTNode root, int depth) {
		for (int i=0;i<=depth-1;i++) {
			System.out.println("Printing level " + i);
			printLevel(root, i);
			System.out.println();
		}
	}
	
	private void printLevel(BSTNode root, int level) {
		if (root == null) return;
		if (level == 0) 
			System.out.print(root.key() + " ");
		else {
			printLevel(root.left(), level-1);
			printLevel(root.right(), level-1);
		}
	}
	
	public void printEveryOtherLevel(BSTNode root, int depth) {
		for (int i=0;i<depth;) {
			System.out.println("Printing level " + i);
			printLevel(root, i);
			System.out.println();
			i += 2;
		}
	}
	
	public static void main(String[] args) {
		
		LevelOrderTraversal lot = new LevelOrderTraversal();
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		bst.insert(4, 4);
		bst.insert(2, 2);
		bst.insert(1, 1);
		bst.insert(3, 3);
		bst.insert(6, 6);
		bst.insert(5, 5);
		bst.insert(7, 7);
		
		ArrayList<Integer> keyList = new ArrayList<Integer>();
		try {
			bst.getKeysPreOrder(bst.root(), keyList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<keyList.size();i++) {
			System.out.print(keyList.get(i) + " ");
		}
		
		System.out.println();
		int depth = bst.depth(bst.root());
		lot.printLevelOrderTraversal(bst.root(), depth);
		
		System.out.println("\n\n Printing every other level \n\n");
		lot.printEveryOtherLevel(bst.root(), depth);
	}
}
