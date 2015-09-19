package Bloomberg;

public class MinCostPath {

	// from (0, 0) to (m, n)
	public static int minCost(int cost_array[][], int m, int n) {
		if (n < 0 || m < 0) 
			return Integer.MAX_VALUE;
		else if (m == 0 && n == 0)
			return cost_array[m][n];
		else 
			return cost_array[m][n] + Math.min( minCost(cost_array, m-1, n-1), 
					Math.min(minCost(cost_array, m-1, n), minCost(cost_array, m, n-1)));
	}
	
	// tc = O(mn), // from (0, 0) to (m, n)
	public static int minCostDP(int cost_array[][], int m, int n) {
		int i, j;
		int tc[][] = new int[m+1][n+1];
		
		tc[0][0] = cost_array[0][0]; // setting the cost for the first position
		
		// initialize the first row of the tc array
		for (i=1;i<=m;i++) {
			tc[0][i] = cost_array[0][i] + tc[0][i-1];
		}
		
		// init the first col of the tc array
		for (j=1;j<=n;j++) {
			tc[j][0] = cost_array[j][0] + tc[j-1][0];
		}
		
		// fill the rest of the array
		for (i=1;i<=m;i++) {
			for (j=1;j<=n;j++) {
				
				tc[i][j] = Math.min(tc[i-1][j-1], Math.min(tc[i-1][j], tc[i][j-1])) + cost_array[i][j];
			}
		}
		
		return tc[m][n];
	}
	
	// from bottom left that is (m, 0) to (0, n) you just need to change the indices for the tc array filling.
	
	public static void main(String[] args) {
		
		int a[][] = { {1, 2, 3},
                	  {4, 8, 2},
                	  {1, 5, 3} };
		
		System.out.println("Minimum cost to reach from (0, 0) to (m, n) is : " + minCost(a, 2, 2));
		
		System.out.println("Minimum cost to reach from (0, 0) to (m, n) is : " + minCostDP(a, 2, 2));

	}

}
