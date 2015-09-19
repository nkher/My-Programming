package Searching;

public class Q12_5 {
	
	public static int squareRoot(int k) {
		int left = 0, right = k;
		while (left <= right) {
			int mid = left + (right-left)/2;			
			int midSq = mid * mid;
			
			if (midSq == k) return mid;
			else if (midSq > k) right = mid - 1;
			else left = mid+1;
		}
		
		return left - 1;
	}
	
	public static void main(String args[]) {
		
		System.out.println(squareRoot(30));
	}
}
