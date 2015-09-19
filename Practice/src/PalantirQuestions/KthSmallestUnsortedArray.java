package PalantirQuestions;

public class KthSmallestUnsortedArray {
	
	// Worst Case - O(N^2)
	// Average Case - O(N)
	public int kthSmallest(int a[], int left, int right, int k) {
			
		if (k > 0 && k <= right-left+1) {
			int pivotIndex = partitionKthSmallest(a, left, right); // partition on last element
			
			// if the position is same as k then return
			if (pivotIndex-left == k-1) return pivotIndex;
			if (pivotIndex-left > k-1) // If position is more, recur for left subarray
				return kthSmallest(a, left, pivotIndex-1, k); 
			
			return kthSmallest(a, pivotIndex+1, right, (k-pivotIndex+left-1)); // if recursing in right sub array then k will change
		}
		return Integer.MAX_VALUE;
	}
	
	public int kthLargest(int a[], int left, int right, int k) {
		
		if (k > 0 && k <= right-left+1) {
			
			int pivotIndex = partitionKthLargest(a, left, right); // partition on last element
						
			// if the position is same as k then return
			if (pivotIndex-left == k-1) return pivotIndex;
			if (pivotIndex-left > k-1) // If position is more, recur for left subarray
				return kthLargest(a, left, pivotIndex-1, k); 
			return kthLargest(a, pivotIndex+1, right, (k-pivotIndex+left-1)); // if recursing in right sub array then k will change
		}
		return Integer.MAX_VALUE;
	}
	
	public int partitionKthLargest(int a[], int left, int right) {
		int pivot = a[right], i = left;
		for (int j=left;j<=right-1;j++) {
			if (a[j] >= pivot) {
				// swap a[i] and a[j], then increment i
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		// we get the pivot position, swap the last element with the element in the pivot position
		int temp = a[right];
		a[right] = a[i];
		a[i] = temp;
		return i;
	}
	
	public int partitionKthSmallest(int a[], int left, int right) {
		int pivot = a[right], i = left;
		for (int j=left;j<=right-1;j++) {
			if (a[j] <= pivot) {
				// swap a[i] and a[j], then increment i
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		// we get the pivot position, swap the last element with the element in the pivot position
		int temp = a[right];
		a[right] = a[i];
		a[i] = temp;
		return i;
	}
	
	public static void main(String[] args) {
		int a[] = {12, 3, 5, 7, 4, 19, 26, 1, 100, 25};
		KthSmallestUnsortedArray obj = new KthSmallestUnsortedArray();
		int result = obj.kthSmallest(a, 0, a.length-1, 2);
		System.out.println(a[result]);
		
		int b[] = {12, 3, 5, 7, 4, 19, 26, 1000, 750, 45, 10, -9};
		int res = obj.kthLargest(b, 0, b.length-1, 12);
		System.out.println(b[res]);
	}

}
