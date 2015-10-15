package DynamicPrograming;

public class WordWrapProblem {
	
	/* 
	 * Space complexity - O(N^2)
	 * Time complexity - O(N^2) 
	 * */
	
	public String wordWrap(String words[], int width) {
		
		int n = words.length;
		int cost[][] = new int[n][n];
		
		/* Now filling the array in the next two for loops
		 * Filling table in top to bottom fashion
		 * */
		for (int i=0;i<n;i++) {
			cost[i][i] = width - words[i].length();
			for (int j=i+1;j<n;j++) {
				cost[i][j] = cost[i][j-1] - words[j].length() - 1; // here we subtract an extra one for the space in between the words
			}
		}
		
		for (int i=0;i<n;i++) {
			for (int j=i;j<n;j++) {
				if (cost[i][j] < 0) 
					cost[i][j] = Integer.MAX_VALUE;
				else 
					cost[i][j] = (int) Math.pow(cost[i][j], 2);
			}
		}
		printDoubleArray(cost);
		
		/* Now getting minimum cost with 2 arrays, 1 for minCost and the other for storing the result 
		 * Both are equal to the size of the number of words
		 * */
		int minCost[] = new int[n];
		int result[] = new int[n];
		
		// starting i and j both at last index
		for (int i=n-1; i>=0; i--) {
			
			minCost[i] = cost[i][n-1]; // min cost for the last position would be the last cell of the table
			result[i] = n;
			for (int j=n-1; j>i; j--) { // Running j from last index till i
				
				if (cost[i][j-1] == Integer.MAX_VALUE) { // Ignore unwanted cells
					continue;
				}
				if (minCost[i] > minCost[j] + cost[i][j-1]) {
					minCost[i] = minCost[j] + cost[i][j-1];
					result[i] = j;
				}
			}
		}
		
		int i=0, j;
		System.out.println("Minimum cost is : " + minCost[0] + "\n");
		StringBuilder sb = new StringBuilder();
		
		do {
			j = result[i];
			for (int k=i;k<j;k++) {
				sb.append(words[k] + " ");
			}
			sb.append("\n");
			i = j;
		}while(j < words.length);
			
		
		return new String(sb);
	}
	
	public void printDoubleArray(int a[][]) {
		int n = a.length;
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		  // String words[] = {"Tushar","likes","to","write","code","at", "free", "time"};
		  String words[] = {"Tushar","Roy","likes","to","code"};
		  WordWrapProblem wwp = new WordWrapProblem();
		  System.out.println(wwp.wordWrap(words, 10));
	}

}
