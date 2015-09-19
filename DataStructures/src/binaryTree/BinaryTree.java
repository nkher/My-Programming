package binaryTree;

import java.util.Scanner;
import binaryTree.BinaryTreeNode;

public class BinaryTree {

	BinaryTreeNode root;
	
	/* Function to the get the size of the binary tree using Recursion*/
	
	public int size(BinaryTreeNode root){
		if(root != null){
			return (size(root.leftChild) + 1 + size(root.rightChild));
		}
		else
			return 0;
	}
	
	/* Checking if a Binary Search Tree is balanced or not -- Function 1 */
	
	public boolean isBalanced1(BinaryTreeNode root) {
		if (root == null) return true;
		int heightDiff = size(root.leftChild) - size(root.rightChild);
		System.out.println("Left Height  : " + size(root.leftChild));
		System.out.println("Right Height  :" + size(root.rightChild));
		if (Math.abs(heightDiff) > 1) {
			return false;
		}
		else 
			return isBalanced1(root.rightChild) && isBalanced1(root.rightChild);
	}
	
	/* Checking if a Binary Search Tree is balanced or not -- Function 2 */
	
	public boolean isBalanced2(BinaryTreeNode root) {
		if (root == null) return true;
		else 
			return (Math.abs(getMaxDepthBST(root) - getMinDepthBST(root)) <=1 );
	}
	
	
	/* Print all possible paths in a BST 
	 * 2 Functions are used 
	 * A. printPathsBSTUsingRecursion and 
	 * B. printPath to actually print the path*/
	
	public void printPathsBSTUsingRecursion(BinaryTreeNode root, int[] path, int pathLen){
		if(root==null) return;
		
		//Append the node to the pathArray
		path[pathLen++] = root.data;
		
		//If it is a leaf then print
		if(root.leftChild == null && root.rightChild == null){
			printPath(path, pathLen);
		}
		
		//Else goto left and then right part
		else{
			printPathsBSTUsingRecursion(root.leftChild, path, pathLen);
			printPathsBSTUsingRecursion(root.rightChild, path, pathLen);
		}
	}
	
	public void printPath(int[] path, int pathLen){
		System.out.println("----------Printing Path------------");
		System.out.println();
		System.out.print("\tdc");
		for(int i=0;i<pathLen;i++){
			System.out.print(path[i] + "-");
		}
		System.out.println();
		System.out.println();
	}
	
	/* End of printing path functions */
	
	/* Function to insert into the Binary Search Tree */
	
	public void insertIntoBinarySearchTree(int key){
		
		BinaryTreeNode btn = new BinaryTreeNode();
		if(root==null){
			root = btn;
			root.data = key;
		}
		
		else{
			BinaryTreeNode focusNode = root;
			BinaryTreeNode parent;
			
			while(true){
				
				parent=focusNode;
				if(key<focusNode.data){			
					focusNode=focusNode.leftChild;
					if(focusNode==null){
						btn.data=key;
						parent.leftChild=btn;
						return;
					}
				}
				else{
					focusNode=focusNode.rightChild;
					if(focusNode==null){
						btn.data=key;
						parent.rightChild=btn;
						return;
					}
				}
			}
		}
	}
	
	/* Check if two bTrees are the same */
	public int checkSimilarBTree(BinaryTreeNode root1, BinaryTreeNode root2){
		
		int retValue = 0;
		// Both Trees have no node
		if(root1 == null && root2 == null) retValue = 0;
		
		else if(root1 != null && root2 != null){
			if(root1.data == root2.data){ 
				   retValue = 1;
				   checkSimilarBTree(root1.leftChild, root2.leftChild);
				   checkSimilarBTree(root1.rightChild, root2.rightChild);
			}
			else {
				retValue = 0;
			}
		}
		return retValue;
	}
	
	/* Find to get the depth of the Binary Tree using Recursion*/
	
	public int getMaxDepthBST(BinaryTreeNode root){
		if(root==null)
			return 0;
		else{
			int leftDepth = getMaxDepthBST(root.leftChild);
			int rightDepth = getMaxDepthBST(root.rightChild);
			
			if(leftDepth > rightDepth)
				return (leftDepth + 1);
			else
				return (rightDepth + 1);
		}
	}
	
	/* Find to get the depth of the Binary Tree using Recursion*/
	
	public int getMinDepthBST(BinaryTreeNode root){
		if(root==null)
			return 0;
		else{
			int leftDepth = getMinDepthBST(root.leftChild);
			int rightDepth = getMinDepthBST(root.rightChild);
			
			if(leftDepth < rightDepth)
				return (leftDepth + 1);
			else
				return (rightDepth + 1);
		}
	}
	
