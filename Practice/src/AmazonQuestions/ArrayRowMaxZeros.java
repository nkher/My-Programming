package AmazonQuestions;

public class ArrayRowMaxZeros {

	// The following function checks the incoming double array
	// and returns the index of the Row with maximum zeros
	// Condition: Incoming array contains 0 and 1's 
	// But it does not have any 1's in a row after a 0 occurs
	
	public int getIndexMaxZeros(int array[][]){
		
		int i, mid, rowIndex=-1;
		int minIndex = 4;
		// Performing a binary Search on each row of the array
		// The row having the lowest index from where 0 occurs is the right answer
		
		int start, end;
		for(i=0;i<array.length;i++){

			// Performing Binary Search on each row
			start = 0;
			end = array[i].length-1;
			
			while(start<=end){
				mid = (start+end)/2;
				if(array[i][mid] == 0 && minIndex > mid){
						minIndex=mid;
						rowIndex=i;
						end=mid-1;
				}
				else if (array[i][mid] == 0 && minIndex < mid){
					end=mid-1;
				}
				else //if(array[i][mid] != 0 )
					start=mid+1;
			}
		}
		return rowIndex;
	}
	
//	public static int getRowIndex(int a[][]) {
//		int rIndex = Integer.MAX_VALUE;
//		// iterating through each row
//		for (int i=0;i<a.length;i++) {
//			// Doing a binary search on each row
//			int midIndex = a[i].length/2;
//		}
//	}
	
	public static void main(String[] args) {
		
		int arr[][] =  {{1,1,0,0,0,0},
						{1,1,0,0,0,0},
						{1,1,1,1,1,0},
						{1,1,1,0,0,0},
						{1,0,0,0,0,0}};
		
		ArrayRowMaxZeros object = new ArrayRowMaxZeros();
		int returnIndex = object.getIndexMaxZeros(arr);
		System.out.println("Maximum Number of zeros are in row : " + returnIndex);
	}
}
