package BloombergQuestions;

import java.util.Arrays;

public class MaxJumpsArray {
	
	/* In this method, we build a jumps[] array from left to 
	 * right such that jumps[i] indicates the minimum number of jumps 
	 * needed to reach arr[i] from arr[0]. Finally, we return jumps[n-1].
	 */
	
	public static int minJumps(int a[], int n) {
		int jumps[] = new int[n];
		// If size of array is zero or first element is zero then no way to reach the end
		if(n == 0 || a[0] == 0)
			return Integer.MAX_VALUE;
		// initialize the first position to zero
		jumps[0] = 0;
		int i, j;
		for(i=1;i<n;i++) {
			jumps[i] = Integer.MAX_VALUE;
			for(j=0;j<i;j++) {
				if((i<=j+a[j]) && (jumps[j] != Integer.MAX_VALUE)) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		System.out.println(Arrays.toString(jumps));
		return jumps[n-1];
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int a[] = {1, 3, 6, 1, 0, 9};
		int size = a.length;
		System.out.println("Minimum number of jumps are : " + MaxJumpsArray.minJumps(arr, arr.length));
	}

}
