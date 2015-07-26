package com.CTCI.Chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.CTCILibrary.AssortedMethods;
import org.CTCILibrary.TreeNode;

// Create a linked list of all the nodes in a binary search tree by the level
public class Question4_4 {
	
	// Takes O(N) time and O(N) data
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
		// Inserting the root node
		if(root != null)
			currentLevel.add(root);
		while(currentLevel.size() > 0) { // Traverse till the current size is greater than zero
			result.add(currentLevel); // Add the first level at index 0 to the array list
			LinkedList<TreeNode> parentLevel = currentLevel;
			currentLevel = new LinkedList<TreeNode>();
			for (TreeNode node : parentLevel) {
				// Check the children and add it to the next level
				if (node.left != null)
					currentLevel.add(node.left);
				if(node.right != null)
					currentLevel.add(node.right);
			}
		}
		return result;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.println("Link list at depth " + depth + ":");
			while(i.hasNext()) {
				System.out.println(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	
	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

}
