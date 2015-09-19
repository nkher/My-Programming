package Leetcode.Google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.CTCILibrary.TreeNode;

public class RightViewBinaryTree {

public static List<Integer> rightSideView(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i=0; i<size; i++) {
                TreeNode top = queue.remove();
                if (i == 0) {
                    list.add(top.data);
                }
                
                if (top.right != null) {
                    queue.add(top.right);
                }
                
                if (top.left != null) {
                    queue.add(top.left);
                }
            }
        }
        return list;
    }
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		System.out.println(rightSideView(root).toString());
	}
}
