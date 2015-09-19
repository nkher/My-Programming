package CareerCup.Google.Latest;

public class CountTreeNodesInRange {
	
	public static int getRangeCount(BSTNode root, int min, int max) {
		
		// Get count of all nodes below min and max and return the subtraction
		return getLesserNodeCount(root, max + 1) - getLesserNodeCount(root, min);
	}
	
	public static int getLesserNodeCount(BSTNode node, int val) {
		if (node == null) {
			return 0;
		}
		else if (val <= node.data) {
			return getLesserNodeCount(node.left, val);
		} 
		return (1 + node.leftSize + getLesserNodeCount(node.right, val));
	}
	
	public static void main(String args[]) {
		
		BSTNode root = new BSTNode(50);
		root.insertBST(25);
		root.insertBST(83);
		root.insertBST(20);
		root.insertBST(30);
		root.insertBST(62);
		root.insertBST(115);
		root.insertBST(1);
		root.insertBST(14);
		root.insertBST(28);
		root.insertBST(33);
		root.insertBST(56);
		root.insertBST(77);
		root.insertBST(112);
		
		System.out.println(getRangeCount(root, 45, 90));
	}
}

class BSTNode {
	
	public int data;
	public BSTNode left, right;
	public int leftSize = 0;
	
	public BSTNode(int data) {
		this.data = data;
	}
	
	public void insertBST(int d) {
		if (d <= this.data) {
			this.leftSize++;
			if (this.left == null) {
				this.left = new BSTNode(d);
			}
			else {
				left.insertBST(d);
			}
		}
		else {
			if (this.right == null) {
				this.right = new BSTNode(d);
			}
			else {
				right.insertBST(d);
			}
		}
	}
	
	public void inorder(BSTNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}
}
