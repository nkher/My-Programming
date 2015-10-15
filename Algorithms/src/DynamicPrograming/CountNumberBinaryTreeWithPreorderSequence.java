package DynamicPrograming;

public class CountNumberBinaryTreeWithPreorderSequence {
	
	public static int countNumberBinaryTrees(int a[]) {
		
		if (a == null || a.length == 0) return 0;
		
		int n = a.length;
		int T[] = new int[n+1];
		T[0] = T[1] = 1; // only one tree with one node
		
		for (int i=2; i<=n; i++) {
			int sum = 0;
			for (int k=0; k<i; k++) {
				sum += T[k] * T[i-k-1];
			}
			T[i] = sum;
		}
		return T[n];
	}
	
	public static void main(String[] args) {
		
		int a[] = {10, 11, 12, 13, 14};
		System.out.println("Total number of trees with the given preorder sequence : " + countNumberBinaryTrees(a));
	}

}
