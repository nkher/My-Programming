package DP;

import java.util.Arrays;

public class CuttingRod {
	
	/* Method 1 - Iterative DP */
	public int cutRod(int price[], int length) {
		
		int max[] = new int[length + 1];
		
		/* The initial cell is always zero therefore we start with 1 */
		for (int i=1;i<=price.length;i++) { // these are the number of cuts
			
			for (int j=i;j<=length;j++) { // this is for the number of cols which is the lengths, refer the explanation
				
				/* 
				 * max profit = max of (value at that position which is value at j  OR 
				 * 						(max in the same row i places behind where i = number of cuts + price for the previous i-1 cut) )
				 */
				max[j] = Math.max(max[j], max[j-i] + price[i-1]);
			}	
			System.out.println(Arrays.toString(max));
		}
		return max[price.length];
	}
	
	public void cuttingRodDP(int prices[], int availableLengths[], int maxLen) {
		
		int maxProfit[][] = new int[availableLengths.length][maxLen+1];
		
		// filling for the maximum profits for the lowest length of rod available
		for (int i=1; i<=maxLen; i++) {
			if (i < availableLengths[0]) {
				maxProfit[0][i] = 0;
			}
			else if (i <= availableLengths[0]){
				maxProfit[0][i] = prices[0];
			}
			else {
				maxProfit[0][i] = (prices[0] * (i / availableLengths[0]));
			}
		}

		// filling for the rest of the lengths of the the rod
		for (int i=1; i<maxProfit.length; i++) {
			for (int j=1; j<maxProfit[i].length; j++) {	
				
				int currLen = availableLengths[i];
				if (j < currLen) {
					maxProfit[i][j] = maxProfit[i-1][j]; // put the value of the top cell
				}
				else {
					maxProfit[i][j] = Math.max(maxProfit[i-1][j]/* cell above */, (prices[i] + maxProfit[i][j-currLen] /* cell which is currLen behind */));
				}
			}
		}
		
		printArr(maxProfit);
	}
	
	public void printArr(int maxProfit[][]) {
		
		for (int i=0; i<maxProfit.length; i++) {
			for (int j=0; j<maxProfit[i].length; j++) {		
				System.out.print(maxProfit[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/* Method 2 - Recursive */
	public int recirsiveMaxValue(int price[], int len) {
		
		if(len <= 0) return 0;
		int maxValue = 0;
		for (int i=0;i<len;i++) {
			
			int val = price[i] + recirsiveMaxValue(price, len-i-1);
			if (maxValue < val) maxValue = val;
		}
		return maxValue;
	}
	
	
	public static void main(String args[]) {
		CuttingRod cr = new CuttingRod();
		int price[] = {2,5,7,8};
		int length = 5;
		System.out.println(cr.cutRod(price, length));
		
		int prices[] = {3, 6, 11, 15};
		int availableLengths[] = {2, 5, 7, 11};
		cr.cuttingRodDP(prices, availableLengths, 12);
		
		
		int prices2[] = {2,5,7,8};
		int availableLengths2[] = {1, 2, 3, 4};
		cr.cuttingRodDP(prices2, availableLengths2, 5);
	}
}
