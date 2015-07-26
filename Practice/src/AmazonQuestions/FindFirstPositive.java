package AmazonQuestions;

public class FindFirstPositive {
	
	public static int f(int x) {
		return (x*x - 10*x - 10);
	}
	
	public static int findFirstPositive() {
		if (f(0) > 0) return 0;
		int i = 1;
		// Find 'high' for binary search by repeated doubling
		while(f(i) <= 0) 
			i = i * 2;
		
		// Doing a binary search between the previous i value which would be i/2 and i (current i value)
		return binarySearch(i/2, i);
	}
	
	public static int binarySearch(int low, int high) {
		if (high >= low) {
			int mid = (high+low)/2;
			// Applying binary search but here there is a specific condition to be checked along
			// If f(mid) > 0 then it does not mean that mid is the answer it could be possible that
			// f(mid-1) is also greater than 0, hence we check for two more conditions 
			// 1. mid == low
			// 2. f(mid-1) is negative
			// Hence either mid should be equal to low or its immediate predecessor should be less than 0
			if(f(mid) > 0 && (mid == low || f(mid-1) <=0))
				return mid;
			else if (f(mid) <= 0)
				return binarySearch((mid+1), high);
			else 
				return binarySearch(low, (mid-1));
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int i = findFirstPositive();
		System.out.println("The value of n where func f() becomes positive is " + i);
		
	}

}
