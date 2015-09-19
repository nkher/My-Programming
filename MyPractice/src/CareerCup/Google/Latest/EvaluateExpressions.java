package CareerCup.Google.Latest;

import java.util.Stack;

// Not done
public class EvaluateExpressions {

	/** 
	 * design and implement a calculater that can calculate expressions like: 
		+ 2 4 
		* 8 ( + 7 12) 
		( + 7 ( * 8 12 ) ( * 2 (+ 9 4) 7 ) 3 ) 
		
		(PS:all items are space delimetered.) 
		
		Example answers 
		+ 2 4 => 2 + 4 = 6 
		* 8 ( + 7 12) => 8 * ( 7 + 12 ) = 152 
		( + 7 ( * 8 12 ) ( * 2 (+ 9 4) 7 ) 3 ) => 7+8*12+2*(9+4)*7+3 = 148
	 */
	
	public static int evaluate(String expression) {
		
		Stack<Character> operators = new Stack<Character>();
		Stack<Integer> operands = new Stack<Integer>();
		char[] expressionArray = expression.toCharArray(); 
		char last = ' ';
		
		for (int i=0; i<expressionArray.length; i++) {
			
			char ch = expressionArray[i];
			if (ch == '(' || ch == ' ') {
				continue;
			}
			else if (ch == '+' || ch == '*' || ch == '+' || ch == '/') {
				operators.push(ch);
			}
			else if (isDigit(ch) || ch == ' ') {
				int n = 0;
				while (i < expressionArray.length && isDigit(expressionArray[i])) {
					n += (n * 10) + getNumberFromDigit(ch);
					i++;
				}
				operands.push(n);
				//System.out.println("n is " + n);
				if (isDigit(last) || ch == ')') { // means do the operation
					int second = operands.pop();
					int first = operands.pop();
					char opr = operators.peek();
					operands.push(applyOperation(opr, first, second));
				}
			}
			last = ch;
		}
		
		System.out.println(operands.toString() + "\n" + operators.toString());
		
		while (!operands.isEmpty()) {
			int second = operands.pop();
			int first = operands.pop();
			char opr = operators.peek();
			operands.push(applyOperation(opr, first, second));
		}
		
		if (operands.isEmpty()) return -1;
		
		return operands.pop();
	}
	
	public static boolean isDigit(char ch) {
		return (ch >= '0' && ch <= '9');
	}
	
	public static int getNumberFromDigit(char ch) {
		return (int)(ch - '0');
	}
	
	public static int applyOperation(char operand, int x, int y) {
		
		int result = -1;
		switch (operand) {
		case '+':
			result = x + y;
			break;
		case '-':
			result = x - y;
			break;
		case '*':
			result = x * y;
			break;
		case '/':
			result = x/y;
			break;
		default:
			break;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String s1 = "+ 2 4"; // == 6
		String s2 = "* 8 ( + 7 12 )"; // == 152
		String s3 = "( + 7 ( * 8 12 ) ( * 2 (+ 9 4) 7 ) 3 )"; // == 288
		
		System.out.println(evaluate(s1));
		System.out.println(evaluate(s2));
		//System.out.println(evaluate(s3));
	}

}
