package BloombergQuestions;

public class ManechersAlgo {
	
	private int min(int x, int y) {
		if(x < y) return x;
		else return y;
	}
	
	public int manecharsAlgo(String s) {
		String hashedString = gethashedString(s);
		int lenHashedString = hashedString.length();
		int P[] = new int[lenHashedString];
		int centre=0, right=0;
		
		for (int i=1;i<lenHashedString;i++) {
			// calculate the mirror of i which is
			// i_mirror = centre - (i - centre) OR (2 * centre-i)
			int iMirror = (2*centre) - i;
			
			// assign the P[i] value
			if(right > i) {
				P[i] = min(right-i, P[iMirror]);
			}
			else {
				P[i] = 0;
			}
			
			// try to expand along the ith character
			while((i-1-P[i] >= 0) && (i+1+P[i] < lenHashedString) && hashedString.charAt(i+1+P[i]) == hashedString.charAt(i-1-P[i])) {
				P[i]++;
			}
//			catch(Exception e) {
//				// can run into index out of bounds hence catching the exception
//			}
			
			// now adjust the values of centre and right variables if at all you exceed
			if(i + P[i] > right) {
				centre = i;
				right = i + P[i];
			}
		}
		
		// get the max element and index in P
		int largestInd = Integer.MIN_VALUE, largestElem = Integer.MIN_VALUE;
		for (int j=1;j<lenHashedString-1;j++) {
			if(P[j] > largestElem) {
				largestElem = P[j];
				largestInd = j;
			}
		}
		
		// now call the function to remove the hashes and get the value for the 
		// correct largest palindrome
		System.out.println(removeHashes(hashedString.substring(largestInd - largestElem, largestInd + largestElem + 1)));
		
		return largestElem;
	}
	
	private String removeHashes(String s) {
		String x = "";
		for (int i=0;i<s.length();i++) {
			if(s.charAt(i) != '#') {
				x += s.charAt(i);
			}
		}
		return x;
	}
	
	private String gethashedString(String s) {
		int len = s.length();
		if(len == 0) return "#";
		String hashedString = "";
		for(int i=0;i<len;i++) {
			hashedString += "#" + s.charAt(i);
		}
		return hashedString;
	}
	
	public static void main(String[] args) {
		
		ManechersAlgo obj = new ManechersAlgo();
		String s1 = "babcbabcbaccba";
		int len = obj.manecharsAlgo(s1);
		System.out.println("Length of largest palindrome is : " + len);
	}
}
