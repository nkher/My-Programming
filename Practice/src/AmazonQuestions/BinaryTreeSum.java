package AmazonQuestions;

public class BinaryTreeSum {

	BinaryTreeNode rootNode;
	
	public int size(BinaryTreeNode rootNode){
		if(rootNode != null){
			return (size(rootNode.leftChild) + 1 + size(rootNode.rightChild));
		}
		return 0;
	}
	
	// Function to change each node in a integer 
	// binary trees node value to the sum of its children node values
	/*public void sumOfEachNode(BinaryTreeNode rootNode){
		
		// Keeping counter of the size
		int size = size(rootNode);
		int count=0;
		BinaryTreeNode currentNode = rootNode;
		
		while(count <= size/2){
			
			if((currentNode != null) && (currentNode.leftChild != null && currentNode.rightChild != null)){
				System.out.println("Current Node : " + currentNode.nodeValue);
				if(currentNode.leftChild != null && currentNode.rightChild != null)
					currentNode.nodeValue = currentNode.leftChild.nodeValue + currentNode.rightChild.nodeValue;
				else if(currentNode.leftChild == null && currentNode.rightChild != null)
					currentNode.nodeValue = currentNode.rightChild.nodeValue;	
				else if(currentNode.rightChild == null && currentNode.leftChild != null)
					currentNode.nodeValue = currentNode.leftChild.nodeValue;
				
				//System.out.println("Count is : " + count + " Current Node : " + currentNode.nodeValue);
				count++;
			}
			
			if(currentNode.leftChild != null)
				currentNode = currentNode.leftChild;
			else if(currentNode.rightChild != null)
				currentNode = currentNode.rightChild;
		}
	}
	*/
	
	public void sumOfEachNode(BinaryTreeNode rootNode){
		BinaryTreeNode currentNode = rootNode;
		if(currentNode != null){	
			System.out.println("Current Node : " + currentNode.nodeValue);
			if(currentNode.leftChild != null && currentNode.rightChild != null)
				currentNode.nodeValue = currentNode.leftChild.nodeValue + currentNode.rightChild.nodeValue;
			else if(currentNode.leftChild == null && currentNode.rightChild != null)
				currentNode.nodeValue = currentNode.rightChild.nodeValue;	
			else if(currentNode.rightChild == null && currentNode.leftChild != null)
				currentNode.nodeValue = currentNode.leftChild.nodeValue;
		}
		else 
			return;	
		sumOfEachNode(rootNode.leftChild);
		sumOfEachNode(rootNode.rightChild);
	}
	
	
	public BinaryTreeNode createBinaryNode(int data){
		BinaryTreeNode newNode =  new BinaryTreeNode();
		newNode.nodeValue = data;
		newNode.leftChild = null;
		newNode.rightChild = null;
		return newNode;
	}
	
    public void insertBinaryTree(int data){
    	
    	// Creating a new Node
    	BinaryTreeNode newNode = createBinaryNode(data);
    	
    	if(rootNode == null)
    		rootNode = newNode;
    	
    	else{
    		
    		BinaryTreeNode focusNode = rootNode;
			BinaryTreeNode parent; 
			
    		while(true){
    			parent = focusNode;
    			// if it has to go to left
    			if(data < focusNode.nodeValue){
    				
    				focusNode = focusNode.leftChild;
    				if (focusNode == null){
    					
    					parent.leftChild=newNode;
    					return;
    				}
    			}
    			
    			// if it has to go to right
    			else{
    				focusNode = focusNode.rightChild;
    				if (focusNode == null){
    					
    					parent.rightChild=newNode;
    					return;
    				}
    			}
    			
    		}
    	}
    }
    
    public void preOrder(BinaryTreeNode rootNode){
    	if(rootNode!=null){
			System.out.println(rootNode.nodeValue);
			preOrder(rootNode.leftChild);
			preOrder(rootNode.rightChild);
		}
    }
	
	public static void main(String[] args) {
		
		BinaryTreeSum bts = new BinaryTreeSum();
		
		bts.insertBinaryTree(45);
		bts.insertBinaryTree(24);
		bts.insertBinaryTree(10);
		bts.insertBinaryTree(32);
		bts.insertBinaryTree(90);
		bts.insertBinaryTree(77);
		bts.insertBinaryTree(145);
		
		bts.preOrder(bts.rootNode);
		System.out.println("Size of tree : " + bts.size(bts.rootNode));
		
		bts.sumOfEachNode(bts.rootNode);
		bts.preOrder(bts.rootNode);
	}
}

class BinaryTreeNode{
	
	int nodeValue;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
}
