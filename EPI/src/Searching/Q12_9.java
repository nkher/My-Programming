package Searching;

public class Q12_9 {
	
	public static int kthLargestElement(int a[], int l, int r, int k) {
		
		if (k >= 0 && k <= (r-l+1)) {
			int pIndex = partition(a, l, r);
			
			if (pIndex-l == k-1) return a[pIndex];
			
			else if (pIndex-l < k-1) {
				kthLargestElement(a, pIndex+1, r, k); // search right sub array
			}
			else kthLargestElement(a, l, pIndex-1, (k - pIndex + 1 - l) ); // search left sub array
		}
		
		return Integer.MAX_VALUE;
	}
	
	public static int partition(int a[], int l, int r) {
		int pIndex = l, pivot = a[r];
		for (int i=l; i<r; i++) {
			if (a[i] <= pivot) {
				// swap ith and pIndex
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
 		}
		
		// swap pivot and pIndex
		a[r] = a[pIndex];
		a[pIndex] = pivot;
		
		return pIndex;
	}
	
	
	public static void main(String[] args) {
		int a[] = {12, 3, 5, 7, 4, 19, 26};
		
		System.out.println(kthLargestElement(a, 0, a.length-1, 3));
	}

}
