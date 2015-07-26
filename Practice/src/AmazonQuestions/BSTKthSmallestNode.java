package AmazonQuestions;

public class BSTKthSmallestNode {

	int data;
	int leftCount;
	BSTKthSmallestNode left;
	BSTKthSmallestNode right;
	BSTKthSmallestNode parent;
	public int size = 0;
	
	public BSTKthSmallestNode(int data) {
		this.data = data;
		size = 1;
	}
	
	public void setLeftChild(BSTKthSmallestNode left) {
		this.left = left;
		if(left != null) {
			left.parent = right;
		}
	}
	
	public void setRightChild(BSTKthSmallestNode right) {
		this.right = right;
		if(right != null) {
			right.parent = this;
		}
	}

	public void insertIntoBST(int d) {
		if (d <= data) {
			leftCount++;
			if (left == null) {
				setLeftChild(new BSTKthSmallestNode(d));
			}
			else {
				left.insertIntoBST(d);
			}
		}
		else {
			if (right == null) {
				setRightChild(new BSTKthSmallestNode(d));
			}
			else {
				right.insertIntoBST(d);
			}
		}
		size++;
	}
	
	public BSTKthSmallestNode kthSmallest(BSTKthSmallestNode root, int kth) {
		BSTKthSmallestNode pTraverse = root;
		if (root != null) {
			while(pTraverse != null) { // Goto kth smallest
				if (kth == (pTraverse.leftCount  + 1)) {
					return pTraverse;
				}
				else if(kth > (pTraverse.leftCount)) {
					/*  There are less nodes on left subtree Go to right subtree */
					kth = kth - (pTraverse.leftCount + 1); // modifying the value of k
					pTraverse = pTraverse.right;
				}
				else {
					pTraverse = pTraverse.left;
				}
			}
		}
		return pTraverse;
	}
	
	public static void inOrderTraversal(BSTKthSmallestNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.println("Node is : " + node.data + " Left Count : " + node.leftCount);
			inOrderTraversal(node.right);
		}
	}
	
	public static void main(String[] args) {
		BSTKthSmallestNode root = new BSTKthSmallestNode(20);
		root.insertIntoBST(8);
		root.insertIntoBST(22);
		root.insertIntoBST(4);
		root.insertIntoBST(12);
		root.insertIntoBST(10);
		root.insertIntoBST(14);
		//root.insertIntoBST(9);
		
		// Printing in order traversal
		inOrderTraversal(root);
		
		BSTKthSmallestNode node1 = root.kthSmallest(root, 3);
		System.out.println("3rd smallest is " + node1.data);
		BSTKthSmallestNode node2 = root.kthSmallest(root, 4);
		System.out.println("4rth smallest is " + node2.data);
	}
}
