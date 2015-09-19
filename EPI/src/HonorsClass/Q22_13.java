package HonorsClass;

import java.util.Stack;

public class Q22_13 {
	
	// Brute force - check valid paren algorithm on all substirngs TC = O(n * (n-1)) * (n) = (n^3)
	
	// Idea here is that we store left paren indices in the stack
	// For right paren we pop from the stack and then calculate the 
	// difference between the right parenthesis index which is the current index and the index of the left paren at the top of the stack
	// This would be the maximum length valid balanced substring with parens for that prefix/
	public static int longestSubStringWithMatchingParen(String s) {
		
		Stack<Integer> leftParenIndices = new Stack<Integer>();
		int maxLength = 0, end = -1;
		int n = s.length();
		
		for (int i=0; i<n; i++) {
			if (s.charAt(i) == '(') {
				leftParenIndices.push(i);
			}
			else if(leftParenIndices.isEmpty()) {
				end = i;
			}
			else {
				// first pop from the stack
				leftParenIndices.pop();
				int start = leftParenIndices.isEmpty() ? end : leftParenIndices.peek(); // only peek() here no pop()
				maxLength = Math.max(maxLength, (i - start));
			}
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		
		String s = "((())()(()(";
		System.out.println(longestSubStringWithMatchingParen(s));
	}

}
