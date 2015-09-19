package DP;

public class Knapsack01_Problem {

	public static int[][] kanpsack01(int values[], int weights[], int W) {
		
		/* Creating an array of 
		 * weight values as the number of columns and 
		 * items as the number of rows
		 */
		int K[][] = new int[values.length+1][W+1];
		
		for (int i=0; i<=values.length; i++) {
			
			for (int j=0; j<=W; j++) {
				
				if (i == 0 || j ==0) {
					K[i][j] = 0;
					continue;
				}
				else if (j - weights[i-1] >= 0) 
					K[i][j] = Math.max(K[i-1][j] /* Previous row same col */, 
								K[i-1][j-weights[i-1]] + values[i-1] /* Current weight + weight of previous rows values at col index = (current col - current item weight]  */);
				else 
					K[i][j] = K[i-1][j];
			}
		}
		
        System.out.print(K[values.length][W]);
		return K;
	}
	
	public static int knapsackMaxProfit(int values[], int weights[], int maxWt) {
		
		int totalValues = values.length;
		int knapsackProfit[][] = new int[totalValues][maxWt+1];
		
		// filling for the maximum profits for the lowest length of rod available
		for (int i=1; i<=maxWt; i++) {
			if (i < weights[0]) {
				knapsackProfit[0][i] = 0;
			}
			else {
				knapsackProfit[0][i] = values[0];
			}
		}

		// filling for the rest of the lengths of the the rod
		for (int i=1; i<knapsackProfit.length; i++) {
			for (int j=1; j<knapsackProfit[i].length; j++) {	
				
				int currWeight = weights[i];
				if (j < currWeight) {
					knapsackProfit[i][j] = knapsackProfit[i-1][j]; // put the value of the top cell
				}
				else {
					knapsackProfit[i][j] = Math.max(knapsackProfit[i-1][j]/* cell above */, (values[i] + knapsackProfit[i][j-currWeight] /* cell which is currLen behind */));
				}
			}
		}
		
		System.out.println("maximum profit is : " + knapsackProfit[totalValues-1][maxWt]);
		
		printArr(knapsackProfit);
		
		return knapsackProfit[totalValues-1][maxWt];
	}
	
	public static void printArr(int maxProfit[][]) {
		
		for (int i=0; i<maxProfit.length; i++) {
			for (int j=0; j<maxProfit[i].length; j++) {		
				System.out.print(maxProfit[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printResult(int K[][], int[] values, int W, int[] weights) {
	
		int i = values.length, k = W;
		int j = K[i][k]; // last value in double array
		while (j > 0) {
			
			if (j == K[i-1][k]) {
				i = i-1;
			}
							
			else if (j > K[i-1][k]) {
				System.out.print((i+1) + " ");
				j = K[i-1][k - weights[i-1]];
				i = i-1;
				k = k - weights[i-1];
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
	
		//int val[] = {60,20,15,30};
        //int wt[] = {4,2,3,5};
		int val[] = {1,4,5,7};
        int wt[] = {1,3,4,5};
        int K = knapsackMaxProfit(val, wt, 7);       
	}

}
