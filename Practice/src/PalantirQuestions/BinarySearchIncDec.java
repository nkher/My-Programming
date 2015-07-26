package PalantirQuestions;

public class BinarySearchIncDec {

	public static int ascendingBinarySearch(int a[], int low, int high, int target) {
		if (low == high) return Integer.MIN_VALUE;
		int mid = low + (high-low)/2;
		if (mid == low) return Integer.MIN_VALUE;
		
		if (a[mid] == target) return mid;
		else if (a[mid] > target) return ascendingBinarySearch(a, low, mid-1, target);
		else return ascendingBinarySearch(a, mid+1, high, target);
	}
	
	public static int descendingBinarySearch(int a[], int low, int high, int target) {
		if (low == high) return Integer.MIN_VALUE;
		int mid = low + (high-low)/2;
		if (a[mid] == target) return mid;
		else if (a[mid] > target) return descendingBinarySearch(a, mid+1, high, target); // do the opposite of the ascending search
		else descendingBinarySearch(a, low, mid-1, target);
		return 0;
	}
	
	// Returns the index of the target number 
	public static int bitonicArraySearch(int a[], int low, int high, int target) {
		if (high  == low) return a[high];
		int mid = low + (high-low)/2;
		boolean max_on_right = false, max_on_left = false;
		if ( a[mid] > a[mid-1] && a[mid] < a[mid+1] ) max_on_right = true;
		if ( a[mid] > a[mid+1] && a[mid] < a[mid-1] ) max_on_left = true;
		System.out.println(mid);
		if ( a[mid] == target ) return mid;
		
		// now check, if element at mid is smaller than target and check where is max
		// depending on that do a bitonic search based on the side of the max
		else if ( a[mid] < target && max_on_right ) 
			return bitonicArraySearch(a, mid+1, high, target);
		
		else if ( a[mid] < target && max_on_left ) 
			return bitonicArraySearch(a, low, mid-1, target);
		
		// else if target number is smaller do ascending binary search on left sub array and 
		// descending binary search on the right sub array
		else if ( a[mid] > target ) {
			int index = ascendingBinarySearch(a, low, mid-1, target);
			if (index != Integer.MIN_VALUE) return index;
			
			int index2 = descendingBinarySearch(a, mid+1, high, target);
			if (index2 != Integer.MIN_VALUE) return index2;
		}
		return mid;
	}
	
	/* Returns the index of the target number */
	public static int bitonicArraySearch2(int a[], int low, int high, int target) {
		if (high  == low) return a[high];
		int mid = low + (high-low)/2;
		boolean max_on_right = false, max_on_left = false;
		if ( a[mid] > a[mid-1] && a[mid] < a[mid+1] ) max_on_right = true;
		if ( a[mid] > a[mid+1] && a[mid] < a[mid-1] ) max_on_left = true;
		
		System.out.println(max_on_right + " " + max_on_left + " " + a[mid]);
		if ( a[mid] == target ) return mid;
		
		// now check, if element at mid is smaller than target and check where is max
		// depending on that do a bitonic search based on the side of the max
		else if ( max_on_right ) 
			return bitonicArraySearch(a, mid+1, high, target);
		
		else if ( max_on_left ) 
			return bitonicArraySearch(a, low, mid-1, target);
		
		// else if target number is smaller do ascending binary search on left sub array and 
		// descending binary search on the right sub array
		else {
			int index = ascendingBinarySearch(a, 0, mid-1, target);
			if (index != Integer.MIN_VALUE) return index;
			int index2 = descendingBinarySearch(a, mid+1, a.length, target);
			if (index2 != Integer.MIN_VALUE) return index2;
		}
		return mid;
	}
	
	public static void main(String[] args) {
		int[] a = {8, 10, 20, 80, 100, 200, 400, 450, 475, 490, 495, 500, 430, 35, 15, 10, 3, 2, 1};
		int index = BinarySearchIncDec.bitonicArraySearch(a, 0, a.length-1, 80);
		System.out.println("Index of target element is " + index + " and element is " + a[index]);
		
	}

}
