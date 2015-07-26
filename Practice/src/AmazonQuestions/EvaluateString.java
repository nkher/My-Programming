package AmazonQuestions;

import java.util.Stack;

public class EvaluateString {
	
	public static int applyOperation(char op, int a, int b) {
		switch(op) {
			case '+':
				return (int)a+b;
			case '/':
				if (b == 0)
	                throw new
	                UnsupportedOperationException("Cannot divide by zero");
	            return (int)(a / b);
			case '*':
				return (int)a*b;
			case '-':
				return (int)a-b;
		}
		return 0;
	}
	
	// Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')') {
			return false;
		}
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
			return false;
		}
		return true;
	}
	
	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();
		
		for (int i=0;i<tokens.length;i++) {
			System.out.println(i + " : " + tokens[i]);
		}
		
		// Stack for numbers
		Stack<Integer> values = new Stack<Integer>();
		// Stack for ops
		Stack<Character> ops = new Stack<Character>();
				
		for (int i=0;i<tokens.length;i++) {
			// First check for empty space
			if (tokens[i] == ' ') {
				continue;
			}
			
			// Second check for digits
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sBuffer = new StringBuffer();
				// making a check if the number has more than a single digit
				while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sBuffer.append(tokens[i++]);
				// pushing the final integer into the stack
				values.push(Integer.parseInt(sBuffer.toString()));
			}
			
			// Third check for left paran
			else if (tokens[i] == '(') {
				ops.push(tokens[i]);
			}
			
			// Fourth check for right paran
			else if (tokens[i] == ')') {
				// Calculate till the left paran in ops
				while(ops.peek() != '(')
					values.push(applyOperation(ops.pop(), values.pop(), values.pop()));
				// pop the left paran 
				ops.pop();
			}
			
			// Fifth check if the token is an operator
			else if (tokens[i] == '+' || tokens[i] == '/' || tokens[i] == '*' || tokens[i] == '-') {
				// Before inserting into the ops stack first check if it is not empty (ops stack)
				// check the precedence compared to the top operator of the stack and make the operation 
				// then push
				while(!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOperation(ops.pop(), values.pop(), values.pop()));
				
				// push the current token onto the ops stack
				ops.push(tokens[i]);
			}
		}	
		
		// Now once again check till the ops stack is empty and apply operation
		while(!ops.empty())
			values.push(applyOperation(ops.pop(), values.pop(), values.pop()));
		
		// To finally return the result do a values.pop()
		return values.pop();
	}
	
	public static void main(String[] args) {
		
		//String expression1 = "128 + (32*4) / (10*11) - 30";
		//System.out.println(EvaluateString.evaluate(expression1));
		System.out.println(EvaluateString.evaluate("10 + 2 * 6"));
		System.out.println(EvaluateString.evaluate("100 * 2 + 12"));
//        System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 )"));
        //  System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
	}

}
