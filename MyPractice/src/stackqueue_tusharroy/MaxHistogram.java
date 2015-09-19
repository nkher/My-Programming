package stackqueue_tusharroy;

import java.util.Stack;


/**
 * 
 * * Given an array representing height of bar in bar graph, find max histogram
 * area in the bar graph. Max histogram will be max rectangular area in the
 * graph.
 * 
 * Maintain a stack
 * 
 * If stack is empty or value at index of stack is less than or equal to value at current 
 * index, push this into stack.
 * Otherwise keep removing values from stack till value at index at top of stack is 
 * less than value at current index.
 * While removing value from stack calculate area
 * if stack is empty 
 * it means that till this point value just removed has to be smallest element
 * so area = input[top] * i
 * if stack is not empty then this value at index top is less than or equal to 
 * everything from stack top + 1 till i. So area will
 * area = input[top] * (i - stack.peek() - 1);
 * Finally maxArea is area if area is greater than maxArea.
 * 
 * 
 * Time complexity is O(n)
 * Space complexity is O(n)
 *
 */
public class MaxHistogram {
	
	public int maxHistogram(int[] input) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0, area, i;
		for (i=0;i<input.length;) {
			
			if (stack.isEmpty() || input[stack.peek()] <= input[i]) {
				stack.push(i++);
			}
			else {
				/* Remove the value at the top as the value of the top of the stack is greater */
				int top = stack.pop();
				if (stack.isEmpty()) {
					area = input[top] * i;
				}
				else {
					area = input[top] - (i - stack.peek() - 1);
				}
				maxArea = Math.max(area, maxArea);
			}
		}
		
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty()) {
				area = input[top] * i;
			}
			else {
				area = input[top] - (i - stack.peek() - 1);
			}
			maxArea = Math.max(area, maxArea);
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		
		MaxHistogram mh = new MaxHistogram();
		int input[] = {2,1,2,1};
		System.out.println("Max area is : " + mh.maxHistogram(input));
	}

}
