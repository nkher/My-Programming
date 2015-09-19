package avlTree;

public class AvlImplementation extends AvlNode{

	AvlNode root;
	
	public int max(int a, int b){
		return (a>b)?a:b;
	}
	
	public int height(AvlNode root){
		if(root == null)
			return 0;
		return root.height;
	}
	
	//Helper function to allocate a new Node with given key
	public AvlNode createNewNode(int key){
		AvlNode newNode = new AvlNode();
		newNode.height=1;//New Node is initially added at leaf
		newNode.key=key;
		newNode.leftChild=null;
		newNode.rightChild=null;
		return newNode;
	}
	
	//Function to right-rotate subtree 
	public AvlNode rightRotate(AvlNode y){
		AvlNode x = y.leftChild;
		AvlNode subTree = x.rightChild;
		
		//Rotation
		x.rightChild = y;
		y.leftChild = subTree;
		
		//Fixing heights
		y.height=max(height(y.leftChild), height(y.rightChild))+1;
		x.height=max(height(x.leftChild), height(x.rightChild))+1;
		
		//Return the new root
		return x;
	}
	
	public AvlNode leftRotate(AvlNode x){
		AvlNode y = x.rightChild;
		AvlNode subTree = y.leftChild;
		
		//Rotation
		y.leftChild = x;
		x.rightChild = subTree;
		
		//Fixing heights
		y.height=max(height(y.leftChild), height(y.rightChild))+1;
		x.height=max(height(x.leftChild), height(x.rightChild))+1;
		
		//Return the new root
		return y;
	}
	
	//Function to get the balance factor
	public int getBalance(AvlNode node){
		if(node == null)
			return 0;
		return height(node.leftChild)-height(node.rightChild);
	}
	
	//Inserting in an AVL Tree
	public AvlNode insertAVLTree(AvlNode root, int key){
		
		//Performing BST insertion
		if(root==null)
			return createNewNode(key);
		if(key<root.key)
			root.leftChild = insertAVLTree(root.leftChild, key);
		else
			root.rightChild = insertAVLTree(root.rightChild, key);
		
		//Update the ancestor height of this node
		root.height = max(height(root.leftChild),height(root.rightChild))+1;
		
		//Get the BF of this ancestor node to check whether this node became unbalanced
		int balance = getBalance(root);
		
		//Now checking all the possible cases
		//Left Left Case
		if(balance > 1 && key < root.leftChild.key)
			return rightRotate(root);
		
		//Left Right Case
		if(balance > 1 && key > root.leftChild.key){
			root.leftChild = leftRotate(root.leftChild);
			return rightRotate(root);
		}
		
		//Right right Case
		if(balance < -1 && key > root.rightChild.key)
			return leftRotate(root);
		
		//Right Left Case
		if(balance < -1 && key < root.rightChild.key){
			root.rightChild = rightRotate(root.rightChild);
			return leftRotate(root);
		}
		
		return root;
	}

	
	//Function to print the pre order traversal of the tree
	public void preOrder(AvlNode root){
		if(root!=null){
			System.out.println(root.key);
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}
	
	public static void main(String[] args) {
			
		AvlImplementation avlObject = new AvlImplementation();
		
		AvlNode root = null;
		//Constructing the given tree
		root = avlObject.insertAVLTree(root, 10);
		root = avlObject.insertAVLTree(root, 20);
		root = avlObject.insertAVLTree(root, 30);
		root = avlObject.insertAVLTree(root, 40);
		root = avlObject.insertAVLTree(root, 50);
		root = avlObject.insertAVLTree(root, 25);
		
		System.out.println("Pre Order Traversal is : ");
		System.out.println("Root is : " + root.key);
		avlObject.preOrder(root);
	}
}
