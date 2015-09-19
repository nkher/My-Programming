package HonorsClass;

public class Q22_42 {
	
	// TC = O(n) and space complexity = O(1)
	public static int calculateTrappingWater(int A[]) {
		
		if (A == null || A.length == 0) return 0;
		
		int n = A.length;
		int maxHt = -1, maxHtInd = -1;
		for (int i=0;i<A.length;i++) {
			if (A[i] > maxHt) {
				maxHt = A[i];
				maxHtInd = i;
			}
		}
		
		int sum = 0, left = A[0];
		for (int i=1; i < maxHtInd; i++) {
			if (A[i] >= left) {
				left = A[i];
			}
			else {
				sum += left - A[i];
			}
		}
		
		int right = A[n-1];
		for (int i=n-1; i > maxHtInd; i--) {
			if (A[i] >= right) {
				right = A[i];
			}
			else {
				sum += right - A[i];
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		int A[] = {1, 2, 1, 3, 3, 4 ,4, 5, 1, 2, 0, 3};
		
		System.out.println(calculateTrappingWater(A));
	}

}
