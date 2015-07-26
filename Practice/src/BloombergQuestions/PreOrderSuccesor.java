package BloombergQuestions;

import org.omg.PortableInterceptor.SUCCESSFUL;

import Library.TreeNode;

public class PreOrderSuccesor {

	public void printPreOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
	
	public TreeNode preOrderSuccesor(TreeNode root) {
		if (root == null) return null;
		if (root.left != null) {
			return root.left;
		}
		TreeNode parent = root.parent;
		if (root == parent.left) {
			while (parent.right == null) {
				parent = parent.parent;
			}
			return parent.right;
		}
		else {
			while (parent.right == null) {
				parent = parent.parent;
			}
			return parent.right;
		}
	}
	
	public static void main(String[] args) {
		
		PreOrderSuccesor object = new PreOrderSuccesor();
		
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
		
		object.printPreOrder(root);
		
		TreeNode sucessor = object.preOrderSuccesor(node8);
		if (sucessor != null)
			System.out.println("\nPreorder succ of " + node8.data + " is : " + sucessor.data);
		else
			System.out.println("Your given node is the last node in the tree");
	}

}
