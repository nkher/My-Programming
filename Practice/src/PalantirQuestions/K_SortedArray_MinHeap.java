package PalantirQuestions;

import java.util.Arrays;

//1) Create a Min Heap of size k+1 with first k+1 elements. This will take 
//O(k) time (See this GFact)
//2) One by one remove min element from heap, put it in result array, and 
//add a new element to heap from remaining elements.
//
//Removing an element and adding a new element to min heap will take Log(k) time. 
//So overall complexity will be O(k) + O((n-k)*logK)
// O(k) in space

public class K_SortedArray_MinHeap {
	
	public void minHeapify(MinHeap minH, int idx) {
		int left  = (2*idx+1);
		int right = (2*idx+2);
		int smallest = idx;
		
		if (left < minH.size && minH.a[left] < minH.a[idx])
			smallest = left;
		if (right < minH.size && minH.a[right] < minH.a[smallest])
			smallest = right;
		
		if (smallest != idx) {
			// Swap largest and idx
			int temp = minH.a[smallest];
			minH.a[smallest] = minH.a[idx];
			minH.a[idx] = temp;
			minHeapify(minH, smallest);
		}
	}
	
	public MinHeap buildMinHeap(int a[], int size) {
		int i;
		MinHeap minH = new MinHeap();
		minH.size = size;
		minH.a = a;
		
		for (i=(minH.size-2/2);i>=0;i--) {
			minHeapify(minH, i);
		}
		return minH;
	}
	
	public int extractMin(MinHeap minheap) {
		int root = minheap.a[0];
		if (minheap.size > 1) {
			minheap.a[0] = minheap.a[minheap.size-1];
			minheap.size--;
			minHeapify(minheap, 0);
		}
		return root;
	}
	
	// Method to change root with given value x, and return the old root
	public int replaceMin(MinHeap minheap, int x) {
		int root = minheap.a[0];
		minheap.a[0] = x;
		if (root < x) 
			minHeapify(minheap, 0);
		return root;
	}
	
	// Given an array of size n, where every element is k away from its target
	// position, sorts the array in O(nLogk) time.
	public void ksort(int arr[], int k) {
		int n = arr.length;
		// Create a minheap of k+1 elements
		int heaparr[] = new int[k+1];
		for (int i=0; i<=k && i<n; i++) 
			heaparr[i] = arr[i];
				
		// create a minheap from the heap array
		MinHeap minheap = buildMinHeap(heaparr, k+1);
				
		// i is index for remaining elements in arr[] and ti
	    // is target index of for cuurent minimum element in
	    // Min Heap 'hp'
		for (int i=k+1, ti=0; ti < n; i++, ti++) {
			// If there are remaining elements, then place
	        // root of heap at target index and add arr[i]
	        // to Min Heap
			if (i < n) 
				arr[ti] = replaceMin(minheap, arr[i]);
			
			// Otherwise place root at its target index and
	        // reduce heap size
			else
				arr[ti] = extractMin(minheap);
		}
	}
	
	public static void main(String[] args) {
		K_SortedArray_MinHeap obj = new K_SortedArray_MinHeap();
		int k = 3;
	    int arr[] = {2, 6, 3, 12, 56, 8};
	    
	    obj.ksort(arr, k);
	    System.out.println("K - sorted array is : ");
	    System.out.println(Arrays.toString(arr));

	}
}

class MinHeap {
	int size;
	int[] a;
}
