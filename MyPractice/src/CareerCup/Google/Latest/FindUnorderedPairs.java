package CareerCup.Google.Latest;

public class FindUnorderedPairs {

	private TreeNodeMod root;
	private int unorderedPairsCount = 0;
	
	public FindUnorderedPairs(int a[]) {
		root = new TreeNodeMod();
		findNumberOfUnorderedPairs(a);
	}
	
	
	private int findNumberOfUnorderedPairs(int a[]) {
		root.data = a[0]; // inserting the first element
		
		TreeNodeMod crawler = root;
		
		// creating the tree
		for (int i=1; i<a.length; i++) {
			
			crawler = root;
			while (true) {
				if (a[i] < crawler.data) { // goes to the left
					
					// calculate the unordered pair count
					unorderedPairsCount += crawler.rightSize + 1;
					if (crawler.left == null) { // can be inserted
						crawler.left = new TreeNodeMod(a[i]);
						break;
					}
					else {
						crawler = crawler.left;
					}
				}
				else { // goes to the right
					
					crawler.rightSize++;
					if (crawler.right == null) {
						crawler.right = new TreeNodeMod(a[i]);
						break;
					}
					else {
						crawler = crawler.right;
					}
				}
			}
		}
		return unorderedPairsCount;
	}
	
	public int getUnorderedPairsCount() {
		return unorderedPairsCount;
	}
	
	public TreeNodeMod root() { return root; } 
	
	public static void main(String[] args) {
		
		int a[] = {3, 2, 4, 1};
		FindUnorderedPairs object = new FindUnorderedPairs(a);
		System.out.println(object.getUnorderedPairsCount());
		
		int b[] = {2, 5, 4, 1, 3};
		FindUnorderedPairs object2 = new FindUnorderedPairs(b);
		System.out.println(object2.getUnorderedPairsCount());
	}
}

class TreeNodeMod {
	
	int data, rightSize;
	TreeNodeMod left, right;
	
	public TreeNodeMod() {
		this.rightSize = 0;
	}
	
	public TreeNodeMod(int data) {
		this.data = data;
		this.rightSize = 0;
	}
}


