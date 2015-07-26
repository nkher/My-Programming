package PalantirQuestions;

import java.util.Arrays;

public class EditDistance {

	public static final int START = -1;
	public static final int EDIT_COST = 1;
	public static final String STRING_X = "eatsb";
	public static final String STRING_Y = "ebtng";
	// public static final String STRING_X = "SATURDAY";
	// public static final String STRING_Y = "SUNDAY";

	// Method 1 using recursion
	public static int editDistanceRecursion(char X[], char Y[], int m, int n) {
		
		// base case
		if (m == 0 && n == 0) 
			return 0;
		// other 2 base cases when any one is smaller and reaches zero first
		if ( m == 0 )
			return n;
		if ( n == 0 )
			return m;
		
		// Recurse
		// Here we try converting X[1 to i-1] to Y[1 to j] .. in short we are reducing the problem (we also add 1)
		// Example we have EATY and EBT .. to find E(4, 3) .. we will remove 'Y' from the first string and find E(3, 3)
		int left = editDistanceRecursion(X, Y, m-1, n) + 1;  // this is for deletion
		
		// Here we try converting X[1 to i] to Y[1 to j-1] .. in short we are reducing the problem (we also add 1)
		// Example we have EAT and EBTS .. to find E(4, 3) .. we will insert 'S' at the end of the first string and find E(4, 4)
		int right = editDistanceRecursion(X, Y, m, n-1) + 1; // this is for insertion
		
		int R = X[m-1] != Y[n-1] ? 1 : 0; // 1 is for replacement if they are not equal else 0
		int corner = editDistanceRecursion(X, Y, m-1, n-1) + R;
		
		return Math.min(Math.min(left, right), corner);
	}
	
	// Method 1 using dynamic programming
	public static int editDistanceDP(char X[], char Y[]) {
		// Cost of alignment
		int cost = 0;
		int leftcell, topcell, cornercell;
		
		int m = X.length+1;
		int n = Y.length+1;
		
		int T[][] = new int[m][n];
		
		// initialize table to -1
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				T[i][j] = START;
			}
		}
		
		// base cases
		// T[i][0] = i
		for (int i=0;i<m;i++) {
			T[i][0] = i;
		}
		
		// T[0][j] = j
		for (int j=0;j<n;j++) {
			T[0][j] = j;
		}
		
		// Build T in top down fashion
		for (int i=1;i<m;i++) {
			for (int j=1;j<n;j++) {
				// T[i][j-1]
				leftcell = T[i][j-1];
				leftcell += EDIT_COST; //deletion
				
				// T[i-1][j]
				topcell = T[i-1][j]; // insertion
				topcell += EDIT_COST;
				
				// Top left corner cell
				// T[i-1][j-1]
				cornercell = T[i-1][j-1];
				
				int replacement = X[i-1] != Y[j-1] ? 1 : 0;
				// Add the replacement cost to the corner cell (Could be one or zero)
				
				cornercell += replacement;
				
				// Minimum cost of current cell
				// Fill in the next cell T[i][j]
				T[i][j] = Math.min(Math.min(leftcell, topcell), cornercell);
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		
		cost = T[m-1][n-1];
		return cost;
	}
	
	public static void main(String[] args) {
				
		char X[] = EditDistance.STRING_X.toCharArray(); // vertical
	    char Y[] = EditDistance.STRING_Y.toCharArray(); // horizontal

//	    int answer = editDistanceRecursion(X, Y, X.length, Y.length);
//	    System.out.println("Minimum edits required to convert " + Arrays.toString(X) + " "
//	    		+ "into " + Arrays.toString(Y) + " is " + answer +  " by recursion\n");
	   	    
	    int ans = editDistanceDP(X, Y);
	    System.out.println("Minimum edits required to convert " + Arrays.toString(X) + "\n "
	    		+ "into " + Arrays.toString(Y) + "\n is " + ans +  " by dynamic programming\n");
	}

}
