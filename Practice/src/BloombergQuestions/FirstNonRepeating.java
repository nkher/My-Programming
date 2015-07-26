package BloombergQuestions;

// To get the first non repeating character in a string
// Improved version of the original method, where we create a data structure to store the counts as well as first index of the element
// For finding the non repeating the character we will traverse through the data structure we made instead of the whole string
// So in this ways we are avoiding a O(N) for the second iteration
public class FirstNonRepeating {

	public final int NO_OF_CHARS = 256;
	public int firstNonRepeating(String test) {
		if (test ==  null) return 0;
		if (test.length() < 2) return 0;
		CountIndex count[] = new CountIndex[NO_OF_CHARS];
		count = getCountCharArray(test); // Getting the count array to get all the index and the counts
		// Printing the array for convenience
//		for (int i=0; i<count.length; i++) {
//			System.out.println("count is : " + count[i].count + " Index is : " + count[i].index);
//		}
		
		int result = Integer.MAX_VALUE, i;
		// If this character occurs only once and appears
	    // before the current result, then update the result
		for (i=0; i<NO_OF_CHARS; i++) {
			if (count[i] != null) {
				if (count[i].count == 1 && result > count[i].index)
				result = count[i].index;
			}
		}
		return result;
	}
	
	// Returns an array of the type CountIndex
	public CountIndex[] getCountCharArray(String testString) {
		CountIndex count[] =  new CountIndex[NO_OF_CHARS];
		int i;
		for (i=0; i<testString.length(); i++) {
			if (count[testString.charAt(i)] == null) {
				count[testString.charAt(i)] = new CountIndex(); 
			}
			else {
				count[testString.charAt(i)].count++; // Incrementing the count at the position
				if (count[testString.charAt(i)].count == 1) // If it is the first occurrence only then store the 
					count[testString.charAt(i)].index = i;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		FirstNonRepeating obj = new FirstNonRepeating();
		String testString = "GeeksfforGeeks";
		testString = testString.toLowerCase();
		int index = obj.firstNonRepeating(testString);
		if (index == Integer.MAX_VALUE)
			System.out.println("Either all characters are repeating or string is empty");
		else 
			System.out.println("First non-repeating character is " + testString.charAt(index));
	}

}

class CountIndex {
	public int count;
	public int index;
	
	public CountIndex() {}
	
	public CountIndex(int count, int index) {
		this.count = count;
		this.index = index;
	}
}
