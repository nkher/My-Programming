
public class BinaryTree {

	BinaryNode root;
	
	public void addNode(int key, String name){
		BinaryNode newNode = new BinaryNode(key,name);
		if(root==null)
			root=newNode;
		else{
			BinaryNode focusNode = root;
			BinaryNode parent;
			
			while(true){
				parent = focusNode;
				if(key<focusNode.key){
					focusNode=focusNode.leftChild;
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
					else{
						focusNode=focusNode.leftChild;
						if(focusNode == null){
							parent.rightChild = newNode;
							return;
						}
					}
				}
			}
		}
	}
	
	//In order
	public void inOrderTraversalTree(BinaryNode focusNode){
		if(focusNode != null){
			inOrderTraversalTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraversalTree(focusNode.rightChild);
		}
	}
	
	//Pre order
	public void preOrderTraversalTree(BinaryNode focusNode){
		if(focusNode != null){
			System.out.println(focusNode);
			preOrderTraversalTree(focusNode.leftChild);
			preOrderTraversalTree(focusNode.rightChild);
		}
	}
	
	//Post order
	public void postOrderTraversalTree(BinaryNode focusNode){
		if(focusNode != null){
			postOrderTraversalTree(focusNode.leftChild);
			postOrderTraversalTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
	public BinaryNode findNode(int key){
		BinaryNode focusNode = root;

		while(focusNode.key != key){
			if(key<focusNode.key){
				focusNode = focusNode.leftChild;
			}
			else{
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null)
				return null;
		}
		return focusNode;
	}
	
	public boolean remove(int key){
		BinaryNode focusNode = root;
		BinaryNode parent = root;
		
		boolean isLeftChild = true;
		while(focusNode.key != key){
			parent = focusNode;
			if(key < focusNode.key){
				isLeftChild = true;
				focusNode = focusNode.leftChild;
			}
			else{
				isLeftChild = false;
				focusNode = focusNode.rightChild;
			}
			if(focusNode==null){
				return false;
			}
		}
		
		if(focusNode.leftChild==null && focusNode.rightChild==null){
			if(focusNode==root){
				root = null;
			}
			else if(isLeftChild){
				parent.leftChild = null;
			}
			else{
				parent.rightChild = null;
			}
		}
		
		else if (focusNode.rightChild == null){
			if(focusNode==root){
				root = focusNode.leftChild;
			}
			else if(isLeftChild){
				parent.leftChild = focusNode.rightChild;
			}
			else{
				parent.rightChild = focusNode.leftChild;
			}
		}
		
		else if (focusNode.leftChild == null){
			if(focusNode==root){
				root = focusNode.rightChild;
			}
			else if(isLeftChild){
				parent.leftChild = focusNode.rightChild;
			}
			else{
				parent.rightChild = focusNode.leftChild ;
			}
		}
		
		else{
			BinaryNode replacement = getReplacementNode(focusNode);
			if(focusNode == root){
				root = replacement;
			}
			else if(isLeftChild)
				parent.leftChild = replacement;
			else 
				parent.rightChild = replacement;
			
			replacement.leftChild = focusNode.leftChild;
		}
		
		return true;
	}
	
	public BinaryNode getReplacementNode(BinaryNode replacedNode){
		BinaryNode replacementParent = replacedNode;
		BinaryNode replacement = replacedNode;
		
		BinaryNode focusNode = replacedNode.rightChild;
		while(focusNode!=null){
			replacementParent=replacement;
			replacement=focusNode;
			focusNode=focusNode.leftChild;
		}
		if(replacement != replacedNode.rightChild){
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.addNode(50, "Boss");
		bt.addNode(25, "Vice President");
		bt.addNode(15, "Office Manager");
		bt.addNode(30, "Secretary");
		bt.addNode(75, "Sales Manager");
		bt.addNode(85, "Salesman 1");
		
		bt.inOrderTraversalTree(bt.root);
	}

}

class BinaryNode{
	
	int key;
	String name;
	BinaryNode leftChild;
	BinaryNode rightChild;
	
	BinaryNode(int key, String name){
		this.key = key;
		this.name = name;
	}
	
	public String toString(){
		return name + "has a key" + key;
	}
}
