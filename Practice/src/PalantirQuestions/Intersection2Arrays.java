package PalantirQuestions;

import java.util.HashSet;
import java.util.Set;

public class Intersection2Arrays {
	
	// 1. Do it in O(N^2) 
	
	// 2. Sort both the arrays and compare using the merge paradigm
	
	// 3. Use a set
	
	public void printIntersection(int a[], int b[]) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i=0;i<a.length;i++) 
			set.add(a[i]);
		System.out.println("Intersection of a and b is : ");
		System.out.print("[");
		for (int i=0;i<b.length;i++) 
			if (set.contains(b[i])) System.out.print(" " + b[i]);
		System.out.print(" ]");
	}
	
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5};
		int b[] = {2, 3, 4, 6, 7};
		
		Intersection2Arrays object = new Intersection2Arrays();
		object.printIntersection(a, b);
	}

}
