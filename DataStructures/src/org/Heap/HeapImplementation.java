		package org.Heap;

public class HeapImplementation {
	
	// Max heapify function
	public void maxHeapify(MaxHeap maxHeap, int idx){
		
		int largest = idx;
		int left = (2*idx)+1;
		int right = (2*idx)+2;
		
		// See if left child exists and is greater than root
		if(left < maxHeap.size && maxHeap.array[left] > maxHeap.array[largest])
			largest = left;
		
		// See if left child exists and is greater than root
		if(right < maxHeap.size && maxHeap.array[right] > maxHeap.array[largest])
			largest = right;
		
		if(largest != idx){
			// Swapping the largest and the idx
			int temp = maxHeap.array[largest];
			maxHeap.array[largest] = maxHeap.array[idx];
			maxHeap.array[idx] = temp;	
			maxHeapify(maxHeap, largest);
		}			
	}
	
	// Function to create a max heap
	public MaxHeap createAndBuildHeap(int[] array, int size){
		
		int i;
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.size = size;
		maxHeap.array = array;
		
				// Start from bottom most and rightmost internal mode and heapify all
	    // internal modes in bottom up way
		for(i= (maxHeap.size-2)/2; i>=0; --i)
			maxHeapify(maxHeap, i);
		
		return maxHeap;
	}
	
	// Main function to sort the heap
	public void heapSort(int[] array, int size){
		
		// Build a max heap from the input data
		MaxHeap maxHeap = new MaxHeap();
		maxHeap = createAndBuildHeap(array, size);
		
		// Repeat following steps while heap size is greater than 1. The last
	    // element in max heap will be the minimum element
		while(maxHeap.size > 1){
			
			// The largest item in Heap is stored at the root. Replace it with the 
		    // last item of the heap followed by reducing the size of heap by 1.
			int temp = maxHeap.array[0];
			maxHeap.array[0] = maxHeap.array[maxHeap.size - 1];
			maxHeap.array[maxHeap.size - 1] = temp;
			--maxHeap.size;
			
			// Now heapify the root of the tree
			maxHeapify(maxHeap, 0);
		}
	}
	
	public void printHeap(int[] array, int size){
		
		int i;
	    for(i=0;i<size;++i)
	    	System.out.print(array[i] + " ");
	    
	    System.out.println();
	}
	
	public static void main(String args[]){
		
		HeapImplementation object =  new HeapImplementation();
		
		int heapArray[] = {12, 11, 13, 5, 6, 7};
		int size = heapArray.length;
		
		System.out.println("Given array is: ");
		object.printHeap(heapArray, size);
		
		object.heapSort(heapArray, size);
		
		System.out.println("Array after heap sort is: ");
		object.printHeap(heapArray, size);
	}
	
}

class MaxHeap {
	int size;
	int[] array;
}