	/* Find minimum element using Recursion*/
	
	public int findMinUsingRecursion(BinaryTreeNode root){
		if(root != null){
			if(root.leftChild != null)
				return findMinUsingRecursion(root.leftChild);
		}
		return root.data;
	}
	
	/* Find minimum element using Iteration*/
	
	public int findMinUsingIteration(){
		BinaryTreeNode minNode;
		minNode=root;
		if(root != null){
			while(minNode.leftChild!=null){
				minNode = minNode.leftChild;
			}
		}
		return minNode.data;
	}
	
	/* Find maximum element using Recursion*/
	
	public int findMaxUsingRecursion(BinaryTreeNode root){
		if(root!=null){
			if(root.rightChild!=null)
				return findMaxUsingRecursion(root.rightChild);
		}
		return root.data;
	}
	
	/* Find maximum element using Iteration*/
	
	public int findMaxUsingIteration(){
		BinaryTreeNode maxNode;
		maxNode=root;
		if(root != null){
			while(maxNode.rightChild!=null){
				maxNode = maxNode.rightChild;
			}
		}
		return maxNode.data;
	}
	
	/* Function to do a divide and conquer search on the tree */
	
	public int searchBST(BinaryTreeNode root, int key){
		int retValue=0;
		if(root!=null){
			if(root.data == key)
				retValue = 1;
			else if(root.data > key)
				return searchBST(root.leftChild, key);
			else if(root.data < key)
				return searchBST(root.rightChild, key);
		}
		else if(root==null)
			retValue = 0;
		
		return retValue; 
	}
	
	/* Function to check if a Tree is a Binary search Tree */
	
	public int isBST(BinaryTreeNode root){
		
		int returnValue=0;
		if(root != null){
			
			// If both the children are present
			
			if(root.leftChild != null && root.rightChild != null){
				if(root.data > root.leftChild.data && root.data < root.rightChild.data){
					System.out.println("Node with Data " + root.data + " is Ok.");
					return(isBST(root.leftChild) & isBST(root.rightChild));
				}
				else{
					System.out.println("Node with Data " + root.data + " is not Ok.");
					returnValue = 0;
				}
			}
			
			//If only left node is present
			
			else if(root.leftChild != null && root.rightChild == null){
				if(root.data > root.leftChild.data){
					System.out.println("Node with Data " + root.data + " is Ok.");
					return(isBST(root.leftChild));
				}
				else{
					System.out.println("Node with Data " + root.data + " is not Ok.");
					returnValue = 0;
				}
			}
			
			//If only right node is present
			
			else if(root.leftChild == null && root.rightChild != null){
				if(root.data < root.rightChild.data){
					System.out.println("Node with Data " + root.data + " is Ok.");
					return(isBST(root.rightChild));
				}
				else{
					System.out.println("Node with Data " + root.data + " is not Ok.");
					returnValue = 0;
				}
			}
			
			//If no child is present
			
			else{
				System.out.println("Node with Data " + root.data + " is Ok.");
				returnValue = 1;
			}	
		}
		else if(root == null){
			System.out.println("Tree is Empty !!");
			returnValue = 0;
		}
		
		return returnValue;
	}
	
	/* For Doing an inOrderTraversal on the Tree */
	
	public void inOrderTraversal(BinaryTreeNode root){
		if(root!=null){
			inOrderTraversal(root.leftChild);
			System.out.println(root.data);
			inOrderTraversal(root.rightChild);
		}
	}
	
	/* For Doing a preOrderTraversal on the Tree */
	
	public void preOrderTraversal(BinaryTreeNode root){
		if(root!=null){
			System.out.println(root.data);
			preOrderTraversal(root.leftChild);
			preOrderTraversal(root.rightChild);
		}
	}
	
	/* For Doing a postOrderTraversal on the Tree */
	
	public void postOrderTraversal(BinaryTreeNode root){
		if(root!=null){
			postOrderTraversal(root.leftChild);
			postOrderTraversal(root.rightChild);
			System.out.println(root.data);
		}
	}
	
		
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		
		BinaryTree bTree = new BinaryTree();
		
		//Inserting into binary tree
		bTree.insertIntoBinarySearchTree(20);
		bTree.insertIntoBinarySearchTree(10);
		bTree.insertIntoBinarySearchTree(40);
		
		//Size
		System.out.println("Size of the btree now is:" + bTree.size(bTree.root));
		
