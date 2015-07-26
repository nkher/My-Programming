package BloombergQuestions;

public class SumSubArray {

	// Find all the sub arrays whose sum is K
	// 1. Naive solution (Brute Force Approach), T.C --> O(N)
	public void subArraySumNaive(int a[], int sum) {
		int start = 0, end = a.length;
		for (int i=start;i<end;i++) {
			int temp_sum = a[i];
			if(sum == a[i]) printArray(a, i, i);
			for (int j=i+1;i<end-1;j++) {
				temp_sum += a[j];
				if(temp_sum == sum) {
					printArray(a, i, j);
				}
				else if(temp_sum < sum) {
					continue;
				}
				else {
					break;
				}
			}
		}
	}
	
	
	// 2. Better solution, subtracting the first element idea (T.C --> O(N))
	public void subArraySumOofN(int a[], int sum) {
		int length = a.length, sum_temp = a[0];
		int start = 0;
		if(a[0] == sum) printArray(a, 0, 0); 
		for (int i=1;i<length;i++) {
			if(a[i] == sum) printArray(a, i, i);
			sum_temp += a[i];
			if(sum_temp == sum) {
				printArray(a, start, i);
			}
			else if(sum_temp < sum) {
				continue;
			}
			else {
				while (sum_temp > sum) {
					sum_temp -= a[start];
					start++;
					if(sum_temp == sum) printArray(a, start, i);
				}
			}
		}
	}
	
	
	// Helper function to print the array
	private void printArray(int a[], int low, int high) {
		System.out.print("[ ");
		for (int i=low; i<=high;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void main(String[] args) {
		SumSubArray object = new SumSubArray();
		int a[] = {10, 5, 10, 10, 10, 35, 20, 15, 100, 0, 125, 35};
		
		// using first method
		System.out.println("Using brute force");
		object.subArraySumNaive(a, 35);
		
		// using the second method
		System.out.println("Using O(N) method");
		object.subArraySumOofN(a, 35);
	}

}
