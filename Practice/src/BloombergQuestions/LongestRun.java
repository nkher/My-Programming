package BloombergQuestions;

import java.util.Scanner;

public class LongestRun {

	// Write a program to accept a non empty string of alpha numberic 
	// chars. Return the longest run
	
	// 1. With a hashmap with extra space
	
	// 2. Without hash map in O(N)
	public static int longestRun(String s1) {
		char[] arr = s1.toCharArray();
		int count = 1, maxCount = Integer.MIN_VALUE;
		char cur, prev = arr[0];
		for (int i=1;i<arr.length;i++) { // abbbbccc
			cur = arr[i];
			if (cur != prev || i == arr.length-1) {
				maxCount = Math.max(maxCount, count); // 1, 
				count = 0; 
			}
			prev = cur;
			count++;
		}
		return maxCount;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a string");
		String inputString = input.nextLine();
		int ans = LongestRun.longestRun(inputString);
		System.out.println(ans);
	}

}
