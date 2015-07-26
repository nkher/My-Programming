package AmazonQuestions;

public class BinaryTreeImpl {
	
	public ReturnNode findDeepestNode(Node1 root) {
		ReturnNode temp = new ReturnNode();
		Node1 temp1 = null;
		temp = findMaxDepth(root, temp1);
		return temp;
	}
	
	public ReturnNode findMaxDepth(Node1 root, Node1 prev) {  
		if(root == null) {
			return new ReturnNode(prev, 0);
		}
		else {
			prev = root;
			ReturnNode left = findMaxDepth(root.left, prev); 
			ReturnNode right = findMaxDepth(root.right, prev);      
			
			if(left.depth > right.depth) {
				left.depth += 1; 
				return left;
			}
			else {
				right.depth += 1;
				return right;    
			}
		}
	}
	
	public static void main(String[] args) {
		Node1 root = new Node1(1);
		root.left = new Node1(2);
		root.right = new Node1(3);
		root.right.right = new Node1(4);
		root.right.right.right = new Node1(5);
		
		BinaryTreeImpl object = new BinaryTreeImpl();
		ReturnNode node = object.findDeepestNode(root);
		System.out.println("Node Data " + node.node.id);
		System.out.println("Node Depth " + node.depth);
	}

}
	
class Node1 {
	int id;
	Node1 left;
	Node1 right;
	
	public Node1(int d) {
		id = d;
	}
}

class ReturnNode {
	Node1 node;
	int depth;
	
	public ReturnNode() {}

	public ReturnNode (Node1 node, int depth) {
		this.depth = depth;
		this.node = node;
	}
}
