package com.CTCI.Chapter9;

import org.CTCILibrary.AssortedMethods;

public class Question9_1 {
	
	public static void merge(int a[], int b[], int lastIndexA, int lastIndexB) {
		int lastIndexMerged = lastIndexA+lastIndexB-1;
		int iA = lastIndexA-1;
		int iB = lastIndexB-1;
		
		while(iA >= 0 && iB >= 0) {
			if(a[iA] >= a[iB]) {
				a[lastIndexMerged] = a[iA];
				iA--;
			}
			else {
				a[lastIndexMerged] = a[iB];
				iB--;
			}
			lastIndexMerged--;
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
		int[] b = {1, 4, 5, 6, 7, 7};
		merge(a, b, 8, 6);
		System.out.println(AssortedMethods.arrayToString(a));
	}

}
