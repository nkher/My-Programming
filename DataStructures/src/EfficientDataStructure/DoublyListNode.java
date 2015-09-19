package EfficientDataStructure;

public class DoublyListNode {
	
	int data;
	int minHeapIndex;
	int maxHeapIndex;
	DoublyListNode next, prev;
	
	public DoublyListNode(int data) {
		this.data = data;
		this.minHeapIndex = this.maxHeapIndex  = -1;
		this.next = this.prev = null;
	}
	
	public void setNext(DoublyListNode n) {
		next = n;
		if(n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(DoublyListNode p) {
		prev = p;
		if(p != null && p.next != this) {
			p.setNext(this);
		}
	}
	
	public void setMinHeapIndex(int minHeapIndex) {
		this.minHeapIndex = minHeapIndex;
	}
	
	public void setMaxHeapIndex(int maxHeapIndex) {
		this.maxHeapIndex = maxHeapIndex;
	}
}
