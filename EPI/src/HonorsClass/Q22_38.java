package HonorsClass;

public class Q22_38 {
	
	public static int maxSubArraySumCircularArray(int a[]) {
		
		return Math.max(findMaxSubArraySum(a), findMaxSubArraySumCircular(a));
	}
	
	// non circular solution
	public static int findMaxSubArraySum(int a[]) {
		int maxTill = 0, max = 0;
		for (int i=0; i<a.length; i++) {
			maxTill = Math.max(maxTill + a[i], a[i]);
			max = Math.max(maxTill, max);
		}
		return max;
	}
	
	// calculating the circular solution
	public static int findMaxSubArraySumCircular(int a[]) {
		
		int n = a.length;
		
		// max sum subarray starting at index 0 and ending at index i
		int[] maxBegin = new int[n];
		int sum = a[0];
		maxBegin[0] = sum;
		for (int i=1; i<n; i++) {
			sum += a[i];
			maxBegin[i] = Math.max(sum, maxBegin[i-1]);
		}
		
		
		// max sum subarray starting at index (i+1) and ending at index i
		sum = 0;
		int maxEnd[] = new int[n];
		for (int i=n-2; i>=0; i--) {
			sum += a[i+1];
			maxEnd[i] = Math.max(sum, maxEnd[i+1]);
		}
		
		// now calculate the maximum index at i using both of the above arrays
		int circularMax = 0;
		for (int i=0; i<n; i++) {
			circularMax = Math.max(circularMax, (maxBegin[i] + maxEnd[i]));
		}
		
		return circularMax;
	}
	
	public static void main(String[] args) {
		
		int a[] = {904, 40, 523, 12, -335, -385, -124, 481, -31};
		System.out.println(maxSubArraySumCircularArray(a));
		
		int b[] = {22, -44, 36, 18, -3, 18, 2, 24, -10, -200, 30, 88};
		System.out.println(maxSubArraySumCircularArray(b));
	}

}
