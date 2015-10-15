package Sorting;

public class HeapSort {

	//Function to swap two numbers
	public void swap(int a, int b){
		int temp;
		temp = a;
		a = b;
		b = temp;
	}
	
	//Max Heapify function that make a heap into a max heap
	public void maxHeapify(MaxHeap maxHeap, int index){
		
		int largest = index;
		int left = 2*index +1; // Left child
		int right = 2*index +2; // Right child
		
		//See if left child of root exists and is greater than root
		if(left < maxHeap.size && maxHeap.array[left] > maxHeap.array[largest])
			largest = left;

		//See if right child of root exists and is greater than largest
		if(right < maxHeap.size && maxHeap.array[right] > maxHeap.array[largest])
			largest = right;
		
		//Change the root if needed
		if(largest != index){
			swap(maxHeap.array[largest], maxHeap.array[index]);
			maxHeapify(maxHeap, largest);
		}
	}
	
	//Running the Max Heap Function for n/2 times
	public MaxHeap buildMaxHeap(int array[], int size){
		int i;
		MaxHeap maxHeap =  new MaxHeap();
		maxHeap.size = size;
		maxHeap.array = array;
		
		//Start from bottom most non leaf to the root
		for(i = (maxHeap.size-2)/2;i>=0;i++)
			maxHeapify(maxHeap, i);
		
		return maxHeap;
	}
	
	public void printArray(int array[], int size){
		int i;
		for(i=0; i<size;++i)
			System.out.println(array[i]);
	}
	
	//Sort an array of a given size
	public void heapSort(int array[], int size){
		
		//Build a heap from the input data
		MaxHeap maxHeap = buildMaxHeap(array, size);
		
		//Repeat following steps while heap size is greater than 1. 
	    //The last element in max heap will be the minimum element
		while(maxHeap.size > 1){
			//The largest item in Heap is stored at the root. Replace it with the 
		    //last item of the heap followed by reducing the size of heap by 1.
			swap(maxHeap.array[0], maxHeap.array[maxHeap.size - 1]);
			--maxHeap.size;
		}
		
		//Finally heapify the root of the tree
		maxHeapify(maxHeap, 0);
	}
	
	public static void main(String[] args) {
		
			HeapSort heapSort = new HeapSort();	
			int arr[] = {12,11,13,5,6,7};
			int size = arr.length;
			System.out.println("Given array is : ");
			heapSort.printArray(arr, size);			
			heapSort.heapSort(arr, size);
			System.out.println("Sorted array is :");
			heapSort.printArray(arr, size);
	}

}

class MaxHeap{
	int size;
	int[] array;
}
