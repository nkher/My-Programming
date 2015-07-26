package PalantirQuestions;

import java.util.Stack;

public class ParenthesesMatching {

	public static boolean checkParen(String s1) {
		int i=0;
		char top_of_stack = 0;
		Stack<Character> stack = new Stack<Character>();
		while (i<s1.length()) {
			if (s1.charAt(i) == '(' || s1.charAt(i) == '{')
				stack.push(s1.charAt(i));
			else if (s1.charAt(i) == ')' || s1.charAt(i) == '}') {
				if (stack.isEmpty()) return false;
				top_of_stack = stack.pop();
				if (top_of_stack == '(' || top_of_stack == '{') {
					i++;
					continue;
				}
				else return false;
			}
			i++;
		}
		if (stack.isEmpty())
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
		// String s1 = "()()";
		// String s2 = "({()})";
		String s3 = "((()))()()({{{}}})";
		System.out.println(ParenthesesMatching.checkParen(s3));
	}

}
