package PalantirQuestions;

public class MaxElemIncDec {

	public static int binarySearchMaxNumber(int[] a, int low, int high) {
		if(high == low) return a[high];
		int mid = low + (high-low)/2;
		if (mid == low) return a[low];
		if (a[mid-1] < a[mid] && a[mid+1] < a[mid]) return a[mid];
		if (a[mid] > a[mid-1] && a[mid+1] > a[mid])
			return binarySearchMaxNumber(a, mid+1, high);
		else
			return binarySearchMaxNumber(a, low, mid-1);
	}
	
	public static void main(String[] args) {
		int[] a = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		int maxNum = MaxElemIncDec.binarySearchMaxNumber(a, 0, a.length-1);
		System.out.println("Max number in array is : " + maxNum);
		
		int[] a1 = {1, 3, 50, 10, 9, 7, 6};
		maxNum = MaxElemIncDec.binarySearchMaxNumber(a1, 0, a1.length-1);
		System.out.println("Max number in array is : " + maxNum);
		
		int[] b1 = {1, 100, 50, 10, 9, 7, 6};
		maxNum = MaxElemIncDec.binarySearchMaxNumber(b1, 0, b1.length-1);
		System.out.println("Max number in array is : " + maxNum);
		
		int[] a2 = {120, 100, 80, 20, 0};
		maxNum = MaxElemIncDec.binarySearchMaxNumber(a2, 0, a2.length-1);
		System.out.println("Max number in array is : " + maxNum);
		
		int[] a3 = {240, 150, 120, 100, 80, 20, 0};
		maxNum = MaxElemIncDec.binarySearchMaxNumber(a3, 0, a3.length-1);
		System.out.println("Max number in array is : " + maxNum);
	}

}
