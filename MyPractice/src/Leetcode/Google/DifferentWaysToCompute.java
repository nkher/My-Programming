package Leetcode.Google;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToCompute {
	
	//TC = O(Catalan time) and 
	public static List<Integer> differentWaysToCompute(String input) {
		
		List<Integer> result = new ArrayList<Integer>();
		if (input == null || input.length() == 0) {
			return result;
		}
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c != '+' && c != '-' && c != '*') {
				continue;
			}
			
			List<Integer> part1R = differentWaysToCompute(input.substring(0, i));
			List<Integer> part2R = differentWaysToCompute(input.substring(i+1, input.length()));
			
			for (Integer x : part1R) {
				for (Integer y : part2R) {
					if (c == '+') {
						result.add(x + y);
					}
					else if (c == '-') {
						result.add(x - y);
					}
					else if (c == '*') {
						result.add(x * y);
					}
				}
			}
		}
		
		if (result.size() == 0) {
			result.add(Integer.parseInt(input));
		}
		
		return result;
	}
	
	
	public static void main(String args[]) {
		
		System.out.println(differentWaysToCompute("2*3-4*5"));
	}
}
