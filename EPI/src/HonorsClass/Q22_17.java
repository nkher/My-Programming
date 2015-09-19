package HonorsClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import Library.HeapObject;

public class Q22_17 {
	
	/* Method 1 using a kth Largest element and a max heap. T.C = O(N * log k) 
	 * There is a better algorithm in O(N). Do that too. */
	public static ArrayList<Integer> findKClosestToMedian(int a[], int k) {
		
		ArrayList<Integer> kClosestElem = new ArrayList<Integer>();
		int n = a.length;
		int pos = (n/2)+1;
		int median = getMedianFromUnsortedArray(a, 0, a.length-1, pos);
		median = a[median]; // just getting the actual median from the index		
		System.out.println("Median is : " + median);
		
		PriorityQueue<HeapObject> maxHeap = new PriorityQueue<HeapObject>(Collections.reverseOrder());
		
		int i = 0;
		// fill the first k elements in the heap
		for (; i<k; i++) {
			maxHeap.add(new HeapObject(i, Math.abs(median - a[i])));
		}
		
		// now make the check for the next five elements and then add them
		while (i < n) {
			
			int rootDifference = maxHeap.peek().data;
			int currDiff = Math.abs(median - a[i]);
			if (rootDifference > currDiff) { // eligible for insertion
				maxHeap.remove();
				maxHeap.add(new HeapObject(i, currDiff));
			}
			i++;
		}
		
		while (!maxHeap.isEmpty()) {
			int topIdx = maxHeap.peek().index;
			kClosestElem.add(a[topIdx]);
			maxHeap.remove();
		}
		
		return kClosestElem;
	}
	
	public static int getMedianFromUnsortedArray(int a[], int start, int end, int k) {
		
		if (k > 0 && k <= (end-start+1)) {
			
			int pIndex = partition(a, start, end);
			
			if (pIndex-start == k - 1) {
				return pIndex;
			}
			
			if (pIndex-start > k-1) { // go for the left sub array
				return getMedianFromUnsortedArray(a, start, pIndex-1, k);
			}
			return getMedianFromUnsortedArray(a, pIndex+1, end, k+start-pIndex-1);
		}
		
		return Integer.MAX_VALUE;
	}
	
	public static int partition(int a[], int low, int high) {
		int pIndex = low, pivot = a[high];
		
		for (int i=low; i<high; i++) {
			if (a[i] >= pivot) {
				//swap
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		
		// swap the pIndex and the pivot
		int temp = a[high];
		a[high] = a[pIndex];
		a[pIndex] = temp;
		
		return pIndex;
	}
	
	public static void main(String[] args) {
			
		int a[] = {7, 14, 10, 12, 2, 11, 29, 3, 4};
		System.out.println(findKClosestToMedian(a, 5));
		
		int b[] = {7, 14, 10, 12, 2, 11, 29, 3, 4};
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
	}	
}


