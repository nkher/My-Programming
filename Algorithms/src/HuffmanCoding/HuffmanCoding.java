package HuffmanCoding;

public class HuffmanCoding {
	
	// Function to create a new Min Heap Node and set its data
	public MinHeapNode newNode(char data, int freq){
		MinHeapNode temp =  new MinHeapNode();
		temp.data = data;
		temp.frequency = freq;
		temp.left = null; temp.right = null;
		return temp;
	}
	
	// Function to create a min heap collection of a given capacity
	public MinHeap createMinHeap(int capacity){
		
		MinHeap minHeap = new MinHeap();
		minHeap.size = 0;
		minHeap.capacity = capacity;
		minHeap.minHeapNodes = new MinHeapNode[capacity];
		
		return minHeap;
	}
	
	// Standard min heapify funcion
	public void minHeapify(MinHeap minHeap, int idx){
		
		int smallest = idx;
		int left = 2*idx+1;
		int right = 2*idx+2;
		
		if(left < minHeap.size && minHeap.minHeapNodes[left].frequency < minHeap.minHeapNodes[smallest].frequency)
			smallest = left;
		
		if(right < minHeap.size && minHeap.minHeapNodes[right].frequency < minHeap.minHeapNodes[smallest].frequency)
			smallest = right;
		
		if(smallest != idx){
			// Swap the smallest and the idx
			MinHeapNode temp = minHeap.minHeapNodes[smallest];
			minHeap.minHeapNodes[smallest] = minHeap.minHeapNodes[idx];
			minHeap.minHeapNodes[idx] = temp;
			
			//Again min Heapify
			minHeapify(minHeap, smallest);
		}
	}
	
	// Function to check if the size of the min heap is 1 or not
	public boolean isSizeOne(MinHeap minHeap){
		return (minHeap.size==1);
	}
	
	// Function to extract minimum value from the min heap
	public MinHeapNode extractMin(MinHeap minHeap){
		
		MinHeapNode temp = minHeap.minHeapNodes[0];
		minHeap.minHeapNodes[0] = minHeap.minHeapNodes[minHeap.size-1];
		--minHeap.size;
		minHeapify(minHeap, 0);
		return temp;
	}
	
	public void insertMinHeap(MinHeap minHeap, MinHeapNode minHeapNode){
		
		++minHeap.size;
		int n = minHeap.size-1;
		while(n > 0 && minHeapNode.frequency < minHeap.minHeapNodes[(n-1)/2].frequency){
			minHeap.minHeapNodes[n] = minHeap.minHeapNodes[(n-1)/2];
			n = (n-1)/2;
		}
		minHeap.minHeapNodes[n] = minHeapNode;
	}
	
	// Function to build a min Heap
	public void buildMinHeap(MinHeap minHeap){
		int n = minHeap.size-1;
		int i;
		for(i=(n-1)/2; i>=0;i--)
			minHeapify(minHeap, i);
	}
	
	
	// A utility function to print an array of size n
	public void printArr(int arr[], int n)
	{
	    int i;
	    for (i = 0; i < n; ++i)
	        System.out.print(arr[i]);
	    System.out.println("\n");
	}
	
	// Function to check if the node is a leaf
	public boolean isLeaf(MinHeapNode minHeapNode){	
		return (minHeapNode.left==null && minHeapNode.right==null);
	}
	
	
	// Function to create a min heap of capacity equal to size and 
	// insert all characted of data in min heap
	public MinHeap createAndBuildMinHeap(char data[], int freq[], int size){
		
		MinHeap minHeap = createMinHeap(size);
		for(int i=0;i<size;i++)
			minHeap.minHeapNodes[i] = newNode(data[i], freq[i]);
		minHeap.size = size;
		buildMinHeap(minHeap);
		return minHeap;
	}
	
	// Function to build the huffman tree
	public MinHeapNode buildHuffmanTree(char data[], int freq[], int size){
		
		MinHeapNode left, right, top;
		
		// Step 1: Create a min heap of capacity equal to size.  Initially, there are
	    // modes equal to size.
		MinHeap minHeap = createAndBuildMinHeap(data, freq, size);
		
		// Iterate until size of heap does not become 1
		while(!isSizeOne(minHeap)){
			
			// Step 2: Extract the two minimum freq items from min heap
			left = extractMin(minHeap);
			right = extractMin(minHeap);
			
			// Step 3:  Create a new internal node with frequency equal to the
	        // sum of the two nodes frequencies. Make the two extracted node as
	        // left and right children of this new node. Add this node to the min heap
	        // '$' is a special value for internal nodes, not used
			top = newNode('$', left.frequency + right.frequency);
			top.left = left;
			top.right = right;
			insertMinHeap(minHeap, top);
		}
		return extractMin(minHeap);
	}
	
	// Prints huffman codes and stores from the root 	of the huffman tree
	// Stores it in an array
	public void printCodes(MinHeapNode root, int arr[], int top){
		
		// Assign 0 to left edge and recur
		if(root.left != null){
			arr[top] = 0;
			printCodes(root.left, arr, top+1);
		}
		
		// Assign 1 to left edge and recur
		if(root.right != null){
			arr[top] = 1;
			printCodes(root.right, arr, top+1);
		}
		
		// If this is a leaf node, then it contains one of the input
	    // characters, print the character and its code from arr[]
		if(isLeaf(root)){
			System.out.println(root.data);
			printArr(arr, top);
		}
	}
		
		// The main function that builds a Huffman Tree and print codes by traversing
		// the built Huffman Tree
		public void huffmanCodes(char data[], int freq[], int size){
			
			// Construct huffman tree
			MinHeapNode root = buildHuffmanTree(data, freq, size);
			
			// Print Huffman codes using the Huffman tree built above
			int top=0;
			int[] arr = new int[10];
			printCodes(root, arr, top);
		}
		
		public static void main(String args[]){
			
			HuffmanCoding object = new HuffmanCoding();
			char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		    int freq[] = {5, 9, 12, 13, 16, 45};
		    int size = arr.length;
		    object.huffmanCodes(arr, freq, size);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
