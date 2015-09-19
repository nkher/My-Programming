package Google;

import java.util.ArrayList;

public class SmallestMultiSet {
	
	public static ArrayList<Integer> smallestMultiSet(int number) {
		
		int current = 1, sum = 0;
		ArrayList<Integer> multiSet = new ArrayList<Integer>();
		
		while (sum < number) {
			
			int square = (current * current);
			if (sum + square > number) { // not allowed so go back
				current -= 1;
				continue;
			} 
			else {
				sum += square;
				current += 1;
				multiSet.add(square);
			}			
		}
		return multiSet;
	}
	
	public static void main(String[] args) {
		
		System.out.println(smallestMultiSet(10).toString());
		
		System.out.println(smallestMultiSet(20).toString());
		
		System.out.println(smallestMultiSet(30).toString());
	}

}
