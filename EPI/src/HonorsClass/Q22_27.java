package HonorsClass;

import org.CTCILibrary.TreeNode;

public class Q22_27 {
	
	public static TreeNode convert(TreeNode root) {
		TreeNode head = convertCircular(root);
		head.left.right = null;
		head.left = null;
		return head;
	}
	
	public static TreeNode convertCircular(TreeNode root) {
		
		if (root  == null) return null;
				
		TreeNode part1 = convertCircular(root.left);
		TreeNode part3 = convertCircular(root.right);
		
		if (part1 == null && part3 == null) {
			root.left = root;
			root.right = root;
			return root;
		}
		
		TreeNode tail3 = part3 != null ? part3.left : null;
		
		/* join the prev to the head */
		if (part1 == null) {
			concat(part3.left, root);
		}
		else {
			concat(part1.left, root);
		}
		
		/* join the next to the centre */
		if (part3 == null) {
			concat(root, part1);
		}
		else {
			concat(root, part3);
		}
		
		/* Join the head and the tail */
		if (part1 != null && part3 != null) {
			concat(tail3, part1);
		}
		
		return part1 == null ? root : part1;
	}
	
	public static void concat(TreeNode x, TreeNode y) {
		x.right = y;
		y.left = x;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(50);
		root.insertInOrder(25);
		root.insertInOrder(10);
		root.insertInOrder(75);
		root.insertInOrder(100);
		root.insertInOrder(65);
		root.insertInOrder(35);
		
		root.print();
		
		TreeNode head = convert(root);
		
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
		
	}

}
