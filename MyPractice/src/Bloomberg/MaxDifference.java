package Bloomberg;

public class MaxDifference {
	
	/* 
	 * Given an array arr[] of integers, find out the difference between any two elements 
	 * such that larger element appears after the smaller number in arr[].
	 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). 
	 * If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
	 * */
	
	// Method 1 - TC = O(n) and space  = O(n)
	public static int maxDifference(int a[]) {
		
		int n = a.length;
		int res[] = new int[n];
		
		int smallest = Integer.MAX_VALUE;
		
		for (int i=0; i<n; i++) {
			smallest = Math.min(smallest, a[i]);
			res[i] = a[i] - smallest;
		}
		
		int maxDiff = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			maxDiff = Math.max(maxDiff, res[i]);
		}
		
		return maxDiff;
	}
	
	// Method 2 - TC = O(n) and space = O(1)
	public static int maxDifferenceEff(int a[]) {
		
		int n = a.length;
		int maxDiff = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		
		for (int i=0; i<n; i++) {
			smallest = Math.min(smallest, a[i]);
			maxDiff = Math.max(maxDiff, a[i] - smallest);
		}
		
		return maxDiff;
	}
	
	public static void main(String[] args) {
		
		int a[] = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(maxDifference(a));
		System.out.println(maxDifferenceEff(a));
		
		int b[] = {7, 9, 5, 6, 3, 2};
		System.out.println(maxDifference(b));
		System.out.println(maxDifferenceEff(b));
		
		int c[] = {1, 2, 6, 80, 100};
		System.out.println(maxDifference(c));
		System.out.println(maxDifferenceEff(c));
		
		int d[] = {80, 2, 6, 3, 100};
		System.out.println(maxDifference(d));
		System.out.println(maxDifferenceEff(d));
	}

}
