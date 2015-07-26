package BloombergQuestions;

public class MaximumSubArray {
	
	// Find the maximum sum sub array
	
	
	// 1. Brute force algorithm
	public int maximumSumSubarray(int a[]) {
		int start=-1, end=-1;
		int len = a.length, ans = Integer.MIN_VALUE;
		for (int subArraySize=1;subArraySize<=len;subArraySize++) { //  iterating over the sub array sizes
			for (int startInd=0;startInd<len;startInd++) { // Iterating over from where to start
				
				if(startInd + subArraySize > len)  // handling array index out of bounds
					break;
				int sum = 0;
				for (int i=startInd;i<startInd+subArraySize;i++) { // go over each array of the given size, from each start index
					sum += a[i];
				}
				ans = Math.max(sum, ans);
				if(ans == sum) {
					start = startInd;
					end = startInd + subArraySize;
				}
			}
		}
		// print the array
		printArray(a, start, end-1);
		return ans;
	}
	
	// 2. O(N2 solution)
	public int maximumSubArray2(int a[]) {
		int start=-1, end=-1;
		int len = a.length, ans = Integer.MIN_VALUE;
		for (int startInd=0;startInd<len;startInd++) { // iterating over the different start indexes
			int sum = 0;
			for(int subArraySize=1;subArraySize<=len;subArraySize++) { // iterating over different array sizes
				if(startInd + subArraySize > len) // if out of index
					break;
				sum += a[startInd+subArraySize-1];
				ans = Math.max(sum, ans);
				if (ans == sum) {
					start = startInd;
					end = startInd + subArraySize - 1;
				}
			}
		}
		// print the array
		printArray(a, start, end);
		return ans;
	}
	
	// 3. Nlog(N) time complexity 
	public static int MSS1(int arr[], int size) {
		if(size == 1)
			return arr[0];
		int m = size/2;
		int left_MSS = MSS1(arr, m); // recurse over left half
		int right_MSS = MSS1(arr, size-m); //recurse over the right half
		int leftsum = Integer.MIN_VALUE, rightsum = Integer.MIN_VALUE;
		int sum = 0; // This will take care of the intermediate sums
		
		// Start from the leftmost point form the right sub array
		for(int i=m;i<size;i++) {
			sum += arr[i];
			rightsum = Math.max(sum, rightsum);
		}
		sum = 0;
		for(int i=(m-1);i>=0;i--) {
			sum += arr[i];
			leftsum = Math.max(sum, leftsum);
		}
		
		int ans = Math.max(left_MSS, right_MSS);
		return Math.max(ans, leftsum+rightsum);
	}
	
	// Helper function to print the array
	private void printArray(int a[], int low, int high) {
		System.out.print("[ ");
		for (int i=low; i<=high;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	// Kadanes algorithm
	public static int MSS2(int arr[]) {
		// The idea here is to start from the first index and then 
		// keep finding the maximum sub array for every index you reach 
		// in the array
		int sum = 0, ans =0; 
		for (int i=0;i<arr.length;i++) {
			if (sum + arr[i] > 0)
				sum += arr[i];
			else
				sum = 0;
			ans = Math.max(ans, sum);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// 3 -2 5 -1
		// lsa --> 3,-2 leftsum = 1
		// rsa --> 5, -1 rightsum = 4
		// therefore best possible for the sub array that has its start index in lsa and
		// end index in the rsa will be leftsum + rightsum = 4+1 = 5
		
		MaximumSubArray object = new MaximumSubArray();
		int[] arr = {1,-3,2,-5,7,6,-1,-4,11,-23};
		//int answer = object.maximumSubArray2(arr);
		//System.out.println("The largest sum is : " + answer);
		
		int ans = MSS1(arr, arr.length);
		System.out.println(ans);
		ans = MSS2(arr);
		System.out.println(ans);
	}

}
