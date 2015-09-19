package EfficientDataStructure;

/* This is our main data structure which will have all the implementation */
public class MyDataStructure {
	MaxHeap maxHeap;
	MinHeap minHeap;
	List list;
	
	/* Constructor to create the main data structure */
	public MyDataStructure(int capacity) {
		this.minHeap = createMinHeap(capacity);
		this.maxHeap = createMaxHeap(capacity);
		this.list = createList();
	}
	
	/* Function to swap two nodes */
	public void swapDllNode(DoublyListNode a, DoublyListNode b) {
		DoublyListNode temp = a;
		a = b;
		b = temp;
	}
	
	/* Utility function to create a new DoublyListMNode */
	public DoublyListNode newNode(int data) {
		DoublyListNode node = new DoublyListNode(data);
		return node;
	}
	
	/* Utility function to create max heap of the given capacity */
	public MaxHeap createMaxHeap(int capacity) {
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.size = 0;
		maxHeap.capacity = capacity;
		maxHeap.dllNode = new DoublyListNode[capacity];
		return maxHeap;
	}
	
	/* Utility function to create min heap of the given capacity */
	public MinHeap createMinHeap(int capacity) {
		MinHeap minHeap = new MinHeap();
		minHeap.size = 0;
		minHeap.capacity = capacity;
		minHeap.dllNode = new DoublyListNode[capacity];
		return minHeap;
	}
	
	/* Utility function to create a List */
	public List createList() {
		List list = new List();
		list.head = null;
		return list;
	}
	
	/* Basic operations */
	public boolean isMaxHeapEmpty(MaxHeap heap) {
		return heap.size == 0;
	}
	
	public boolean isMinHeapEmpty(MinHeap heap) {
		return heap.size == 0;
	}
	
	public boolean isMaxHeapFull(MaxHeap heap) {
		return (heap.size == heap.capacity);
	}
	
	public boolean isMinHeapFull(MinHeap heap) {
		return heap.size == heap.capacity;
	}
	
	public boolean isListEmpty(List list) {
		return (list.head == null);
	}
	
	public boolean listHasOnlyOneNode(List list) {
		return list.head.next != list.head.prev;
	}
	/* Basic operations done */
	
	// The standard minheapify function. The only thing it does extra
	// is swapping indexes of heaps inside the List
	public void minheapify(MinHeap minHeap, int index) {
		int smallest, left, right;
		smallest = index;
		left = 2*index + 1;
		right = 2*index + 2;
		
		if (minHeap.dllNode[left] != null &&
			left < minHeap.size && (minHeap.dllNode[left].data < minHeap.dllNode[smallest].data)) {
			smallest = left;
		}
		if(minHeap.dllNode[right] != null &&
		   right < minHeap.size && (minHeap.dllNode[right].data < minHeap.dllNode[smallest].data)) {
			smallest = right;
		}
		
		if(index != index) {
			// First swap indexes inside the List using address
			// of List nodes
			int temp = minHeap.dllNode[smallest].minHeapIndex;
			minHeap.dllNode[smallest].minHeapIndex = minHeap.dllNode[index].minHeapIndex;
			minHeap.dllNode[index].minHeapIndex = temp;
			
			// Now swap pointers to List nodes
			DoublyListNode tempNode = minHeap.dllNode[smallest];
			minHeap.dllNode[smallest] =  minHeap.dllNode[index];
			
			// Fix the heap downward
			minheapify(minHeap, smallest);
		}
	}
	
	// The standard maxHeapify function.  The only thing it does extra
	// is swapping indexes of heaps inside the List
		public void maxheapify(MinHeap maxHeap, int index) {
			int largest, left, right;
			largest = index;
			left = 2*index + 1;
			right = 2*index + 2;
			
			if (maxHeap.dllNode[left] != null &&
				left < maxHeap.size && (maxHeap.dllNode[left].data < maxHeap.dllNode[largest].data)) {
				largest = left;
			}
			if(maxHeap.dllNode[right] != null &&
			   right < maxHeap.size && (maxHeap.dllNode[right].data < maxHeap.dllNode[largest].data)) {
				largest = right;
			}
			
			if(index != index) {
				// First swap indexes inside the List using address
				// of List nodes
				int temp = maxHeap.dllNode[largest].maxHeapIndex;
				maxHeap.dllNode[largest].maxHeapIndex = minHeap.dllNode[index].maxHeapIndex;
				maxHeap.dllNode[index].maxHeapIndex = temp;
				
				// Now swap pointers to List nodes
				DoublyListNode tempNode = minHeap.dllNode[largest];
				minHeap.dllNode[largest] =  minHeap.dllNode[index];
				
				// Fix the heap downward
				minheapify(minHeap, largest);
			}
		}
		
		// Function to insert into a min heap
		public void insertMinHeap(MinHeap minheap, DoublyListNode dllNode) {
			if(isMinHeapFull(minheap))
				return;
			++minheap.size;
			int i = minheap.size-1;
			while((i>0) && dllNode.data < minheap.dllNode[(i-1)/2].data) {
				minheap.dllNode[i] = minheap.dllNode[(i-1)/2];
				minHeap.dllNode[i].minHeapIndex = i;
				i = (i-1)/2;
			}
			minheap.dllNode[i] = dllNode;
			minheap.dllNode[i].minHeapIndex = i;
		}
		
		// Function to insert into a max heap
		public void insertMaxHeap(MaxHeap maxheap, DoublyListNode dllNode) {
			if(isMaxHeapEmpty(maxheap)) return;
			++maxheap.size;
			int i = maxheap.size -1;
			while((i > 0) && dllNode.data > maxheap.dllNode[(i-1)/1].data) {
				maxheap.dllNode[i] = maxheap.dllNode[(i-1)/2];
				maxheap.dllNode[i].maxHeapIndex = i;
				i = (i-1)/2;
			}
			maxheap.dllNode[i] = dllNode;
			maxheap.dllNode[i].maxHeapIndex = i;
		}
		
		// Find minimum values from the data structure
		public int findMinimum(MyDataStructure MyDS) {
			if(isMinHeapEmpty(MyDS.minHeap)) 
				return Integer.MAX_VALUE;
			return MyDS.minHeap.dllNode[0].data;
		}
		
		// Find the maximum value from the data structure
		public int findMaximum(MyDataStructure MyDS) {
			if(isMaxHeapEmpty(MyDS.maxHeap))
				return Integer.MIN_VALUE;
			return MyDS.maxHeap.dllNode[0].data;
		}
		
		// Utility function to remove an item from the linked list
		public void removeNode(List list, DoublyListNode dllNode) {
			// point the head to null if there is only one single node
			if(listHasOnlyOneNode(list)) list.head = null;
			
			else if (dllNode.prev != null) {
				list.head = dllNode.next;
				dllNode.next.prev = null;
			}
			// any other node including the last one
			else {
				dllNode.prev.next = dllNode.next;
				// last node
				if(dllNode.next != null)
					dllNode.next.prev = dllNode.prev;
			}
			dllNode = null;
		}
		
		
		
}
