package DP;

import stackqueue_tusharroy.MaxHistogram;

public class MaxRectSubmatrix1s {
	
	/**
	 * Time complexity - O(rows*cols)
	 * Space complexity - O(cols) - if number of cols is way higher than rows
	 * 
	 */
	
	public static int maxSubMatrixSize(int input[][]) {
		
		MaxHistogram mh = new MaxHistogram();
		int temp[] = new int[input[0].length];
		int maxArea = 0, area = 0;
		
		for (int i=0;i<input.length;i++) {		
			for (int j=0;j<temp.length;j++) { /* This inner loop copies the array */
				if (input[i][j] == 0)
					temp[j] = 0;
				else
					temp[j] += input[i][j];
			}		
			/* Calculate the max area here */
			area = mh.maxHistogram(temp);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}
	
	public static void main(String[] args) {

		 int input[][] = {{1,1,1,0},
                 		  {1,1,1,1},
                 		  {0,1,1,0},
                 		  {0,1,1,1},
                 		  {1,0,0,1},
                 		  {1,1,1,1}};
		 
		 System.out.println("Max rectangle size is: " + maxSubMatrixSize(input));
	}
}
