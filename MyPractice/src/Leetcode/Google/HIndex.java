package Leetcode.Google;

import java.util.Arrays;

public class HIndex {

	// Method 1 - O(n)
	
	public static int hInd(int citations[]) {
		int n = citations.length;
		int []equalH = new int[n+1];
		
		for (int h=0; h<n; h++) {
			if (citations[h] >= n) equalH[n] += 1;
			else equalH[citations[h]] += 1;
		}
		
		Arrays.toString(equalH);
		int s = 0;
		for (int h=n; h>=0; h--) {
			s += equalH[h];
			if (s >= h) return h;
		}
		return 0;
	}
	
	// Method 2 Sorting
	public static int hIndex(int a[]) {
		
		int h = 0;
		int n = a.length;
		
		if (n == 0) return 0;
		if (n == 1) {
		    if (a[0] >= 1)
		        return 1;
		    else
		        return 0;
		}
		
		
		// Sort the array in descending order
		Arrays.sort(a);
		reverseArray(a);
		
		if (n == 2) {
			if (a[1] == 1) return 1;
		}
		
		for (int i=0; i<n; i++) {
			if (i+1 == a[i]) { // if the index equals the number of citations
				h = Math.max(h, a[i]);
				if (checkFurtherPartOfArray(a, i+1, n-1, h)) {
					break;
				}
			}
		}
		
		return h;
	}
	
	public static boolean checkFurtherPartOfArray(int a[], int start, int end, int h) {
		
		for (int i=start; i<=end; i++) {
			if (a[i] > h) {
				return false;
			}
		}
		return true;
	}
	
	public static void reverseArray(int a[]) {
		
		int i=0, j = a.length-1;
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args) {
		
		int a[] = {3, 0, 6, 1, 5};
		System.out.println(hInd(a));
		
		int b[] = {1, 2};
		System.out.println(hInd(b));
		
		int c[] = {40, 20, 10, 5, 4};
		System.out.println(hInd(c));
	}

}
