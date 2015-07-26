
package BloombergQuestions;


// Given a random array, find all the pairs that sum up to a certain value
public class SumSubPairs {
	
	// Method 1
	// Total T.C = O(nLogn) + O(N)
	// Detects only one pair
	public static int printArrayPairs(int a[], int sum) {
		mergeSort(a); //  Sorting the array int T.C O(nLogn)
		printArray(a);
		int l = 0; // maintains start index
		int r = a.length-1; // maintains the end index
		while(l<r) {
			if ((a[l] + a[r]) == sum) { // Found a pair so print
				System.out.println("Pair Found " + "(" + a[l] + ", " + a[r] + ") ");
				return 1;
			}
			else if ((a[l] + a[r]) > sum) 
				r--;
			else 
				l++;
		}
		return 0;
	}
	
	public static void mergeSort(int array[]) {
		if(array.length < 2) return;
		int mid = array.length/2;
		int left[] =  new int[mid];
		int right[] = new int[array.length - mid];
		int k;
		// Initializing the arrays
		for (k=0;k<left.length;k++) {
			left[k] = array[k];
		}
		for (k=0;k<right.length;k++) {
			right[k] = array[k+mid];
		}
		
		mergeSort(left);
		mergeSort(right);
		merge(left, right, array);
	}
	
	public static void merge(int left[], int right[], int array[]) {
		int i, j, k;
		i = j = k = 0;
		while(i<left.length && j<right.length) {
			if (left[i] < right[j]) {
				array[k] = left[i];
				i++;
				k++;
			}
			else {
				array[k] = right[j];
				j++;
				k++;
			}
		}
		if(i<left.length) {
			array[k] = left[i];
			i++;
			k++;
		}
		if(j<right.length) {
			array[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void printArray(int a[]) {
		for(Integer i : a) {
			System.out.print(i + " ");
		}
	}
	
	// Method 2 using a binary array
	// T.C is O(N)
	public static void getPairsSum(int a[], int sum) {
		boolean binary_map[] = new boolean[100000];
		for (int b=0;b<binary_map.length;b++)
			binary_map[b] = false;
		int temp;
		for (int i=0;i<a.length;i++) {
			temp = sum - a[i];
			if(binary_map[temp] && temp > 0) 
				System.out.println("Pair found " + "(" + a[i] + ", " + temp + ")");
			binary_map[a[i]] = true;
		}
	}
	
	public static void main(String[] args) {
		int a[] = {5,1,3,2,4};
		System.out.print("Original Array : ");
		printArray(a);
		
		System.out.println("\n\nUsing the sort and array traverse method");
		int result = printArrayPairs(a, 6);
		if (result == 0)
			System.out.println("Sorry No Pairs \n");
		
		System.out.println("Using Binary Map Method");
		getPairsSum(a, 6);
	}

}
