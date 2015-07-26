package AmazonQuestions;

public class LowArrayProblem {

	
	// Function to get the low array
	public int[] getLowArray(int arr[]){
		
		int[] low_array = new int[arr.length];
		
		// Now calling the insert binary function starting from the last element
		for(int i=arr.length-1;i>=0;i--){
			low_array[i] = insert(arr[i]);
		}
		return low_array;
	}
	
	
	BinaryDuplicateTree rootNode;
	
	// Size in a binary tree
	public int getSize(BinaryDuplicateTree rootNode){
		if(rootNode != null)
			return (getSize(rootNode.leftChild) + 1 + getSize(rootNode.rightChild));
		else
			return 0;
	}
	
	// Insert new node into a tree and also create the Low Array
	public int insert(int key){
		
		BinaryDuplicateTree root = new BinaryDuplicateTree();
		if(rootNode == null){
			root.key = key;
			rootNode = root;
			System.out.println("Key --> " + root.key + " Value --> " + root.value);
			return root.value;
		}
		
		else{
			
			BinaryDuplicateTree focusNode = rootNode;
			BinaryDuplicateTree parent;
			
			while(true){
				
				parent = focusNode;
				if(key <= focusNode.key){
					if(key == focusNode.key)
						root.value = root.value + 1;
					focusNode = focusNode.leftChild;
					if(focusNode == null){
						root.key = key;
						parent.leftChild = root;
						System.out.println("Key --> " + root.key + " Value --> " + root.value);
						return root.value;
					}
				}
				else{
					root.value += 1 + getSize(focusNode.leftChild); //Adding the size of the root and the left child
					focusNode = focusNode.rightChild;
					if(focusNode == null){
						root.key = key;
						parent.rightChild = root;
						System.out.println("Key --> " + root.key + " Value --> " + root.value);
						return root.value;
					}
				}
			}			
		}
	}

	public void inOrderTraversal(BinaryDuplicateTree root){
		if(root!=null){
			inOrderTraversal(root.leftChild);
			System.out.println("Key --> " + root.key + " Value --> " + root.value);
			inOrderTraversal(root.rightChild);
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,3,2,4,5,4,2}; 
		int[] arr2 = {4, 2, 3, 0, 1};
		LowArrayProblem root = new LowArrayProblem();
		
		// Calling the low array function
		int[] low_array = root.getLowArray(arr);
		System.out.println("Your list is :");
		System.out.print("[");
		for(int i=0;i<arr.length;i++){
			System.out.print(low_array[i] + " ");
		}
		System.out.print("]");
	}

}

class BinaryDuplicateTree{
	
	BinaryDuplicateTree leftChild;
	BinaryDuplicateTree rightChild;
	int value = 0;
	int key;
}
 