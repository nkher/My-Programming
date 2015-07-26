package PalantirQuestions;

import java.util.ArrayList;

public class RollingMedian2 {

	int count = 0;
	MinimumHeap minheap = new MinimumHeap();
	MaximumHeap maxheap = new MaximumHeap();
	
	public void insert(int incoming_number) {
		if ((count&1) == 0) {// check if the count is even
			// add to the min heap
			// before adding check if the new number is less than some numbers on the max-heap
			if (maxheap.size() > 0 && incoming_number < maxheap.peek()) {
				maxheap.add(incoming_number);
				int greatest = maxheap.pop(); // get the greatest number
				minheap.add(greatest);
			}
			else
				minheap.add(incoming_number);
		}		
		else {
			// add to the max heap
			// before adding check if the new number is greater than some numbers in the minimum-heap
			if (minheap.size() > 0 && incoming_number > minheap.peek()) {
				minheap.add(incoming_number);
				int smallest = minheap.pop();
				maxheap.add(smallest);
			}
			else
				maxheap.add(incoming_number);
		}
		count++;
	}
	
	public int getMedian() throws Exception {
		if (count == 0) {
			throw new Exception("The heaps are empty !");
		}
		if ((count&1) == 1) // if elements are odd
			return minheap.peek();
		else 
			return (minheap.peek() + maxheap.peek())/2;
	}
	
	public static void main(String[] args) throws Exception {
		RollingMedian2 rm = new RollingMedian2();
		int[] a = {5, 15, 1, 3};
		// int[] array = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		for (int i=0;i<a.length;i++) {
			rm.insert(a[i]);
			System.out.println("Median is : " + rm.getMedian());
			// System.out.println("Min size : " + rm.minheap.size() + " Max Size : " + rm.maxheap.size());
			System.out.println(rm.maxheap.peek() + " " + rm.minheap.peek());
		}		
	}
}

class Heap {
	protected ArrayList<Integer> array = new ArrayList<Integer>();
	int size;		
	
	public int left(int i) {
		return (2*i)+1;
	}
	
	public int right(int i) {
		return (2*i)+2;
	}
	
	public int size() {
		return size;
	}
	
	public int peek() {
		if (array.size() > 0) 
			return array.get(0);
		else 
			return Integer.MAX_VALUE;
	}
	
}


class MinimumHeap extends Heap {
		
	public void add(int elem) {
		if (size == 0) { 
			array.add(0, elem);
			size++;
		}
		else {
			array.add(elem);
			size++;
			int index_to_heapify = size-2/2;
			minheapify(index_to_heapify);
		}
	}
	
	public void minheapify(int index) {
		int left = left(index);
		int right = right(index);
		int smallest = index;
		
		if (left < size && array.get(left) < array.get(smallest))
			smallest = left;
		if (right < size && array.get(right) < array.get(smallest))
			smallest = right;
		
		if (smallest != index) {
			// Swap the index and the smallest
			int temp = array.get(smallest);
			array.add(smallest, array.get(index));
			array.add(index, temp);
			minheapify(smallest);
		}
	}
	
	public int pop() {
		if (array.size() > 0) {
			int res =  array.remove(0);
			minheapify(size-1);
			return res;
		}
		else 
			return Integer.MAX_VALUE;
	}
}

class MaximumHeap extends Heap {
	
	public void add(int elem) {
		if (size == 0) { 
			array.add(0, elem);
			size++;
		}
		else {
			array.add(elem);
			size++;
			int index_to_heapify = size-2/2;
			maxheapify(index_to_heapify);
		}
	}
	
	public void maxheapify(int index) {
		int left = left(index);
		int right = right(index);
		int largest = index;
		
		if (left < size && array.get(left) > array.get(largest))
			largest = left;
		if (right < size && array.get(right) > array.get(largest))
			largest = right;
		
		if (largest != index) {
			// Swap the index and the smallest
			int temp = array.get(largest);
			array.add(largest, array.get(index));
			array.add(index, temp);
			maxheapify(largest);
		}
	}

	
	public int pop() {
		if (array.size() > 0) {
			int res =  array.remove(0);
			maxheapify(size-1);
			return res;
		}
		else 
			return Integer.MAX_VALUE;
	}
}