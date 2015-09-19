public class HeapImplementation {

	//To be called recursively till whole array is checked
	public void Build_Max_Heap(int[] heap)
	{
		int heapSize = heap.length;
			for (int i=(int)Math.floor(heapSize/2); i>=0; i--){
				Max_Heapify(heap, i);
			}
	}
	
	public void Max_Heapify(int[] heap, int i){
		
		int heapSize = heap.length;
		int l = (2*i)+1;
		int r = (2*i)+2;
		int largest = i;
		
		//Assigning the largest to either parent or two of the children
		if(l < heapSize || r < heapSize){
			if((l <= heapSize) && (heap[l] > heap[i])){
				largest = l;
			}
			else{
				largest = i;
			}
			if((r <= heapSize) && (heap[r] > heap[largest])){
				largest = r;
			}
		}
		//Confirming that parent is not the largest
		if(largest != i){
			//Exchange the parent with the largest
			int temp = heap[i];
			heap[i] = heap[largest];
			heap[largest] = temp;
			
			//Calling the MaxHeapify again
			Max_Heapify(heap, largest);
		}
	}
	
	public void displayArray(int[] array)
	{
		System.out.println("Elements of Array are: ");
		for (int i=0;i<array.length;i++)
		{
			System.out.println(i + "th " + "Element :" + array[i]);
		}
	}

	public static void main(String[] args) {
		
		HeapImplementation obj =  new HeapImplementation();
		
		//int heap[] = {23,98,2,45,34,3,12,1,90};
		//int heap[] = {2,4,1};
		//int heap[] = {5,1,5,4,2,3,0};
		//int heap[] = {5,4,5,1,2,3,0};
		int heap[] = {12,58,63,85,17,44,32,7};
		
		int heapSize = heap.length;
		
		//Display elements of the heap
		obj.displayArray(heap);	
		
		//To call function Max_Heapify to make the array into a Max_Heap
		obj.Build_Max_Heap(heap);
		
		//Display elements of the heap after Max_Heapify
		obj.displayArray(heap);
				
	}

}
