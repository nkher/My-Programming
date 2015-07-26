package AmazonQuestions;

public class NextGreaterNumber {

	public void getNextLargeNumber(int number[], int n) {
		
		// Step 1
		// First we check from the right most element and find a digit 
		// that is smaller than the previously traversed digit
		int i, j;
		for(i=n-1;i>=0;i--) {
			if (number[i] > number[i-1])
				break;
		}
		
		// Step 2
		// Check if i == 0, means the number has digits in descending order and hence there is no possible way
		if(i == 0) {
			System.out.println("Next Larger number not possible");
			return;
		}
		
		// Now 'i-1' is the index of the digit that is smaller than the ith digit
		// Step 3
		// Search in the right part of the array from index 'i' to 'n' and find the smallest element
		// that is greater than 'i-1'
		int x = number[i-1], smallest = i;
		for (j=i+1;j<n;j++) {
			if (number[j] > x && number[j] < number[smallest])
				smallest = j;
		}
		
		
		// Step 4 
		// Swap the digits at smallest and 'i-1' 
		int temp = number[i-1];
		number[i-1] = number[smallest];
		number[smallest] = temp;
		
		// Step 5 
		// Sort the array from index 'i-1' to n
		//number = bubbleSort(number, i, n);
		
		for(int m=i;m<=n-1;m++) {
			for (int k=i-1;k<=n-m-1;k++) {
				if (number[k] > number[k+1]) {
					int temp1 = number[k+1];
					number[k+1] = number[k];
					number[k] = temp1;
				}
			}
		}
		
		System.out.print("Next number with same set of digits is \n");
		printArray(number);
	}
	
	public void printArray(int a[]) {
		System.out.print("[ ");
		for (int i=0;i<a.length;i++) 
			System.out.print(a[i] + " ");
		System.out.print("]");
	}
	
	public int[] bubbleSort(int a[], int startIndex, int endIndex) {
		for(int i=startIndex;i<=endIndex-1;i++) {
			for (int j=startIndex-1;j<=endIndex-startIndex-1;j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		int number[] = {5, 3, 4, 9, 7, 6};
		NextGreaterNumber ngn = new NextGreaterNumber();
		ngn.getNextLargeNumber(number, number.length);
	}

}
