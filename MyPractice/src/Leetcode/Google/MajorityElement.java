package Leetcode.Google;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
	
	public static List<Integer> majorityElement(int nums[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Integer n1 = null, n2 = null;
		int c1 = 0, c2 = 0;
		
		for (int i : nums) {
			if (n1 != null && i == n1.intValue()) {
				c1++;
			}
			else if (n2 != null && i == n2.intValue()) {
				c2++;
			}
			else if (c1 == 0) {
				c1 = 1;
				n1 = i;
			}
			else if (c2 == 0) {
				c2 = 1;
				n2 = i;
			}
			else {
				c1--;
				c2--;
			}
		}
		
		c1=c2=0;
		for (int i : nums) {
			if (n1 != null && i == n1.intValue()) {
				c1++;
			}
			if (n2 != null && i == n2.intValue()) {
				c2++;
			}
		}
		
		int n = nums.length;
		
		if (c1 > n/3) {
			list.add(n1);
		}
		if (c2 > n/3) {
			list.add(n2);
		}
		
		return list;
	}
	
	public static void main(String args[]) {
		
		int a[] = {0, 0};
		System.out.println(majorityElement(a).toString());
		
		int b[] = {1, 2, 3};
		System.out.println(majorityElement(b).toString());
		
		int c[] = {1, 2, 2, 3, 4, 4, 4};
		System.out.println(majorityElement(c).toString());
	}
}
