package com.CTCI5.Chapter9;

import java.util.ArrayList;

public class Question4 {

	// Using recursion
	// P(3) - P(2) = clone of P(2) + add the new element to all of P(2)
	// Complexity is O(2 ^ n)
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) { // base case - add an empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // empty set
		}
		else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				// What we are essentially doing here is to add the 'item' and add it to
				// all the subsets of 'allsubsets'
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	// Method 2 - Combinatorics
	// Time complexity - O(2 ^ n)
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max_subsets = 1 << set.size();
		for (int i=0;i<max_subsets;i++) {
			ArrayList<Integer> subset =  convertIntToSet(i, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int m = x; m > 0; m = m >> 1) {
			if ( (m&1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
	
	public static void main(String[] args) {
				
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0;i<4;i++) {
			list.add(i);
		}
		
		ArrayList<ArrayList<Integer>> subsets =  getSubsets(list, 0);
		//System.out.println(subsets.toString());
		
		subsets =  getSubsets2(list);
		System.out.println(subsets.toString());
	}
}
