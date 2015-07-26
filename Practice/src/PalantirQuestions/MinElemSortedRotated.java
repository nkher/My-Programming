package PalantirQuestions;

public class MinElemSortedRotated {

	public static int getSortedRotatedMin(int a[], int left, int right) {
		return modifiedBinarySearch(a, left, right);
	}
	
	private static int modifiedBinarySearch(int a[], int left, int right) {
		if (right < left) return a[0]; // If array is not rotated
		if (left == right) return a[left]; // if there is only one element in the array
		
		int  mid = left + (right - left)/2;
		// Here we check for two cases
		// Case 1
		if (a[mid] < a[mid-1]) return a[mid]; // if current is smaller than previous
		// Case 2
		if (a[mid] > a[mid+1]) return a[mid+1]; // if current is greater than next
		
		else if (a[right] > a[mid]) {
			// means array in order so goto left
			return modifiedBinarySearch(a, left, mid-1); 
		}
			// smaller numers are present on the right part so go there
		return modifiedBinarySearch(a, mid+1, right);
	}
	
	public static void main(String[] args) {
		int a[] = {5, 6, 1, 2, 3, 4};
		int smallestNumber = MinElemSortedRotated.getSortedRotatedMin(a, 0, a.length-1);
		System.out.println("Smallest Number is : " + smallestNumber);
	}

}
