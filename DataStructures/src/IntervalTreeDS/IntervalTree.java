package IntervalTreeDS;

public class IntervalTree {
	
	public ITNode newNode(Interval i) {
		ITNode temp = new ITNode();
		temp.i = new Interval(i.low, i.high);
		temp.max = i.high;
		temp.left = temp.right = null;
		return temp;
	}
	
	// A utility function to insert a new Interval Search Tree Node
	// This is similar to BST Insert.  Here the low value of interval
	// is used tomaintain BST property
	public ITNode insert(ITNode root, Interval i) {
				
		// Base case: Tree is empty, new node becomes root
		if (root == null) 
			return newNode(i);
		
		// Get low value of interval at root
		int l = root.i.low;
		
		// If root's low value is smaller, then new interval goes to
	    // left subtree
		if (i.low < l) {
			root.left = insert(root.left, i);
		}
		
		// Else, new node goes to right subtree.
		else
			root.right = insert(root.right, i);
		
		// Update the max value of this ancestor if needed
		if (root.max < i.high) root.max = i.high;
		
		return root;
	}
	
	// A utility function to check if given two intervals overlap
	public boolean doOverlap(Interval i1, Interval i2) {
		if (i1.low <= i2.high && i2.low <= i1.high) return true;
		return false;
	}
	
	// The main function that searches a given interval i in a given
	// Interval Tree.
	public Interval overlapSearch(ITNode root, Interval i) {
		
		// Base case, tree is empty
		if (root == null) return null;
		
		// If given interval overlaps with root
		if (doOverlap(i, root.i)) {
			return root.i;
		}
		
		// If left child of root is present and max of left child is
	    // greater than or equal to given interval, then i may
	    // overlap with an interval is left subtree
		if (root.left != null && root.left.max >= i.low) {
			return overlapSearch(root.left, i);
		}
		
		// Else interval can only overlap with right subtree
		return overlapSearch(root.right, i);
	}		
	
	public void inorder(ITNode root) {
		if (root == null) return;
		
		inorder(root.left);
		
		System.out.println("[" + root.i.low + ", " + root.i.high + "] max = " + root.max);
		inorder(root.right);
	}
	
	public static void main(String args[]) {
		
		IntervalTree object = new IntervalTree();
		Interval[] ints = {new Interval(15, 20), new Interval(10, 30), new Interval(17, 19),
				new Interval(5, 20), new Interval(12, 15), new Interval(30, 40)};
		
		ITNode root = null;
		for (int i=0;i<ints.length;i++) {
			root = object.insert(root, ints[i]);
		}
		
		System.out.println("Inorder traversal of constructed Interval Tree is\n");
		object.inorder(root);
		
		Interval x = new Interval(6, 7);
		
		System.out.println("Searching for interval: " + x.low + ", " + x.high);
		
		Interval res = object.overlapSearch(root, x);
		
		if (res == null) 
			System.out.println("\nNo Overlapping Interval");
		else System.out.println("\nOverlaps with [" + 	res.low + ", " + res.high + "]");
		
	}
}

class Interval {
	int low, high;
	
	public Interval() {}
	
	public Interval(int x, int y) {
		low = x;
		high = y;
	}
}

class ITNode {
	Interval i; // i could also be a normal variable
	int max;
	ITNode left, right;
	
	public ITNode() {
		i = new Interval();
	}
}


