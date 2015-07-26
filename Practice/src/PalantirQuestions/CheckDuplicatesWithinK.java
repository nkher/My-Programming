package PalantirQuestions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CheckDuplicatesWithinK {

	// Given an unsorted list of integers, return true if the 
	// list contains any duplicates within k indices of each element
	
	public static boolean checkduplicateswithinK(int a[], int k) {
		Set<Integer> set = new HashSet<Integer>();
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		int first = 0;
		for(int j=0;j<k;j++) {
			set.add(a[j]);
			linkedlist.add(a[j]);
		}
		for (int i=k;i<a.length;i++) {
			if (!set.isEmpty() && set.contains(a[i]))
				return false;
			first = linkedlist.removeFirst();
			set.remove(first);
			set.add(a[i]);
			linkedlist.add(a[i]);
		}	
		return true;
	}
	
	public static boolean checkDupsWithinK(int a[], int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i=0;i<a.length;i++) {
			
			if (!set.isEmpty() && set.contains(a[i])) return true; // contains duplicates
			
			set.add(a[i]);
			
			// remove i - kth item
			if (i >= k)
				set.remove(a[i-k]);
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int a[] = {5, 3, 8, 2, 5, 111, 3, 2, 1, 8, 10, 2 };
		if(CheckDuplicatesWithinK.checkduplicateswithinK(a, 3)) 
			System.out.println("No duplicates are found within the given k value !");
		else
			System.out.println("Duplicates exist within the given k value");
		
		if (checkDupsWithinK(a, 3))
			System.out.println("Contains dups");
		else
			System.out.println("Does not contain");
		
		TreeSet<Integer> set = new TreeSet<Integer>();
	}

}
