package CareerCup.Google.Latest;

import java.util.ArrayList;
import java.util.Stack;

public class PrintAllSubsetsEqualToSum {
	
	public static Integer current = new Integer(1);
	
	public static ArrayList<ArrayList<Integer>> printAllSubsets(int sum) {
		int partialSum = 0;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		return printAllSubsetsHelper(partialSum, stack, sum, result);
	}
	
	public static ArrayList<ArrayList<Integer>> printAllSubsetsHelper(int partialSum, Stack<Integer> stack, int sum, ArrayList<ArrayList<Integer>> result) {
		
		if (current == sum) {
			return result;
		}
		
		if (partialSum == sum) {	
			/* Increment the current, add the list and return */
			result.add(new ArrayList<Integer>(stack));
			System.out.println("Partial result : " + stack.toString());
			stack.pop();
			return result;
		}
		
		while (partialSum < sum) {
			// add the current value in the stack and recurse
			while (partialSum+current <= sum) {
				stack.add(current); 
				printAllSubsetsHelper((partialSum+current), stack, sum, result);
			}
			
			// remove the top
			stack.pop();
			current = current + 1;
		}	
		return result;
	}
	
	// T.C = O(2 ^ (n-1)) ways to sum up till N
	public static void allSubsets(int n, String s) {
		if (n == 0) {
			System.out.println(s);
		}
		else if (n > 0) {
			for (int i=1; i<=n; i++) {
				allSubsets(n - i, s + " " + Integer.toString(i));
			}
		}
	}
	
	public static void main(String[] args) {
		
		//ArrayList<ArrayList<Integer>> result = printAllSubsets(4);
		
		allSubsets(4, "");
	}

}
