package PalantirQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThreeSumList {

	public static void three_sum_list(int a[]) {
		Arrays.sort(a);
		System.out.println("Array is : " + Arrays.toString(a));
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		// Takes O(N^2) time
		for (int i=0;i<a.length;i++) {
			for (int j=i+1;j<a.length;j++) {
				set.add(a[i] + a[j]);
			}
		}
		
		System.out.println("Sum of pairs in set : ");
		for (int m : set) 
			System.out.print(m + " ");
		
		System.out.println("\nAvailable triplets : ");
		for (int i=0;i<a.length;i++) {
			for (int j=i+1;j<a.length;j++) {
				if (set.contains(a[i] - a[j]))
					set2.add(a[i]);
			}
		}
		
		for (int m : set2) 
			System.out.print(m + " ");
	}
	
	public static void main(String[] args) {
		int a[] = {7, 3, 1, 4, 10, 6, 8, 11};
		ThreeSumList.three_sum_list(a);
	}
}
