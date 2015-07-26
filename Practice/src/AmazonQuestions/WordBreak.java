package AmazonQuestions;

public class WordBreak {
	
	
	/* Common routine for both the ways , checks if dictionary has the word */
	public boolean dictionaryContains(String word) {
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
		int size = dictionary.length;
		for(int i=0;i<size;i++) {
			if(dictionary[i].compareTo(word) == 0)
				return true;
		}
		return false;
	}
	
	// method 1 - recursion
	public boolean wordBreak(String str) {
		int size = str.length();
		
		// best case 
		if (size == 0) return true;
		
		// try all prefixes from 1 to end
		for(int i=1;i<size;i++) {
			// The parameter for dictionaryContains is str.substr(0, i)
	        // str.substr(0, i) which is prefix (of input string) of
	        // length 'i'. We first check whether current prefix is in
	        // dictionary. Then we recursively check for remaining string
	        // str.substr(i, size-i) which is suffix of length size-i
			if(dictionaryContains(str.substring(0, i)) && wordBreak(str.substring(i, size-i)));
			return true;
		}
		
		// If we have tried all prefixes and none of them worked
	    return false;
	}
	
	// method 2 - dynamic programming
	public boolean wordBreakDP(String str) {
		int size = str.length();
		// best case 
		if (size == 0) return true;
		// Create the DP table to store results of subroblems. The value wb[i]
	    // will be true if str[0..i-1] can be segmented into dictionary words,
	    // otherwise false.
		boolean wb[] = new boolean[size+1];
		for(int k=0;k<wb.length;k++)
			wb[k] = false;
		
		for(int i=1;i<size;i++) {
			
			// if wb[i] is false, then check if current prefix can make it true.
	        // Current prefix is "str.substr(0, i)"
			if(wb[i] == false && dictionaryContains(str.substring(0, i)))
				wb[i] = true;
			
			// wb[i] is true, then check for all substrings starting from
	        // (i+1)th character and store their results.
			if(wb[i] == true) {
				// if we have reached the last prefix
				if(i == size) 
					return true;
				for(int j=i+1;j<size;j++) {
					// Update wb[j] if it is false and can be updated
	                // Note the parameter passed to dictionaryContains() is
	                // substring starting from index 'i' and length 'j-i'
					if(wb[j] == false && dictionaryContains(str.substring(i, j-i)));
						wb[j] = true;
						
					if(wb[j] == true && i == size)
						return true;
				}
			}
		}
		// If we have tried all prefixes and none of them worked
	    return false;
	}
 	
	public static void main(String[] args) {
		// Trial of the initial version
		WordBreak wb = new WordBreak();
		if(wb.wordBreak("ilikeicecream"))
			System.out.println("Contains");
		else
			System.out.println("Does not contain");
		
//		if(wb.wordBreak("iiiiiiii"))
//			System.out.println("Contains");
//		else
//			System.out.println("Does not contain");
//		
//		if(wb.wordBreakDP("iiiiiiii"))
//			System.out.println("Contains");
//		else
//			System.out.println("Does not contain");
		
		if(wb.wordBreak("ilikelikeimangoiii")) 
			System.out.println("Contains"); 
		else
		System.out.println("Does not contain");
		
	}

}
