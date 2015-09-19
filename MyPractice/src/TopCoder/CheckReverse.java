package TopCoder;

// Submitted for 161 points
public class CheckReverse {
	
	public static String toReturn = "Impossible";
	
	public static String canObtain(String initial, String target) {
		
		char initialChecker[] = new char[target.length()];
		int writeInd = 0;
		for (char c : initial.toCharArray()) {
			initialChecker[writeInd++] = c;
		}
		
		return canObtainHelper(initialChecker, target, writeInd);
	}
	
	public static String canObtainHelper(char[] initialChecker, String target, int index) {
		
		if (index == target.length()) {
			String temp = new String(initialChecker);			
			if (temp.equals(target)) {
				toReturn = "Possible";
			}
			return toReturn;
		}
		
		if (index < target.length()) {
			
			// add 'A' and recurse
			initialChecker[index] = 'A';
			canObtainHelper(initialChecker, target, index+1);
			
			// add 'B', reverse the array and check
			initialChecker[index] = 'B';
			//System.out.println("P : " + new String(initialChecker));
			reverseArray(initialChecker, 0, index);
			//System.out.println("N : " + new String(initialChecker));
			canObtainHelper(initialChecker, target, index+1);
		}
		
		return toReturn;
	}
	
	public static void reverseArray(char[] a, int s, int e) {
		while (s < e) {
			char temp = a[s];
			a[s] = a[e];
			a[e] = temp;
			s++;
			e--;
		}
	}
	
	public static void main(String[] args) {
		
		//System.out.println(canObtain("BAAAAABAA", "BAABAAAAAB")); /* Possible */
		
		//System.out.println(canObtain("A", "ABBA")); /* Impossible */
		
		//System.out.println(canObtain("AAABBAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB")); /* Possible */
		
		//System.out.println(canObtain("AAABAAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB")); /* Impossible */
		
		System.out.println(2 & 1);
	}

}
