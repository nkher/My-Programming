package YouTube;

import java.util.Arrays;

public class GenerateOutput {

	/* This program is not done. 
	 * For example, input aa*bbb*c, the output should be four strings: 
	 * aa0bbb0c, aa0bbb1c, aa1bbb0c, aa1bbb1c
	 */	
	public static void generateOutput(String s) {
		generateOutputHelper(s.toCharArray(), 0);
	}
	
	public static void generateOutputHelper(char c[], int ind) {		
		
		if (ind == c.length) {
			System.out.println(Arrays.toString(c));
			return;
		}
			
		if (c[ind] == '*') {
			c[ind] = '0';
			generateOutputHelper(c, ind + 1);
			
			c[ind] = '1';
			generateOutputHelper(c, ind + 1);
			
			c[ind] = '*'; // Now this is for re-configuring the value to '*' so that 1, 0 can work appropriately, 
			// If we do not do this then control will not come inside this if loop as char at that ind will not be * and be 0 
		} 
		else 
			generateOutputHelper(c, ind + 1);
	}
	
	public static void main(String[] args) {	
		String s = "aa*bbb*c*ee*f*";
		String x = "a**b";
		GenerateOutput.generateOutput(x);	
	}
}
