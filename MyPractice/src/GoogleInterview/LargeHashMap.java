package GoogleInterview;

public class LargeHashMap {

	RangeTreeNode root;
	
	public LargeHashMap() {}
	
	// Put operation
	public void insert(int start, int end, String value) {
		if (root == null) {
			root = new RangeTreeNode(start, end, value);
			System.out.println("Start : " + start + " End : " + end + " Value : " + value + ". Inserted Successfully !");
		}
		else {
			if (root.insert(start, end, value)) {
				System.out.println("Start : " + start + " End : " + end + " Value : " + value + ". Inserted Successfully !");
			}
		}
	}
	
	// Get operation
	public String get(int key) {
		
		if (root == null) {
			return null;
		}
		
		RangeTreeNode crawler = root;
		while (crawler != null) {
			
			if (key >= crawler.start && key <= crawler.end) {
				return crawler.value;
			}
			else if (key <= crawler.start) {
				crawler = crawler.left;
			}
			else {
				crawler = crawler.right;
			}
		}		
		return null;
	}
	
	
	public static void main(String[] args) {
		
		LargeHashMap map = new LargeHashMap();
				
		// Insert statements
		System.out.println(" ----- Insert operations ---- \n");
		map.insert(5, 27, "abc");
		map.insert(80, 110, "xyz");
		map.insert(243, 10000, "def");
		map.insert(200, 133545, "uqwhuiq");
				
		// Get operations
		System.out.println(" \n\n----- Get operations ---- \n");
		System.out.println("Key -> " + 28 + " Value : " + map.get(28));
		System.out.println("Key -> " + 26 + " Value : " + map.get(26));
		System.out.println("Key -> " + 2987 + " Value : " + map.get(2987));
		System.out.println("Key -> " + 133545 + " Value : " + map.get(133545));
		System.out.println("Key -> " + 13354 + " Value : " + map.get(13354));
		System.out.println("Key -> " + 87 + " Value : " + map.get(87));
	}
}

class RangeTreeNode {
	
	public int start, end;
	public String value;
	public RangeTreeNode left, right;
	
	public RangeTreeNode() {}
	
	public RangeTreeNode(int start, int end, String value) {
		this.start = start;
		this.end = end;
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public boolean insert(int start, int end, String value) {
				
		if (isOverLap(this, new RangeTreeNode(start, end, value))) {
			System.out.println("Range with start : " + start + " and end : " + end + " cannot be inserted. Overlap found.");
			return false;
		}
		
		if (end < this.start) { // go left 
			if (this.left == null) {
				this.left = new RangeTreeNode(start, end, value);
			}
			else {
				return this.left.insert(start, end, value);
			}
		}
		
		else if (start > this.end) { // go end
			if (this.right == null) {
				this.right = new RangeTreeNode(start, end, value);
			}
			else {
				return this.right.insert(start, end, value);
			}
		}
		return true;
	}
	
	public boolean isOverLap(RangeTreeNode n1, RangeTreeNode n2) {
		if ( (n2.start >= n1.start && n2.start <= n1.end && n2.end >= n1.end) || 
				(n1.start >= n2.start && n1.start <= n2.end && n1.end >= n2.end) ) {
			return true;
		}
		
		if ( (n2.start <= n1.start && n2.end >= n1.end) || (n1.start <= n2.start && n1.end >= n2.end) ) {
			return true;
		}
		
		return false;
	}
}
