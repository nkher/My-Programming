package BloombergQuestions;

import Library.TreeNode;

public class InOrderSuccessor {

	public TreeNode inorderSuccesor(TreeNode root) {
		TreeNode temp, parent;
		if (root.right != null) {
			temp = root.right;
			while(temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}
		else if (root.left == null && root.right == null) {
			parent = root.parent;
			if(parent.left == root) {
				return parent;
			}
			else {
				// call the successor of the parent and check if the root is the
				// left child
				root = parent;
				parent = root.parent;
				while (parent != null) {
					if(parent.left == root) {
						return parent;
					}
					root = parent;
					parent = root.parent;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		InOrderSuccessor object = new InOrderSuccessor();
		
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(20);
		TreeNode node7 = new TreeNode(6);
		TreeNode node8 = new TreeNode(8);
		
		
		root.setLeftChild(node1);
		root.setRightChild(node4);
		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		node4.setLeftChild(node5);
		node4.setRightChild(node6);
		node3.setLeftChild(node7);
		node3.setRightChild(node8);
		
		root.print();
		
		TreeNode result = object.inorderSuccesor(root);
		if (result != null) {
			System.out.println("In order successor of " + root.data + " is : " + result.data);
		}
		else {
			System.out.println(node6.data + " is the last node in the tree" );
		}
		
		TreeNode root2 = new TreeNode(100);
		root2.left = new TreeNode(50);
		root2.left.right = new TreeNode(75);
		
		
		root2.print();
		result = object.inorderSuccesor(root2);
		if (result != null) {
			System.out.println("In order successor of " + root2.data + " is : " + result.data);
		}
		else {
			System.out.println(root2.data + " does not have an inorder successor" );
		}
	}
}
