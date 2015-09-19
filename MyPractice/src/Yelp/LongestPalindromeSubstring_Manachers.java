package Yelp;

public class LongestPalindromeSubstring_Manachers {
	
	/* Runs in less than O(log(N)) of time */
	public static String manachersAlgorithm(String s) {
		String hashedString = addHashes(s);
		int lenHashedString = hashedString.length();
		int P[] = new int[lenHashedString];
		int C = 0, R = 0;
		
		for (int i=1;i<lenHashedString-1;i++) {
			
			/* Get the index of the mirror image */
			// i' = C - ( i - C ) = C - i + C = 2C - i
			int iMirror = (2*C) - i;
			
			/* Assign the value to P[i] as explained in the video */
			P[i] = (R > i) ? Math.min(R - i, P[iMirror]) : 0;
			
			/* Try to expand the palindrome from the i'th character */
			try {
				while (hashedString.charAt(i + 1 + P[i]) == hashedString.charAt(i - 1 - P[i])) {
					P[i]++;
				}
			} catch (Exception e) {}
			
			/* If you have exceeded beyond the zonal limit of the right barrier then adjust the values of C and R to fit */
			if (i + P[i] > R) { // if you have exceeded the symmetric property of the string
				C = i;
				R = i + P[i];
			}
		}
		
		/* Find the maximum in P*/
		int lenLongestSubstring = 0;
		int indexLongestSubstring = 0;
		
		for (int i=1;i<lenHashedString-1;i++) {
			
			if (P[i] > lenLongestSubstring) {
				lenLongestSubstring = P[i];
				indexLongestSubstring = i;
			}
		}
			
		return removeHashes(hashedString.substring(indexLongestSubstring - lenLongestSubstring, indexLongestSubstring + lenLongestSubstring + 1));

	}
	
	public static String removeHashes(String s) {
		String x = "";
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i) != '#') {
				x += s.charAt(i);
			}
		}
		return x;
	}
	
	public static String addHashes(String s) {
		int len = s.length();
		
		if (len == 0) return "#";
		
		String hashedString = "";
		for (int i=0;i<len;i++) {
			hashedString += "#" + s.charAt(i);
		}
		
		hashedString += "#";
		
		return hashedString;
	}
	
	
	public static void main(String[] args) {
		System.out.println(manachersAlgorithm("abaaba"));
		System.out.println(manachersAlgorithm("babcbabcbaccba"));
	}
}
