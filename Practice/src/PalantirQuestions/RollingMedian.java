package PalantirQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class RollingMedian {
	
	// Time complexity is O(N log(N))
	
	int count = 0;
	PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
	
	public void insert(int incoming_number) {
		if ((count&1) == 0) {// check if the count is even
			// add to the min heap
			// before adding check if the new number is less than some numbers on the max heap
			if (maxheap.size() > 0 && incoming_number < maxheap.peek()) {
				maxheap.add(incoming_number);
				int greatest = maxheap.poll(); // get the greatest number
				minheap.add(greatest);
			}
			else
				minheap.add(incoming_number);
		}		
		else {
			// add to the max heap
			// before adding check if the new number is greater than some numbers in the min heap
			if (minheap.size() > 0 && incoming_number > minheap.peek()) {
				minheap.add(incoming_number);
				int smallest = minheap.poll();
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
	
	public void insertMin(int elem) {
		minheap.add(elem);
		count++;
	}
	
	public void insertMax(int elem) {
		maxheap.add(elem);
		count++;
	}
	
	
	public static void main(String args[]) throws Exception {
		RollingMedian rm = new RollingMedian();
		int[] array = {5, 15, 1, 3};
		// int[] array = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		for (int i=0;i<array.length;i++) {
			rm.insert(array[i]);
			System.out.println("Median is : " + rm.getMedian());
			// System.out.println("Min size : " + rm.minheap.size() + " Max Size : " + rm.maxheap.size());
			System.out.println(rm.maxheap.peek() + " " + rm.minheap.peek());
		}		
	}
}





