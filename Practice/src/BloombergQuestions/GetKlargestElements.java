package BloombergQuestions;

public class GetKlargestElements {
	
	public void maxheapify(MaxHeap maxheap, int idx) {
		int largest = idx;
		int left = (2*idx) +1;
		int right = (2*idx) +2;
		
		// get the largest
		if(left < maxheap.size && maxheap.array[left] > maxheap.array[largest]) 
			largest = left;
		if(right < maxheap.size && maxheap.array[right] > maxheap.array[largest])
			largest = right;
		if (largest != idx) {
			// swap the largest and the idx
			int temp = maxheap.array[idx];
			maxheap.array[idx] = maxheap.array[largest];
			maxheap.array[largest] = temp;
			// now maxheapify the largest again
			maxheapify(maxheap, largest);
		}
	}
	
	public MaxHeap createAndBuildHeapFromArray(int[] array, int size) {
		MaxHeap maxheap = new MaxHeap();
		maxheap.array = array;
		maxheap.size = size;
		
		for (int i=maxheap.size/2;i>=0;i--) {
			maxheapify(maxheap, i);
		}
		return maxheap;
	}
	
	public void heapsort(int[] array, int size) {
		// build a max heap
		MaxHeap heap = new MaxHeap();
		heap = createAndBuildHeapFromArray(array, size);
		
		// now do the heap sort
		// repeat till the heap size is more than 1
		while (heap.size > 1) {
			// Step 1 - Get the root element
			int temp = heap.array[0];
			// Step 2 - Replace with the last element
			heap.array[0] = heap.array[heap.size-1];
			heap.array[heap.size-1] = temp;
			// Step 3 - Decrease the size
			heap.size--;
			// Step 4 - Run max heapify on the root of the tree
			maxheapify(heap, 0);
		}
	}
	
	public MaxHeap extractMax(MaxHeap heap) {
		int temp = heap.array[0];
		heap.array[0] = heap.array[heap.size-1];
		heap.array[heap.size-1] = temp;
		heap.size--;
		maxheapify(heap, 0);
		return heap;
	}
	
	public void printHeap(int[] array, int size){
		
		int i;
	    for(i=0;i<size;++i)
	    	System.out.print(array[i] + " ");
	    
	    System.out.println();
	}
	
	public static void main(String args[]) {
		
		GetKlargestElements object = new GetKlargestElements();
		
		int heapArray[] = {12, 11, 13, 5, 6, 7};
		int size = heapArray.length;
		
		MaxHeap heap = new MaxHeap();
		heap = object.createAndBuildHeapFromArray(heapArray, size);
		
		for (int i=0;i<3;i++) {
			System.out.println(heap.array[0]);
			// System.out.println("Size : " + heap.size);
			heap = object.extractMax(heap);
		}
	}
	
}

class MaxHeap {
	int size;
	int array[];
}
