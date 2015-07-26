package AmazonQuestions;

public class AnagramSubstringSearch {

	public static final int MAX = 256;
	
	public static void searchAnagrams(char[] text, char[] pat) {
		int txtL = text.length;
		int patL = pat.length;
		
		// countP[]:  Store count of all characters of pattern
	    // countT[]: Store count of current window of text
		char countP[] = new char[MAX];
		char countT[] = new char[MAX];
		
		// Calculating for the first window from the text
		for (int i=0;i<patL;i++) {
			countP[pat[i]]++;
			countT[text[i]]++;
		}

		// Traverse through remaining characters of pattern
		for(int i=patL;i<txtL;i++) {			
			// Compare the windows
			if (compare(countP, countT))
				System.out.println("Anagram for the given pattern found at index " + (i - patL));
			
			// Add the next character to the text[] window which is countT
			countT[text[i]]++;
			
			// Remove the first character from the window
			countT[text[i - patL]]--;
		}
		// Checking for the last window which might not be checked in the above iteration
		if (compare(countP, countT))
			System.out.println("Anagram for the given pattern found at index " + (txtL-patL));
	}
	
	public static boolean compare(char[] arr1, char[] arr2) {
		for (int i=0;i<MAX;i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		char text[] = {'B', 'A', 'C', 'D', 'G', 'A', 'B', 'C', 'D', 'A'};
		char pat[] = {'A', 'B', 'C', 'D'};
		
		AnagramSubstringSearch.searchAnagrams(text, pat);
	}
}
