package CareerCup.Google;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class NormalizePathnames {
	
	// run time : O(n+m) 'n' = number of chars and and 'm' is the number of tokens produced by the split
	// O(n)
	public static String simplifyPath(String path) {
		
		// Deque has a handle over the first as well as the last item
		Deque<String> stack = new LinkedList<String>();
		Set<String> skip = new HashSet<String>(Arrays.asList("..", ".", ","));
		
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !stack.isEmpty()) {
				stack.pop();
			}
			else if (!skip.contains(dir)) {
				stack.push(dir);
			}			
		}
		String res = "";
		while (stack.size() > 0) {
			String dir = stack.remove();
			res = "/" + dir + res;
			
		}
		return res.isEmpty() ? "/" : res;
	}
	
	public static void main(String []args) {
		
		System.out.println(simplifyPath("a/b/../foo.txt"));
		
		System.out.println(simplifyPath("//./../scripts/awkscripts/././"));
	}
}
