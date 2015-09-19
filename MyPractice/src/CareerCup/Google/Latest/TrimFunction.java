package CareerCup.Google.Latest;

import java.util.Arrays;

public class TrimFunction {
	
	public static char[] trim(String s) {
		
		char[] sarr = s.toCharArray();
		int spaceCount = 0, n = s.length();
		
		for (int i=0; i<n; i++) {
			
			char ch = sarr[i];
			if (ch == ' ') {
				spaceCount++;
			}
			else { // swap here
				while ( (sarr[i] != ' ') && (i < n)) {
					System.out.println(i + " "  + Arrays.toString(sarr));
					swapAt(sarr, i, i-spaceCount);
					i++;
				}
				spaceCount--; // reduce the space count to maintain a gap between next and this word
			}
		}
		
		return sarr;
	}
	
	public static void swapAt(char[] arr, int idx1, int idx2) { // idx1 should have space at the end
		arr[idx2] = arr[idx1];
		arr[idx1] = ' ';
	}
	
	public static void main(String[] args) {
		
		String s = "   Hello World   !";
		System.out.println(Arrays.toString(trim(s)));
	}

}
