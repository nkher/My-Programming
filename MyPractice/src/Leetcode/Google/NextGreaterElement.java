package Leetcode.Google;

import java.util.Arrays;
import java.util.Stack;

// Time complexity is O(N)
public class NextGreaterElement {

	public static int[] nextGreaterElem(int a[]) {
		int ret[] = new int[a.length];
		int writeIndex = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(a[0]); // add the first element
		int elem;
		
		for (int i=1;i<a.length;i++) {
			int next = a[i];
			
			if (!stack.isEmpty()) {
				
				elem = stack.pop();
				while (elem < next) { // means next is the next for top
					
					ret[writeIndex++] = next;  // set it as the next for the current element
					if (stack.isEmpty()) {
						break;
					}
					elem = stack.pop();
				}
				
				/* If element is greater than the next*/
				if (elem > next) { // This will be the element for the next iteration
					stack.push(elem);
				}
			}
			stack.push(next); // push for the next iteration
		}
		
		while (!stack.isEmpty()) {
			if (writeIndex > a.length-1) {
				break;
			}
			ret[writeIndex++] = -1;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		int a[] = {4,5,2,25};
		int ret[] = nextGreaterElem(a);
		System.out.println(Arrays.toString(ret));
	}
}
