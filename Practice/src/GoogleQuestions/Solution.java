package GoogleQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	 public int solution(int[] A) throws NumberFormatException, IOException {
		 BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		 int Y= Integer.parseInt(inp.readLine());
		 
		 //System.out.println("Please enter the value for Y : ");
		 //Scanner input = new Scanner(System.in);
		 //int Y = input.nextInt();
		 int current;
		 int i, returnValue = Integer.MAX_VALUE;
		 for (i=0; i<A.length; i++) {
			 current = Math.abs(A[i]-Y) ;
			 if (current < returnValue) {
				 returnValue = current;
			 }
		 }
		 return returnValue;
	 }
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		Solution sol = new Solution();
		int A[] = {10, 0, 8, 2, -1, 12, 11, 3};
		System.out.println(sol.solution(A));
	}
}
