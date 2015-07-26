package org.DynamicPrograming;

public class Find2DMaxSub {
	
	public final int COL = 5;
	public final int ROW = 4;
	
	public int kadane(int arr[], int start, int finish, int size) {
		
		int local_start=0, maxSum=Integer.MIN_VALUE, sum=0, i;
		finish = -1;
		
		// Works is there are positive numbers
		for (i=0; i<size; i++) {	
			sum = sum + arr[i];
			if (sum < 0){
				sum = 0;
				local_start = i+1;
			}
			else if (maxSum < sum) {
				maxSum = sum;
				start = local_start;
				finish = i;
			}
		}
		if (finish != -1)
			return maxSum;
		
		// Now handling of all the numbers in the 2d array are negative
		start = finish = 0;
		maxSum=arr[0];
		for (i=1; i<size; i++) {	
			if (arr[i] > maxSum) {
				maxSum = arr[i];
				start = finish = i;
			}
		}
		return maxSum;
	}
	
	public int[] initializeTempArr(int[] temp) {
		
		for(int i=0; i<temp.length; i++)
			temp[i] = 0;
		return temp;
	}
	
	public void getMaxSub2D(int array[][]) {
		
		array = new int[4][5];
		int finalLeft = 0, finalRight = 0, finalStart = 0, finalFinish = 0;
		int left, right, start = 0, finish = 0, maxSum=Integer.MIN_VALUE, sum=0, i;
		int[] temp = new int[4];
		
		// starting with left most column
		for (left=0; left<COL; ++left) {
			
			// Initializing the temp array to zero
			temp = initializeTempArr(temp);
			
			// iterating over each of the column moving towards the right end
			// start point os that of the left one
			for (right=left; right<COL; ++right) {
				
				// now filling the temp array starting from left index and 
				// adding till the right index at each iteration
				
				for(i=0; i<ROW; ++i) 
					temp[i] += array[i][right];
					
					// Find the maximum sum subarray in temp[]. The kadane() function
		            // also sets values of start and finish.  So 'sum' is sum of
		            // rectangle between (start, left) and (finish, right) which is the
		            //  maximum sum with boundary columns strictly as left and right.
					sum = kadane(temp, start, finish, ROW);
					System.out.println(sum);
					if (sum > maxSum) {
						maxSum = sum;
						finalFinish = finish;
						finalLeft = left;
						finalRight = right;
						finalStart = start;	
					}
				}
			}
		// Printing final values
		System.out.println("Final Finish " + finalFinish);
		System.out.println("Final Start " + finalStart);
		System.out.println("Final Left " + finalLeft);
		System.out.println("Final Right " + finalRight);
		System.out.println("Final maxSum " + maxSum);
	}	
	
	public static void main(String[] args) {
		
		int array[][] = {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
               };
		
		Find2DMaxSub object = new Find2DMaxSub();
		object.getMaxSub2D(array);
	}

}