		//Insertion
		bTree.insertIntoBinarySearchTree(5);
		bTree.insertIntoBinarySearchTree(15);
		bTree.insertIntoBinarySearchTree(30);
		bTree.insertIntoBinarySearchTree(80);
		bTree.insertIntoBinarySearchTree(90);
		bTree.insertIntoBinarySearchTree(100);
		
		//Display
		System.out.println("The following is In Order Traversal.");
		bTree.inOrderTraversal(bTree.root);
		System.out.println("The following is Pre Order Traversal.");
		bTree.preOrderTraversal(bTree.root);
		System.out.println("The following is Post Order Traversal.");
		bTree.postOrderTraversal(bTree.root);
		
		//Size
		System.out.println("Size of the btree now is:" + bTree.size(bTree.root));
		
		//To find the minimum element Using Iteration
		System.out.println("The Smallest Element Using Iteration :" + bTree.findMinUsingIteration());
		
		//To find the maximum element Using Iteration
		System.out.println("The Largest Element Using Iteration :" + bTree.findMaxUsingIteration());

		//To find the minimum element Using Recursion
		System.out.println("The Smallest Element Using Recursion :" + bTree.findMinUsingRecursion(bTree.root));
		
		//To find the maximum element Using Recursion
		System.out.println("The Largest Element Using Recursion :" + bTree.findMaxUsingRecursion(bTree.root));
		
		//Calling the maximum depth of the B-Tree
		System.out.println("Maximum Depth of the B-Tree is : " +  bTree.getMaxDepthBST(bTree.root));
		
		//Checking if an element is present or not
		System.out.println("Please enter the element to be searched.");
		int key = scan.nextInt();
		int returnValue = bTree.searchBST(bTree.root, key);
		if(returnValue == 1){
			System.out.println("Element Exists");
		}
		else if(returnValue == 0){
			System.out.println("Element Does Not Exist");
		}
		
		/* Verifying if a the Tree bTree is a BST */
		
		bTree.isBST(bTree.root);
		
		//Printing all the paths in the Btree
		int path[] = new int[100];
		bTree.printPathsBSTUsingRecursion(bTree.root, path, 0);
		
		//Creating two btrees, inserting values and checking them
		BinaryTree bTree1 =  new BinaryTree();
		BinaryTree bTree2 =  new BinaryTree();
		bTree1.insertIntoBinarySearchTree(10);
		bTree1.insertIntoBinarySearchTree(40);
		bTree1.insertIntoBinarySearchTree(30);
		bTree1.insertIntoBinarySearchTree(50);
		
		bTree2.insertIntoBinarySearchTree(10);
		bTree2.insertIntoBinarySearchTree(40);
		bTree2.insertIntoBinarySearchTree(30);
		bTree2.insertIntoBinarySearchTree(50);
		int ret = bTree1.checkSimilarBTree(bTree.root, bTree2.root);
		if(ret == 1)
			System.out.println("They are similar");
		else if(ret == 0)
			System.out.println("Not Similar");
		bTree1.inOrderTraversal(bTree1.root);
		bTree1.inOrderTraversal(bTree2.root);
		
		// Checkging if balanced
		BinaryTree bTree3 =  new BinaryTree();
		bTree3.insertIntoBinarySearchTree(50);
		bTree3.insertIntoBinarySearchTree(60);
		bTree3.insertIntoBinarySearchTree(40);
		bTree3.insertIntoBinarySearchTree(30);
		bTree3.insertIntoBinarySearchTree(45);
		bTree3.insertIntoBinarySearchTree(55);
		bTree3.insertIntoBinarySearchTree(65);
		
		boolean retVal = bTree3.isBalanced1(bTree3.root);
		if (!retVal) System.out.println("Not balanced");
		else System.out.println("Balanced");
		System.out.println(bTree3.isBalanced2(bTree3.root));
//		bTree3.insertIntoBinarySearchTree(90);
//		bTree3.insertIntoBinarySearchTree(5);
//		bTree3.insertIntoBinarySearchTree(52);
//		bTree3.insertIntoBinarySearchTree(13);
		
		BinaryTree bTree4 = new BinaryTree();
		bTree4.insertIntoBinarySearchTree(50);
		bTree4.insertIntoBinarySearchTree(30);
		bTree4.insertIntoBinarySearchTree(10);
		bTree4.insertIntoBinarySearchTree(20);
		bTree4.insertIntoBinarySearchTree(70);
		bTree4.insertIntoBinarySearchTree(60);
		bTree4.insertIntoBinarySearchTree(80);
		bTree4.inOrderTraversal(bTree4.root);
		
		
	}
}
