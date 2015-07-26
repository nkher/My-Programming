package AmazonQuestions;


public class BuilTreeInPre {
	
	public static BTreeNode buildBinaryTree(char[] inOrderA, char preOrderA[], int inStart, int inEnd) {
		int preIndex = 0;
		
		if (inStart < inEnd) return null;
		
		// Pick first node from preorder array
		BTreeNode node = new BTreeNode(preOrderA[preIndex]);
		preIndex++; //increment the index
		
		// return if the node does not have any children
		if (inStart == inEnd)
			return node;
		
		// find the index in the pre order array
		int inIndex = search(inOrderA, inStart, inEnd, node.data);
		
		// now construct the left and right subtrees using inIndex
		node.left = buildBinaryTree(inOrderA, preOrderA, inStart, inIndex-1);
		node.right = buildBinaryTree(inOrderA, preOrderA, inIndex+1, inEnd);
		
		return node;
	}
	
	public static int search(char arr[], int strt, int end, char value) {
		int i;
		for (i=strt;i<=end;i++) {
			if(arr[i] == value)
				return i;
		}
		return -1;
	}
	
	public static void postOrder(BTreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.data);
		}
	}
	
	public static void inOrder(BTreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	
	public static void main(String[] args) {
		char in[] = {'D', 'B', 'E', 'A', 'F', 'C'};
		char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
		int len  = in.length;
		BTreeNode root = BuilTreeInPre.buildBinaryTree(in, pre, 0, len-1);
		
		postOrder(root);
		inOrder(root);
	}

}

class BTreeNode {
	
	char data;
	BTreeNode left;
	BTreeNode right;
	BTreeNode parent;
	public int size = 0;
	
	public BTreeNode(char data) {
		this.data = data;
		size = 1;
	}
	
	public void setLeftChild(BTreeNode left) {
		this.left = left;
		if(left != null) {
			left.parent = this;
		}
	}
	
	public void setRightChild(BTreeNode right) {
		this.right = right;
		if(right != null) {
			right.parent = this;
		}
	}
}
