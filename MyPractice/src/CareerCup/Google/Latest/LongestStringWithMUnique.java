package CareerCup.Google.Latest;

import java.util.HashSet;

public class LongestStringWithMUnique {
	
	public static int longestSubstringWithMUnique(String s, int m) {
		
		HashSet<Character> set = new HashSet<Character>();
		int right  = 0, left = 0, longestUniqueSubstrLen = Integer.MIN_VALUE;
		int nextUniqueIndex = -1;
		char sArray[] = s.toCharArray();
		
		while (right < sArray.length) {
			
			while (right < sArray.length && set.size() < m) {
				if (!set.isEmpty() && sArray[right] != sArray[right -1]) {
					nextUniqueIndex = right-1;
				}
				set.add(sArray[right++]);				
			}
			
			System.out.println(right);
			if (right == sArray.length) break;
			
			
			// calculate the length
			if (set.size() == m) {
				longestUniqueSubstrLen = Math.max(longestUniqueSubstrLen, (right - left + 1));
			}
			
//			// set the right intelligently to the last first unique we had got
			right = nextUniqueIndex;
			left = nextUniqueIndex;
			set.clear();			
		}
		
		return longestUniqueSubstrLen;
	}
	
	public static void main(String[] args) {
		
		String s = "aabacbeabbed";
		int m = 2;
		
		System.out.println(longestSubstringWithMUnique(s, m));
	}

}

