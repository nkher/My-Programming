package AmazonQuestions;

public class MaxSumArrayDisadjacent {
	
	// Gives maximum sum in the array such that no two elements are adjacent
	// Constraint Array must be positive
	public static int findSum(int a[]) {
		int exclusive_new = 0;
		int inclusive = a[0];
		int exclusive = 0;
		for (int i=1;i<a.length;i++) {
			exclusive_new = Math.max(inclusive, exclusive_new);
			inclusive = a[i] + exclusive;
			exclusive = exclusive_new; // Store the previous exclusive
		}
		return Math.max(inclusive, exclusive);
	}
	
	public static void main(String[] args) {
		int a[] = {5,67,2,456,121,345};
		System.out.println(MaxSumArrayDisadjacent.findSum(a));
	}

}
