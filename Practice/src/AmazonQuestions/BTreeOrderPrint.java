package AmazonQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import Library.BTreePrinter;
import Library.TreeNode;

public class BTreeOrderPrint {

	/*
	 *  	 15
            /  \
          13    14
        /  \    /  \
       9   10  11   12
      / \  / \ / \  / \
     1  2  3 4 5 6  7 8
	 print - 1 8 2 7 3 6 4 5 9 12 10 11 13 14 15 
	*/
	public static void printSpecificOrder(TreeNode node, int level) {
		TreeNode lpointer = node;
		TreeNode rpointer = node;
		int depth = getDepth(node);
		for (int i=0;i<3;i++) {
			while(level != depth-2) {
				if (lpointer.left != null && rpointer.right != null) {
					lpointer = lpointer.left;
					rpointer = rpointer.right;
				}
				level++;
			}
			if (level == depth) {
				System.out.println(lpointer.data + " " + rpointer.data);
			}
			level = 0;
		}
	}
	
	public static int getDepth(TreeNode root) {
		if (root == null) return 0;
		else {
			return 1 + Math.max(getDepth(root.left), getDepth(root.right));
		}
	}
	
	public static int getSize(TreeNode root) {
		if (root == null) return 0;
		return (getSize(root.left) + 1 + getSize(root.right));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(13);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(10);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(12);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(5);
		root.right.left.right = new TreeNode(6);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		
		BTreePrinter.printNode(root);
		
		printSpecificOrder(root, 0);
	}

}
