package Leetcode.Google;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	
	 public static ArrayList<ArrayList<Integer>> sum4(int nums[], int target) {
		 
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	     ArrayList<Integer> list;
	     
	     Arrays.sort(nums); // sort the array in O(NlogN)
	     System.out.println(Arrays.toString(nums));
	     int n = nums.length;
	     
	     for (int i=0; i<n-3 ; i++) {	    	 
	    	 int left1 = nums[i]; // actual values
	    	 
	    	 for (int k=i+1; k<n-2; k++) {
	    		 
		    	 int left2 = nums[k]; // actual values
		    	 
		    	 int partialSum = left1 + left2;
		    	 
		    	 if (k+1 >= n-1 || partialSum > target) break;
		    	 
		    	 list = new ArrayList<Integer>();
		    	 
		    	 int left3 = k+1, right = n-1; // indexes
		    	 while (left3 < right) {
		    		 
		    		 int totalSum = nums[left3] + nums[right] + partialSum;
		    		 if (totalSum == target) {
		    			 list.add(left1);
		    	    	 list.add(left2);
		    			 list.add(nums[left3]);
		    			 list.add(nums[right]);
		    			 result.add(list);
		    			 //System.out.println(list.toString());
		    			 list = new ArrayList<Integer>();
		    			 left3++;
		    			 right--;
		    		 }
		    		 else if (totalSum < target) {
		    			 left3++;
		    		 }
		    		 else {
		    			 right--;
		    		 }
		    	 }
	    	 }
	     }
	     
	     return result;
	 }
	
	public static void main(String[] args) {
		
		int nums[] = {1, 0, -1, 0, -2, 2};
		int target = 0 ;
		
		System.out.println(sum4(nums, target).toString());
		
		int nums2[] = {0, 0, 0, 0};
		System.out.println(sum4(nums2, target));
		
		int nums3[] = {-3,-2,-1,0,0,1,2,3};
		System.out.println(sum4(nums3, target));
	}

}
