package AmazonQuestions;

public class RearrangeNumbers {

	// Question: The following functions takes in an array containing positive and negative numbers
	// and gives the rearranged array as output (Alternate negative and positive numbers)
	// Example : Input --> [ -7, 8, 10, 14, -1, -2, -6, -9 ]
	// 			 Output -->  [ 10, -1, 14, -6, 8, -7, -2, -9 ] 
	// We will use concept of quicksort
	
	public static int[] rearrangeNumbers(int a[], int len) {
		int zeroPInd = -1;
		// The following few lines are similar to partition process
	    // of QuickSort.  The idea is to consider 0 as pivot and
	    // divide the array around it.
		for(int j=0;j<len;j++) {
			if(a[j] < 0) {
				zeroPInd++;
				// Swap jth and zeroPInd elements
				int temp = a[j];
				a[j] = a[zeroPInd];
				a[zeroPInd] = temp;
			}
		}
		
		// Now using some indexes for doing further calculations
		int pos = zeroPInd + 1, neg = 0;
		while((pos < len) && (neg < pos) && (a[neg] < 0)) {
			// swap positive and negative
			int temp = a[pos];
			a[pos] = a[neg];
			a[neg] = temp;
			pos++; //increment positive by 1
			neg = neg  + 2; //increment negative by 2
		}
		return a;
	}
	
	public static void print(int a[]) {
		System.out.print("[ ");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]\n");
	}
	
	public static void main(String[] args) {
		int a[] = {-7,8,10,14,-1,-2,-6, 9, 88};
		// initial array
		print(a);
		a = rearrangeNumbers(a, a.length);
		// resultant array
		print(a);
	}
}
