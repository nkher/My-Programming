package Palantir.Interview;

public class LongestAP {

	/* O(N^3) solution 
	 * The following function checks if there is an AP of atleast three numbers in the list
	 */
	
	public static boolean arithmeticThree(int set[]) {
		int n = set.length;
		
		// jth index will be the middle element
		for (int j=1; j<n-1; j++) { 
			
			// Initialize i and k for the currrent j
			int i = j-1, k = j+1;
			
			while (i >= 0 && k <= n-1) {
				if (set[i] + set[k] == 2*set[j])
					return true;
				
				// Check if j is closer to k or i and depending on that increment and decrement k and i
				if (set[i] + set[k] < 2*set[j]) k++;
				else i--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int set1[] = {1, 7, 10, 15, 27, 29};
		System.out.println(arithmeticThree(set1));
		
	}

}
