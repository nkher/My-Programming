package AmazonQuestions;

public class SearchSortedPivotedArray {
	
	public int pivotedBinarySearch(int a[], int a_s, int num) {
		int pivot = findPivot(a, 0, a_s);
		
		// if there is no pivot then array is not rotated at all
		if(pivot == -1)
			return binarySearch(a, 0, a_s, num);
		
		// if pivot is found then compare with the pivot 
		// and search in the left or the right sub array depending on
		// if it is greater or smaller than the pivot
		if(a[pivot] == num)
			return pivot;
		if(a[0] <= num) 
			return binarySearch(a, 0, pivot-1, num);
		else
			return binarySearch(a, pivot+1, a_s, num);
	}
	
	public int findPivot(int a[], int low, int high) {
		// best cases
		if(high < low) return -1;
		if(high == low) return low;
		
		int mid = low + (high-low)/2;
		if(mid < high && a[mid] > a[mid+1])
			return mid;
		if(low < mid && a[mid] < a[mid-1])
			return mid-1;
		if(a[low] >= a[mid])
			return findPivot(a, low, mid-1);
		else 
			return findPivot(a, mid+1, high);
	}
	
	public int binarySearch(int a[], int low, int high, int num) {
		if(high < low)
			return -1;
		int mid = low + (high-low)/2;
		if(num == a[mid]) 
			return mid;
		else if(num > a[mid])
			return binarySearch(a, mid+1, high, num);
		else
			return binarySearch(a, low, mid-1, num);
	}
	
	public static void main(String[] args) {
		
		SearchSortedPivotedArray obj = new SearchSortedPivotedArray();
		int a[] = { 1, 3, 5, 7, 6, 4, 2 };
		System.out.println(obj.pivotedBinarySearch(a, a.length, 6));
	}

}
